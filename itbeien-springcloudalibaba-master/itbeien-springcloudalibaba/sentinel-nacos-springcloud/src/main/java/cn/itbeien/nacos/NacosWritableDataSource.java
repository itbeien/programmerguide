package cn.itbeien.nacos;

import com.alibaba.cloud.sentinel.datasource.config.NacosDataSourceProperties;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.WritableDataSource;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author beien
 * @date 2024-04-03 21:24
 * Copyright© 2024 beien
 * sentinel规则持久化到 Nacos
 */
@Slf4j
public class NacosWritableDataSource<T> implements WritableDataSource<T> {
    private NacosDataSourceProperties nacosDataSourceProperties;
    private ConfigService configService;
    private final Converter<T, String> configEncoder;
    /**
     * 可重入锁
     */
    private final Lock lock = new ReentrantLock(true);

    public NacosWritableDataSource(NacosDataSourceProperties nacosDataSourceProperties, Converter<T, String> configEncoder) {
        this.nacosDataSourceProperties = nacosDataSourceProperties;
        this.configEncoder = configEncoder;
        // 初始化 Nacos configService
        initConfigService();
    }

    /**
     * nacos工厂类创建配置中心服务类 NacosFactory
     */
    private void initConfigService(){
        try {
            this.configService = NacosFactory.createConfigService(buildProperties(nacosDataSourceProperties));
        } catch (NacosException e) {
            log.error("initConfigService error:{} ",e);
        }
    }

    private Properties buildProperties(NacosDataSourceProperties nacosDataSourceProperties) {
        Properties properties = new Properties();
        if (!StringUtils.isEmpty(nacosDataSourceProperties.getServerAddr())) {
            properties.setProperty(PropertyKeyConst.SERVER_ADDR, nacosDataSourceProperties.getServerAddr());
        } else {
            properties.setProperty(PropertyKeyConst.ACCESS_KEY, nacosDataSourceProperties.getAccessKey());
            properties.setProperty(PropertyKeyConst.SECRET_KEY, nacosDataSourceProperties.getSecretKey());
            properties.setProperty(PropertyKeyConst.ENDPOINT, nacosDataSourceProperties.getEndpoint());
        }
        if (!StringUtils.isEmpty(nacosDataSourceProperties.getNamespace())) {
            properties.setProperty(PropertyKeyConst.NAMESPACE, nacosDataSourceProperties.getNamespace());
        }
        if (!StringUtils.isEmpty(nacosDataSourceProperties.getUsername())) {
            properties.setProperty(PropertyKeyConst.USERNAME, nacosDataSourceProperties.getUsername());
        }
        if (!StringUtils.isEmpty(nacosDataSourceProperties.getPassword())) {
            properties.setProperty(PropertyKeyConst.PASSWORD, nacosDataSourceProperties.getPassword());
        }
        return properties;
    }

    /**
     * 发布新的配置到nacos配置中心
     * @param value
     * @throws Exception
     */
    @Override
    public void write(T value) throws Exception {
        lock.lock();
        try {
            // 发布新配置
            configService.publishConfig(nacosDataSourceProperties.getDataId(), nacosDataSourceProperties.getGroupId(), this.configEncoder.convert(value), ConfigType.JSON.getType());
        } catch (Exception e) {
            throw e;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void close() throws Exception {

    }

}
