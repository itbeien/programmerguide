package com.beien;

import com.beien.dao.DBDao;
import com.beien.entity.SysUserInfo;
import com.beien.entity.UserInfo;
import com.beien.mutiltransaction.EnableMutilTranactionManagement;
import com.beien.service.IDBService;
import com.beien.service.ITestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * Springboot动态数据源创建的两种方式
 * 1.通过配置文件配置
 * 2.通过数据库动态配置
 * 今天我们来实现第一种
 */
@SpringBootTest
@EnableMutilTranactionManagement
class BeienSaasDbApplicationTests {
    @Resource
	private DBDao dbDao;

	@Resource
	private ITestService testService;

	@Resource
	private IDBService dbService;
	@Test
	void contextLoads() {
		//this.dbDao.executeCreateDB("testdb");
		//查询主库
		List<UserInfo> userInfoList = this.testService.query();
		//查询从库
		List<SysUserInfo> sysUserInfoList = this.testService.querySlave();
	}


	@Test
	void contextLoads1() throws Exception{
		//this.dbDao.executeCreateDB("testdb");
		//查询主库  单库事务
		//this.testService.transOut();//事务失效，转账成功
		this.testService.transOut();
		//this.testService.tran();
		//this.testService.transOut();
	}

	@Test
	void contextLoads2(){
		dbService.executeCreateTableSQL();
	}

}
