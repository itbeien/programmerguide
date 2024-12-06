package com.beien.dao;



import com.beien.entity.SysUserInfo;
import com.beien.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoDao {
    public List<UserInfo> findAll();

    public List<SysUserInfo>findAllSlave();

    public void transferIn(@Param("money") double money,@Param("inName") String inName);

    public void transferOut(@Param("money") double money, @Param("outName") String outName);
}
