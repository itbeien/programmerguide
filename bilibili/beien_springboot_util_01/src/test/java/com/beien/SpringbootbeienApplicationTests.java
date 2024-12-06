package com.beien;

import com.beien.pojo.UserInfo;
import com.beien.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootbeienApplicationTests {
    @Resource
    public IUserService userService;
    @Test
    void contextLoads() {
        List<UserInfo> user = userService.findUser();
        System.out.println(user.size());
    }

}
