package cn.itbeien.service.feign;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 */
@FeignClient(value = "ecard")
public interface PayFeign {
    @RequestMapping(value = "/api/pay",method = RequestMethod.POST)
    String orderFromClient(JSONObject jsonObject);

    @RequestMapping(value = "/api/sign",method = RequestMethod.POST)
    String signFromClient(JSONObject jsonObject);
}

