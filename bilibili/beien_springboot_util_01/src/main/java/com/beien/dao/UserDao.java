package com.beien.dao;

import com.beien.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface UserDao {
    public List<UserInfo> selectAll();
}
