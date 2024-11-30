package cn.itbeien;

import cn.itbeien.socket.NettyServer;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * SpringBoot+Netty启动类
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@SpringBootApplication
public class GatewayApplication implements CommandLineRunner {

    @Autowired
    private NettyServer nettyServer;
    private static Logger logger = LoggerFactory.getLogger(GatewayApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
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