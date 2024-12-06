package com.beien.service.impl;

import com.beien.annotation.DS;
import com.beien.constants.DataSourceConstants;
import com.beien.dao.UserInfoDao;
import com.beien.entity.SysUserInfo;
import com.beien.entity.UserInfo;
import com.beien.mutiltransaction.MutilTransactional;
import com.beien.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.beien.DynamicDataSourceContextHolder;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author beien
 * @date 2023/3/13 16:27
 * Copyright© 2023 beien
 */
@Service
@Slf4j
public class TestService implements ITestService {
    @Resource
    private UserInfoDao userInfoDao;
    @Resource
    private com.beien.service.impl.IUserService userService;
    /**
     * 查询主库中的数据
     */
    //@Transactional
    @DS(DataSourceConstants.DS_KEY_MASTER)
    public List<UserInfo> query(){
        log.info("查询主数据库....");
        //查询主库
        return userInfoDao.findAll();//
    }


    @DS(DataSourceConstants.DS_KEY_SLAVE)
    public List<SysUserInfo> querySlave(){
        DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DS_KEY_SLAVE);//后续解决，需要加这段代码才能切换，方法上的注解没有生效
        //查询从库
        log.info("查询从数据库....");
       return userInfoDao.findAllSlave();
    }

    /**
     * 转出  ----从库
     */
    //@DS(DataSourceConstants.DS_KEY_SLAVE)
    //@Transactional(rollbackFor = Exception.class)
    @MutilTransactional(dataBase=DataSourceConstants.DS_KEY_SLAVE)
    //@DS(DataSourceConstants.DS_KEY_SLAVE)
    public void transOut() throws Exception{
        //DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DS_KEY_SLAVE);
        this.userInfoDao.transferOut(100,"贝恩");
        //恢复数据源
        //DynamicDataSourceContextHolder.removeContextKey();
        this.userService.transIn();//切换主库 转入
        throw  new Exception("转账异常");
    }

    /**
     * 转入  ---主库
     * @throws Exception
     */
    //@DS(DataSourceConstants.DS_KEY_MASTER)
    //@Transactional(rollbackFor = Exception.class)
   @MutilTransactional(dataBase = DataSourceConstants.DS_KEY_MASTER)
    public void transIn()throws Exception{
        this.userInfoDao.transferIn(100,"小明");
        //throw  new Exception("转账异常");
    }

    //@Transactional(rollbackFor = Exception.class)
    @DS(DataSourceConstants.DS_KEY_SLAVE)
    //@Transactional(rollbackFor = Exception.class)
    //主库，从库 Transactional只支持单机事务
    public void tran() throws Exception{
        transOut();//默认主库，切换数据库失败
        //恢复数据源
        DynamicDataSourceContextHolder.removeContextKey();
        transIn();//主库
        DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DS_KEY_SLAVE);
        transOut();//从库
        throw new Exception("转账异常");
    }
}
