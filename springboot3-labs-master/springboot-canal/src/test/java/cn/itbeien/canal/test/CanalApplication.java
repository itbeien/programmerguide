package cn.itbeien.canal.test;

import cn.itbeien.canal.util.CanalUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@SpringBootTest
public class CanalApplication {
    @Autowired
    private CanalUtil canalUtil;
    @Test
    public void test(){
        this.canalUtil.startMonitorSQL();
    }
}
