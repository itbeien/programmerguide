package com.beien.datasource;

import com.beien.service.ISaasModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.beien.enums.DbReadWriteModel;

/**
 * 加载数据源
 */
@Component("dynDataSourceCache")
public class DynDataSourceCache {

    @Autowired
    private ISaasModuleService saasModuleService;

	//KEY 租户+dbMode , value DatabaseConfig.ID
    private Map<String,  List<Integer>> tenantToDBMap = new ConcurrentHashMap<>();


    public Integer getDataSourceKey(String tenantCode, DbReadWriteModel dbReadWriteModel){

    	final String tenantMapKey = tenantCode + dbReadWriteModel.toString();

        if(this.tenantToDBMap.size() == 0){
            loadTenantDataSource();
        }

        Integer databaseId = null;
        if(tenantToDBMap.containsKey(tenantMapKey)){
            Integer tenantSize = tenantToDBMap.get(tenantMapKey).size();
            if(tenantSize == 0){
                return null;
            }
            databaseId = tenantToDBMap.get(tenantMapKey).get(randomNumber(tenantToDBMap.get(tenantMapKey).size()));
        } else {

        	Map<String,  List<Integer>> tempMap = this.saasModuleService.loadTenantConfig(tenantCode);
        	tenantToDBMap.putAll(tempMap);
        	if(tenantToDBMap.get(tenantMapKey) == null){
        	    return null;
            }
        	databaseId = tenantToDBMap.get(tenantMapKey).get(randomNumber(tenantToDBMap.get(tenantMapKey).size()));
        }
        return databaseId;
    }

    //系统启动时加载所有数据源
    @PostConstruct
    public void loadTenantDataSource(){
        //加载租户数据源
       /* tenantToDBMap = this.saasModuleService.loadTenantDataSource();*/
    }

    private int randomNumber(int max){
        int min = 0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }

    //key 租户+dbMode
    public void removeTenantToDBMap(String key, Integer dataBaseId){
        List<Integer>  dataBaseIds = tenantToDBMap.get(key);
        if(dataBaseIds != null){
            dataBaseIds.remove(dataBaseId);
            if(0==dataBaseIds.size()){
                tenantToDBMap.remove(key);
            }else {
                tenantToDBMap.put(key, dataBaseIds);
            }
        }
    }
}
