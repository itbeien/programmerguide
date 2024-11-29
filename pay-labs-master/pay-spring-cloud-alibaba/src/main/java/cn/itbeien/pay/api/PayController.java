package cn.itbeien.pay.api;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class PayController {

    @PostMapping("/pay")
    public String pay(@RequestBody JSONObject data){
        log.info("进入测试接口...{}",data);
        return "ok";
    }
}
