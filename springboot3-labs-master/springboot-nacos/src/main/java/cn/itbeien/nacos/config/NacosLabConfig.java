package cn.itbeien.nacos.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class NacosLabConfig {

    //@NacosValue(value = "${nacos.lab.key}",autoRefreshed = true)
    @Value(value = "${nacos.lab.key}")
    private String key;
}
