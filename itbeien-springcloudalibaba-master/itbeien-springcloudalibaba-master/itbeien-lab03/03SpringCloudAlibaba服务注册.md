# SpringCloudAlibaba微服务注册与发现

## 1 微服务使用nacos实现服务注册与发现

在pom.xml文件中添加组件

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

## 2 添加微服务应用配置																																																				 

在application.properties文件中添加以下配置信息

```properties
# 采用spring.config.import 方式引入配置文件 新版本不需要使用 bootstrap.yml
spring.profiles.active=dev
# 用于注册的名称 聚合支付服务 该配置信息一定要写，不然不会注册服务
spring.application.name=union-pay
#spring.profiles.active=test
#spring.profiles.active=dev
```

application-dev.properties文件添加以下配置信息

```properties
# 微服务注册中心
spring.cloud.nacos.discovery.server-addr=127.0.0.1:3333
spring.cloud.nacos.discovery.namespace=772c8d40-00a8-47dd-8eeb-dfe19fb76aa8
# 对服务进行分组分类
spring.cloud.nacos.discovery.group=system
spring.cloud.nacos.discovery.username=nacos
spring.cloud.nacos.discovery.password=nacos
#关闭ribbon服务发现功能(负载均衡)
spring.cloud.loadbalancer.ribbon.enabled=false
#开启nacos服务发现功能(负载均衡)
spring.cloud.loadbalancer.nacos.enabled=true
```

## 3 开启服务注册与发现功能

使用 @EnableDiscoveryClient 注解开启服务注册与发现功能：

```java
package cn.itbeien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author beien
 * @date 2024-04-13 16:22
 * Copyright© 2024 beien
 */
@SpringBootApplication
@EnableDiscoveryClient //开发服务注册与发现
public class Lab03Application {
    public static void main(String[] args) {
        SpringApplication.run(Lab03Application.class,args);
    }
}

```

## 4 实现服务发现功能的组件

pom.xml中添加

```xml
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-loadbalancer</artifactId>
</dependency>
```

配置文件中添加以下配置

```properties
spring.cloud.loadbalancer.ribbon.enabled=false
spring.cloud.loadbalancer.nacos.enabled=true
```

## 5 服务消费者

```java
package cn.itbeien.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beien
 * @date 2024-04-13 16:56
 * Copyright© 2024 beien
 */
@RestController
public class Lab03Controller {

    /**
     * 用于消费(调用)预付卡交易系统卡消费功能
     * @return
     */
    @PostMapping("/api/card")
    public String callCard(){
        return "success";
    }
}

```

