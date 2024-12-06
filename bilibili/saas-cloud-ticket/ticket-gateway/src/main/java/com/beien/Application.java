package com.beien;

import com.beien.socket.NettyServer;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.Resource;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *SpringBoot+Netty启动类
 * Springboot+Netty实现Socket服务器
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //用于创建Feign代理实现类->动态代理
public class Application implements CommandLineRunner {
    @Resource
    private NettyServer nettyServer;
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("NettyServer启动服务开始 port：8600");
        Future<Channel> future = Executors.newFixedThreadPool(2).submit(nettyServer);
        Channel channel = future.get();
        if (null == channel) throw new RuntimeException("netty server start error channel is null");

        while (!channel.isActive()) {
            logger.info("NettyServer启动服务 ...");
            Thread.sleep(500);
        }

        logger.info("NettyServer启动服务完成 {}", channel.localAddress());
    }
}