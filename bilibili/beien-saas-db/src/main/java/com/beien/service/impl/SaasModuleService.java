package com.beien.service.impl;

import com.beien.dao.saasdb.TenantConfigDao;
import com.beien.entity.DatabaseConfig;
import com.beien.service.ISaasModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class SaasModuleService implements ISaasModuleService {
	@Autowired
	private TenantConfigDao tenantConfigDao;

	private static Map<String,String> tenantCodeMap = new HashMap<>();

	private static Map<String,String> masterTenantCodeMap = new HashMap<>();
	private static Map<String,Integer> masterDBMap = new HashMap<>();


	
/*	private void doListAddMapLogic(Map<String, List<Integer>> tenantDataSource, TenantConfigVO tenantConfigVO) {
		
		
		String mapKey = tenantConfigVO.getTenantCode() + tenantConfigVO.getDbModel();
		
		if(tenantDataSource.containsKey(mapKey)){
			tenantDataSource.get(mapKey).add(tenantConfigVO.getDatabaseId());
		} else {
			List<Integer> dbList = new ArrayList<>();
			dbList.add(tenantConfigVO.getDatabaseId());
			tenantDataSource.put(mapKey, dbList);
		}
	}*/



	
	
	@Override
	public DatabaseConfig loadDatabaseConfig(Integer databaseId) {
		return tenantConfigDao.findDatabaseConfigByDatabaseId(databaseId);
	}

	
	public static void cleanMap() {
		 tenantCodeMap.clear();
		 masterTenantCodeMap.clear();
	}

}
