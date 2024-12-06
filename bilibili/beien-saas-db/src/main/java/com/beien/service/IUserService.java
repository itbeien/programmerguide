package com.beien.service.impl;


import com.beien.entity.UserInfo;

public interface IUserService {
    public UserInfo findUserAll();
    public  void transIn()throws Exception;
}
