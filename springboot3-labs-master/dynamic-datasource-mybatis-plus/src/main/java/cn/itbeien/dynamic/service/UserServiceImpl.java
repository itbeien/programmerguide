package cn.itbeien.dynamic.service;

import cn.itbeien.dynamic.mapper.SysUserMapper;
import com.baomidou.dynamic.datasource.annotation.DS;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * 没有@DS	默认数据源
 * @DS("dsName") dsName可以为组名也可以为具体某个库的名称
 * Copyright© 2024 itbeien
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 没有添加多数据源注解，默认访问主库
     */
    @Override
    public List selectAll() {
        return sysUserMapper.selectList(null);
    }


    /**
     * 添加多数据源注解，访问第一个从库
     */
    @DS("slave_1")
    @Override
    public List selectAllSlave01() {
        return sysUserMapper.selectList(null);
    }

    /**
     * 添加多数据源注解，访问第二个从库
     */
    @DS("slave_2")
    @Override
    public List selectAllSlave02() {
        return sysUserMapper.selectList(null);
    }
}
