package cn.itbeien.client;

import cn.itbeien.client.socket.NettyClient;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.Resource;
import java.util.concurrent.*;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@SpringBootApplication
public class ClientApplication implements CommandLineRunner {
    @Resource
    private NettyClient nettyClient;
    private static Logger logger = LoggerFactory.getLogger(ClientApplication.class);
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. 启动socket连接
        logger.info("NettyClient连接服务开始 host：{} port：{}", "127.0.0.1", 8600);

        Future<Channel> future = executorService.submit(nettyClient);
        Channel channel = future.get();
        if (null == channel) throw new RuntimeException("netty client start error channel is null");

        while (!nettyClient.isActive()) {
            logger.info("NettyClient启动服务 ...");
            Thread.sleep(500);
        }
        logger.info("NettyClient连接服务完成 {}", channel.localAddress());

        logger.info("通信管道巡检：通信管道状态 " + nettyClient.isActive());
        String sendMsg = "{\"amount\":\"100.00\",\"interfaceCode\":\"pay\",\"merchantCode\":\"1000001\",\"payType\":\"js\"}";
        //sendMsg(channel, "pos发起支付交易");
        sendMsg(channel, sendMsg);//发送支付交易指令
        // Channel状态定时巡检；3秒后每5秒执行一次  模拟硬件和软件重连
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            while (!nettyClient.isActive()) {//判断是否和服务器连接上
                logger.info("通信管道巡检：通信管道状态 " + nettyClient.isActive());
                try {
                    logger.info("通信管道巡检：断线重连[Begin]");
                    Channel freshChannel = executorService.submit(nettyClient).get();
                    freshChannel.writeAndFlush("abc");
                } catch (InterruptedException | ExecutionException e) {
                    logger.error("通信管道巡检：断线重连[Error]");
                }
            }
        }, 3, 5, TimeUnit.SECONDS);

    }

    public void sendMsg(Channel channel, String msg) {
        try {
            logger.info("通信管道发送消息：[Begin]");
            //Channel channel = executorService.submit(nettyClient).get();
            channel.writeAndFlush(msg);
            logger.info("通信管道发送消息：[End]");
            // Channel状态定时巡检；60秒后每60秒执行一次
            scheduledExecutorService.scheduleAtFixedRate(() -> {
                logger.info("通信管道模拟游客支付：通信管道状态 " + nettyClient.isActive());
                try {
                    logger.info("通信管道模拟游客支付：[Begin]");
                    channel.writeAndFlush(msg);
                    logger.info("通信管道模拟游客支付：[End]");
                } catch (Exception e) {
                    logger.error("通信管道模拟游客支付：异常[Error]");
                }
            }, 3, 30, TimeUnit.SECONDS);

        } catch (Exception e) {
            logger.error("通信管道模拟游客支付：异常");
        }

    }
}