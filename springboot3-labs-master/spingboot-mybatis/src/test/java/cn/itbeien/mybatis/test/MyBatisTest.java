package cn.itbeien.mybatis.test;


import cn.itbeien.mybatis.dao.SysUserMapper;
import cn.itbeien.mybatis.entity.SysUser;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@SpringBootTest
public class MyBatisTest {
    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> userList = sysUserMapper.selectByExample(null);
        Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
