package com.beien.service.impl;

import com.beien.dao.UserDao;
import com.beien.pojo.UserInfo;
import com.beien.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Resource
    private UserDao userDao;

    @Transactional
    @Override
    public List<UserInfo> findUser() {
        return userDao.selectAll();
    }
}
