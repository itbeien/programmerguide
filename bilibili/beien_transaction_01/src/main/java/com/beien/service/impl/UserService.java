package com.beien.service.impl;

import com.beien.dao.UserDao;
import com.beien.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService implements IUserService {
    @Resource
    private UserDao userDao;

    //1.标注错误的异常类型 //默认捕捉的是 RunntimeException
    @Transactional(rollbackFor = Exception.class)
    public void transfer(String inName, String outName, double money) throws Exception{
        userDao.transferIn(inName,money);//向账户转入钱
        //int i = 1/0;
        userDao.transferOut(outName,money);//向账户转出钱
        //int i = 1/0;
        throw new Exception("系统异常");
    }

    //2.不正确的捕获异常
    @Transactional
    public void transfer1(String inName, String outName, double money){
        try {
            userDao.transferIn(inName,money);
            //int i = 1/0;
            userDao.transferOut(outName,money);
            int i = 1/0;
        }catch (RuntimeException e){
            System.out.println("系统异常:"+e);
            throw e;
        }
    }

    //3.方法的事务传播类型不支持事务
}
