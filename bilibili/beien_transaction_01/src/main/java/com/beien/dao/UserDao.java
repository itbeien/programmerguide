package com.beien.dao;

import com.beien.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public List<UserInfo> selectAll();
    //转入
    public void transferIn(@Param("inName") String inName, @Param("money")double money);

    //转出
    public void transferOut(@Param("outName")String outName, @Param("money")double money);
}
