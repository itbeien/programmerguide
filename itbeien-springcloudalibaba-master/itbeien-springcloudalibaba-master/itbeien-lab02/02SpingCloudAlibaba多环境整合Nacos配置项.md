# SpringCloudAlibaba(微服务)多环境下配置项解决方案-基于Nacos

- 在开发项目过程中，我们会遇到不同的环境和不同配置项维护切换问题
- 在SpringCloudAlibaba微服务解决方案中，应用Nacos高级特性在微服务项目中可以解决该问题

## 1 Spring profile多环境配置

spring-cloud-starter-alibaba-nacos-config 组件在加载服务配置项时会同时加载dataId 为 ${spring.application.name}.${file-extension:properties} 为前缀的基础配置和dataId 为 ${spring.application.name}-${profile}.${file-extension:properties} 的基础配置

```properties
# 在application.properties/yml或bootstrap.properties/yml配置文件中添加
#开发环境
spring.profiles.active=dev
#测试环境
#spring.profiles.active=test
#生产环境
#spring.profiles.active=product

```

## 2 在Nacos Dashboard中添加对应配置项

Nacos 上新增一个 dataId 为：datasourcemaster-dev.properties 的基础配置，如下所示：

```properties
Data ID: datasourcemaster-dev.properties
Group: database
配置格式: properties
配置内容: current.env: dev-env
```

## 3 基于Nacos实现环境切换

如果需要切换到不同环境的配置项，只需修改spring.profiles.active即可

```properties
spring.profiles.active=product
```

具体配置项信息

```properties
Data ID: datasourcemaster-product.properties
Group: datasource
配置格式: properties
配置内容: current.env: product-env
```

## 4 Nacos配置中心组件读取配置项的优先级 

**spring-cloud-starter-alibaba-nacos-config目前提供了三种配置能力从 Nacos 拉取相关的配置**

- A: 通过 spring.cloud.nacos.config.shared-dataids 支持多个共享 Data Id 的配置
- B: 通过 spring.cloud.nacos.config.ext-config[n].data-id 的方式支持多个扩展 Data Id 的配置
- C: 通过内部相关规则(应用名、应用名+ Profile )自动生成相关的 Data Id 配置

当三种方式共同使用时，他们的优先级关系是: **A < B < C**

## 5 spring.config.import 引入配置项

使用 spring.config.import 引入配置时需要注意:

- 如果使用 spring.config.import 就不能使用 bootstrap.yml/properties 引入配置的方式；
- bootstrap方式引入配置

```properties
spring.cloud.nacos.config.server-addr=127.0.0.1:3333
spring.cloud.nacos.config.namespace=772c8d40-00a8-47dd-8eeb-dfe19fb76aa8
spring.cloud.nacos.config.username=nacos
spring.cloud.nacos.config.password=nacos
spring.cloud.nacos.config.extension-configs[0].dataId=datasourcemaster.properties
spring.cloud.nacos.config.extension-configs[0].group=datasource
spring.cloud.nacos.config.extension-configs[1].dataId=system.properties
spring.cloud.nacos.config.extension-configs[1].group=system

```

- spring.config.import方式引入配置

  **升级到 2021.0.1.0及以上的版本配置方式**

```properties
# 采用spring.config.import 方式引入配置文件 新版本不需要使用 bootstrap.yml
spring.cloud.nacos.config.server-addr=127.0.0.1:3333
spring.cloud.nacos.config.namespace=772c8d40-00a8-47dd-8eeb-dfe19fb76aa8
spring.cloud.nacos.config.username=nacos
spring.cloud.nacos.config.password=nacos
#spring.config.import方式导入配置项
spring.config.import[0]=optional:nacos:datasourcemaster.properties?group=datasource
spring.config.import[1]=optional:nacos:system.properties?group=system
```

## 6 代码实现

