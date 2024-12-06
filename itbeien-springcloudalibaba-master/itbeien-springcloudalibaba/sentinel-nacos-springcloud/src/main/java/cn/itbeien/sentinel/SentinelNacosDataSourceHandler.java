package cn.itbeien.sentinel;

import cn.itbeien.nacos.NacosWritableDataSource;
import com.alibaba.cloud.sentinel.SentinelProperties;
import com.alibaba.cloud.sentinel.datasource.RuleType;
import com.alibaba.cloud.sentinel.datasource.config.DataSourcePropertiesConfiguration;
import com.alibaba.cloud.sentinel.datasource.config.NacosDataSourceProperties;
import com.alibaba.csp.sentinel.command.handler.ModifyParamFlowRulesCommandHandler;
import com.alibaba.csp.sentinel.datasource.WritableDataSource;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.system.SystemRule;
import com.alibaba.csp.sentinel.transport.util.WritableDataSourceRegistry;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.SmartInitializingSingleton;

import java.util.List;

/**
 * @author beien
 * @date 2024-04-03 21:28
 * Copyright© 2024 beien
 * sentinel 规则持久化到 nacos 处理器
 */
public class SentinelNacosDataSourceHandler implements SmartInitializingSingleton {

    private final SentinelProperties sentinelProperties;

    public SentinelNacosDataSourceHandler(SentinelProperties sentinelProperties) {
        this.sentinelProperties = sentinelProperties;
    }
    //实现SmartInitializingSingleton 的接口后，当所有非懒加载的单例Bean 都初始化完成以后，Spring 的IOC 容器会调用该接口的 afterSingletonsInstantiated() 方法
    @Override
    public void afterSingletonsInstantiated() {
        sentinelProperties.getDatasource().values().forEach(this::registryWriter);
    }

    private void registryWriter(DataSourcePropertiesConfiguration dataSourceProperties) {
        final NacosDataSourceProperties nacosDataSourceProperties = dataSourceProperties.getNacos();
        if (nacosDataSourceProperties == null) {
            return;
        }
        final RuleType ruleType = nacosDataSourceProperties.getRuleType();
        // 通过数据源配置的 ruleType 来注册数据源
        switch (ruleType) {
            case FLOW:
                WritableDataSource<List<FlowRule>> flowRuleWriter = new NacosWritableDataSource<>(nacosDataSourceProperties, JSON::toJSONString);
                WritableDataSourceRegistry.registerFlowDataSource(flowRuleWriter);
                break;
            case DEGRADE:
                WritableDataSource<List<DegradeRule>> degradeRuleWriter = new NacosWritableDataSource<>(nacosDataSourceProperties, JSON::toJSONString);
                WritableDataSourceRegistry.registerDegradeDataSource(degradeRuleWriter);
                break;
            case PARAM_FLOW:
                WritableDataSource<List<ParamFlowRule>> paramFlowRuleWriter = new NacosWritableDataSource<>(nacosDataSourceProperties, JSON::toJSONString);
                ModifyParamFlowRulesCommandHandler.setWritableDataSource(paramFlowRuleWriter);
                break;
            case SYSTEM:
                WritableDataSource<List<SystemRule>> systemRuleWriter = new NacosWritableDataSource<>(nacosDataSourceProperties, JSON::toJSONString);
                WritableDataSourceRegistry.registerSystemDataSource(systemRuleWriter);
                break;
            case AUTHORITY:
                WritableDataSource<List<AuthorityRule>> authRuleWriter = new NacosWritableDataSource<>(nacosDataSourceProperties, JSON::toJSONString);
                WritableDataSourceRegistry.registerAuthorityDataSource(authRuleWriter);
                break;
            default:
                break;
        }
    }
}

