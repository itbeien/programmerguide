package cn.itbeien.dynamic;

import cn.itbeien.dynamic.entity.SysUser;
import cn.itbeien.dynamic.mapper.SysUserMapper;
import cn.itbeien.dynamic.service.UserService;
import com.baomidou.dynamic.datasource.annotation.DS;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
@SpringBootTest
public class DynamicTest {
    @Autowired
    private UserService userServiceImpl;

    /**
     * 查询master库 dynamic01
     */
    @Test
    public void testMasterSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> userList = userServiceImpl.selectAll();
        Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    /**
     * 查询slave_1库 dynamic02
     */
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> userList = userServiceImpl.selectAllSlave01();
        Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }


    /**
     * 查询slave_2库 dynamic03
     */
    @Test
    public void test02Select() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> userList = userServiceImpl.selectAllSlave02();
        Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
