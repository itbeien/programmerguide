package com.beien.client;

import com.beien.client.socket.NettyClient;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.concurrent.*;


@SpringBootApplication
public class Application implements CommandLineRunner {
    @Resource
    private NettyClient nettyClient;
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
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
        String sendMsg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Trade><Head><Version>1.0</Version><TimeStamp>2019-12-03 10:43:52</TimeStamp><SequenceId>AZJ001201912031043521013</SequenceId><TransactionCode>V_GATEWAY_CONFIRM</TransactionCode><DeviceNo>AZJ001</DeviceNo></Head><Body><Body><EnteryOrExit>1</EnteryOrExit><VoucherValue>99088288711426</VoucherValue><ReadModel>3</ReadModel><MediaType>1</MediaType><MediaValue>99088288711426</MediaValue><PassNumber>1</PassNumber><CanPassNumber>0</CanPassNumber><PassGatewayTime>2019-12-03 10:43:52</PassGatewayTime><TransactionNo>AZJ001201912031043521014</TransactionNo><SaleProcessNo>201807132</SaleProcessNo><ExtendArea><FlexField1></FlexField1><FlexField2><![CDATA[{\"ErrCode\":0,\"ErrMsg\":\"成功\"}]]></FlexField2><FlexField3></FlexField3></ExtendArea></Body></Body></Trade>";
        //sendMsg(channel, "gateway ticket 游客入园");
        sendMsg(channel, sendMsg);//发送闸机入园的指令
        // Channel状态定时巡检；3秒后每5秒执行一次  模拟硬件和软件重连
        // 为了保活  10万台 100万 保活机制  采用心跳机制-》服务端定时发送消息给软件
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
                logger.info("通信管道模拟游客入园：通信管道状态 " + nettyClient.isActive());
                try {
                    logger.info("通信管道模拟游客入园：[Begin]");
                    channel.writeAndFlush(msg);
                    logger.info("通信管道模拟游客入园：[End]");
                } catch (Exception e) {
                    logger.error("通信管道模拟游客入园：异常[Error]");
                }
            }, 3, 30, TimeUnit.SECONDS);

        } catch (Exception e) {
            logger.error("通信管道模拟游客入园：异常");
        }

    }
}