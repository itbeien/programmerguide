package com.beien.service;


import com.beien.entity.DatabaseConfig;
import com.beien.exception.DtComponentException;

import java.util.List;
import java.util.Map;

public interface ISaasModuleService {
	/*public Map<String, List<Integer>>  loadTenantConfig(String tenantCode);*/
	
	public DatabaseConfig loadDatabaseConfig(Integer databaseId);
	
/*	public Map<String, List<Integer>> loadTenantDataSource();

	public String getTenantByBussinessObjCode(String bussinessObjCode);

	public Integer getMasterDBByTenantCode(String tenantCode) throws DtComponentException;*/
}
