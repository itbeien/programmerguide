package cn.itbeien.mybatis.dao;

import cn.itbeien.mybatis.entity.SysUser;
import cn.itbeien.mybatis.entity.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser row);

    int insertSelective(SysUser row);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") SysUser row, @Param("example") SysUserExample example);

    int updateByExample(@Param("row") SysUser row, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser row);

    int updateByPrimaryKey(SysUser row);
}