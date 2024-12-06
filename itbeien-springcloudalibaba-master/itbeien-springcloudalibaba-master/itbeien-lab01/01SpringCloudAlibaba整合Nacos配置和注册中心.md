# SpringCloudAlibaba整合Nacos为配置和注册中心

## 1 Spring Boot 与 Spring Cloud Alibaba 版本对应关系

| **Spring Boot Version** | **Spring Cloud Alibaba Version** | **Spring Cloud Version**   |
| ----------------------- | -------------------------------- | -------------------------- |
| 3.0.2                   | 2022.0.0.0                       | Spring Cloud 2022.0.0      |
| 3.0.2                   | 2022.0.0.0-RC2                   | Spring Cloud 2022.0.0      |
| 3.0.0                   | 2022.0.0.0-RC1                   | Spring Cloud 2022.0.0      |
| **2.7.18**              | **2021.0.5.0**                   | **Spring Cloud  2021.0.9** |
| 2.6.13                  | 2021.0.5.0                       | Spring Cloud 2021.0.5      |
| 2.6.11                  | 2021.0.4.0                       | Spring Cloud 2021.0.4      |
| 2.6.3                   | 2021.0.1.0                       | Spring Cloud 2021.0.1      |
| 2.4.2                   | 2021.1                           | Spring Cloud 2020.0.1      |

## 2 父工程添加版本管理

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.18</version>
    </parent>

    <groupId>cn.itbeien</groupId>
    <artifactId>itbeien-springcloudalibaba-root</artifactId>
    <version>1.0.0</version>
    <packaging>pom</packaging>
    <properties>
        <spring-cloud-alibaba.version>2021.0.5.0</spring-cloud-alibaba.version>
        <spring-cloud.version>2021.0.9</spring-cloud.version>
    </properties>

    <modules>
        <module>itbeien-lab01</module>
    </modules>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${spring-cloud-alibaba.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```

## 3 子项目itbeien-lab01 pom.xml依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>cn.itbeien</groupId>
        <artifactId>itbeien-springcloudalibaba-root</artifactId>
        <version>1.0.0</version>
    </parent>
    <artifactId>itbeien-lab01</artifactId>

    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
</project>
```

## 4 SpringCloudAlibaba和 spring-cloud-starter-alibaba-nacos-config实现配置管理

- spring.config.import 方式引入(2021.0.1.0 及以上版本支持,2021.0.1.0以下版本采用bootstrap方式配置自定义命名空间和分组)

```properties
# 采用spring.config.import 方式引入配置文件 新版本不需要使用 bootstrap.yml
spring.cloud.nacos.config.server-addr=127.0.0.1:3333
spring.cloud.nacos.config.namespace=772c8d40-00a8-47dd-8eeb-dfe19fb76aa8
spring.cloud.nacos.config.username=nacos
spring.cloud.nacos.config.password=nacos
#spring.config.import方式导入配置项
spring.config.import[0]=optional:nacos:system.properties?group=system
```

## 5 配置文件

```java
package cn.itbeien.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author beien
 * @date 2024-04-12 23:35
 * Copyright© 2024 beien
 */
@Data
@Component
@RefreshScope  //自动刷新
public class NacosConfig {
    @Value("${system.key}")
    private String key;
}

```

## 6 测试

```java
package cn.itbeien.controller;

import cn.itbeien.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beien
 * @date 2024-04-12 23:47
 * Copyright© 2024 beien
 */
@RestController
public class NacosController {
    @Autowired
    private NacosConfig nacosConfig;
    @GetMapping("config")
    private String config(){
        return nacosConfig.getKey();
    }
}

```

