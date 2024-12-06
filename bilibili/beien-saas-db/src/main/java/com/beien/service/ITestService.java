package com.beien.service;

import com.beien.entity.SysUserInfo;
import com.beien.entity.UserInfo;

import java.util.List;

/**
 * @author beien
 * @date 2023/3/14 9:09
 * Copyright© 2023 beien
 */
public interface ITestService {
    public List<UserInfo> query();
    public List<SysUserInfo> querySlave();

    public  void transIn()throws Exception;
    public  void transOut()throws Exception;

    public void tran()throws Exception;
}
