package com.beien.service.impl;

import com.beien.constants.DataSourceConstants;
import com.beien.dao.UserInfoDao;
import com.beien.entity.UserInfo;
import com.beien.mutiltransaction.MutilTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements com.beien.service.impl.IUserService {
    @Resource
    private UserInfoDao userInfoDao;

    @Transactional
    @Override
    public UserInfo findUserAll() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("test");
        userInfo.setId(1001);
        userInfo.setAge(10);
        List<UserInfo> users = userInfoDao.findAll();

        if(users.size()>0){
            userInfo  = users.get(0);
        }
        return userInfo;
    }

    @MutilTransactional(dataBase = DataSourceConstants.DS_KEY_MASTER)
    public void transIn()throws Exception{
        this.userInfoDao.transferIn(100,"小明");
        //throw  new Exception("转账异常");
    }
}
