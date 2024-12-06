package com.beien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基于SpringBoot和RocketMQ如何实现限时订单
 *
 * 业务场景
 * 我们在购买电影票时，选完座位下单后有15分钟的订单支付时间，
 * 如果在15分钟内没有完成支付，那么该订单就会被取消然后释放订单座位。
 *
 * 什么是限时订单
 * 用户下单后订单会保留一个时间段，
 * 时间段内未支付则自动将订单状态设置为已过期，这种订单称之为限时订单。
 *
 * 限时订单实现的关键
 * 在规定的时间段内如果用户没有对订单完成支付，
 * 那么系统将对该笔订单进行状态的变更（订单已关闭）
 * 并对商品表的商品进行解锁，所以限时订单的关键就是
 * 如何检查订单支付状态，
 * 如果订单在规定的时间内没有完成支付，则把该订单设置为关闭状态
 * 第一步 在RocketMQ中创建Topic
 * 第二步 在项目中引入rocketmq-spring-boot-starter
 * 第三步 创建RocketMQ生产者向消息中间件发送订单创建成功延迟消息
 * 第四步 创建消费者服务类，消费者根据延迟消息进行后续订单业务处理
 * 如果订单状态为未支付状态则设置订单状态为关闭状态，并对商品库存进行
 * 处理
 */
@SpringBootApplication
public class BeienSpringbootRocketmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeienSpringbootRocketmqApplication.class, args);
    }

}
