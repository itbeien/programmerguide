package cn.itbeien.client;

import cn.itbeien.client.protocol.Protocol;
import cn.itbeien.client.socket.NettyClient;
import cn.itbeien.client.util.ByteUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
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

        logger.info("POS通道检查：通道状态 " + nettyClient.isActive());
        //String sendMsg = "{\"amount\":\"100.00\",\"interfaceCode\":\"pay\",\"merchantCode\":\"1000001\",\"payType\":\"js\"}";
        //sendMsg(channel, "pos发起支付交易");
        sendMsg(channel, encodeMsg());//发送支付交易指令
        // Channel状态定时检查；3秒后每5秒执行一次  模拟硬件和软件重连
       /* scheduledExecutorService.scheduleAtFixedRate(() -> {
            while (!nettyClient.isActive()) {//判断是否和服务器连接上
                logger.info("POS通道：通道状态 " + nettyClient.isActive());
                try {
                    logger.info("POS通道：断线重连[Begin]");
                    Channel freshChannel = executorService.submit(nettyClient).get();
                    freshChannel.writeAndFlush("abc");
                } catch (InterruptedException | ExecutionException e) {
                    logger.error("POS通道：断线重连[Error]");
                }
            }
        }, 3, 5, TimeUnit.SECONDS);*/

    }


    public void sendMsg(Channel channel, byte[] msg) {
        try {
            logger.info("POS通道发送消息：[Begin]");
            //Channel channel = executorService.submit(nettyClient).get();
            channel.writeAndFlush(msg);
            logger.info("POS通道发送消息：[End]");
            ChannelPipeline pipelined = channel.pipeline();
            //pipelined.addLast(new ClientHandler());
            // Channel状态定时检查；3秒后每30秒执行一次
            scheduledExecutorService.scheduleAtFixedRate(() -> {
                logger.info("POS通道模拟游客支付：通信管道状态 " + nettyClient.isActive());
                try {
                    logger.info("POS通道模拟游客支付：[Begin]");
                    ByteBuf buf = Unpooled.wrappedBuffer(msg);
                    channel.writeAndFlush(buf);
                    //buf.release();
                    logger.info("POS通道模拟游客支付：[End]");
                } catch (Exception e) {
                    logger.error("POS通道模拟游客支付：异常[Error]");
                }
            }, 3, 30, TimeUnit.SECONDS);

        } catch (Exception e) {
            logger.error("POS通道模拟游客支付：异常");
        }

    }

    public byte[] encodeMsg(){
        Protocol protocol = new Protocol();
        protocol.setBatchID(202412);
        //protocol.setLength(60);//签到消息总长度(消息头+消息体)
        protocol.setDeviceLogicID("T100000512");//T100000512 //T000000001
        protocol.setDevicePhysicalID("12837465426234567645");
        protocol.setMerchantId("2345678924");
        protocol.setOpNumber("bn");
        protocol.setSequenceID(11);
        protocol.setVersion("1.00");
        protocol.setTransactionID(151815);//流水号
        Integer commandId = 0x80000001;//签到
        //Integer commandId = 0x80000012;//签退
        //Integer commandId = 0x00000014;//软件版本更新
        //Integer commandId = 0x8000000B;//交易
        String version = "1.00";
        byte[] bcommandId = ByteUtil.getBytes(commandId);
        byte[] bversion = ByteUtil.getBytes(version);
        //byte[] businessNo = ByteUtil.getBytes(11);
        //short value = 201; //消费
        //short value = 301;//消费撤销
        //short value = 601;//查询
        //short value = 401;//退货
        //short value = 501;//重打印
        //byte b[] = ByteUtil.getBytes(value);
        //byte[] tradeNo = ByteUtil.getBytes(value);
        //String contents ="9996660005778407|5;2;1;1111";//6666661006978001(新卡系统卡BIN);9996660005778407 //消费
        //String contents ="9996660005778407|5;202408;151814" ;//消费撤销
        //String contents ="6666661006978001|5;202405;151800;2" ;//退货
        //String contents ="6666661006978001|5;202405;151800" ;//查询
        //String contents ="9996660005778407|5;202405;151800" ;//6666661006978001 //重打印
        //byte[] content = ByteUtil.getBytes(contents);
        //content = TDes.encryptMode("E4429DEDB7E56E8334C69003".getBytes(), content);
        //byte[] length  = ByteUtil.getBytes(content.length);

        //byte[] extraData = ByteUtil.getBytes(1);
        //byte[] extraDataLength = ByteUtil.getBytes(extraData.length);

        byte[] data = new byte[bcommandId.length + bversion.length ];//提交消息体数据
        //byte[] data = new byte[bcommandId.length + businessNo.length + tradeNo.length + length.length + content.length+extraDataLength.length+extraData.length];//提交消息体数据
        System.arraycopy(bcommandId, 0, data, 0, bcommandId.length);
        System.arraycopy(bversion, 0, data, bcommandId.length, bversion.length);
        //System.arraycopy(businessNo, 0, data, bcommandId.length, businessNo.length);
        //System.arraycopy(tradeNo, 0, data, bcommandId.length+businessNo.length, tradeNo.length);
        //System.arraycopy(length, 0, data, bcommandId.length+businessNo.length+tradeNo.length, length.length);
        //System.arraycopy(content, 0, data, bcommandId.length+businessNo.length+tradeNo.length+length.length, content.length);
        //System.arraycopy(extraDataLength, 0, data, bcommandId.length+businessNo.length+tradeNo.length+length.length+content.length, extraDataLength.length);
        //System.arraycopy(extraData, 0, data, bcommandId.length+businessNo.length+tradeNo.length+length.length+content.length+extraDataLength.length, extraData.length);
        //byte[] signature = TDes.encryptMode("E4429DEDB7E56E8334C69003".getBytes(), data);//签名(对消息体进行签名)
        //Integer signatureLength = signature.length;
        //byte[] bsignatureLength =ByteUtil.getBytes(signatureLength);
        //byte[] data1 =new byte[data.length+signature.length+bsignatureLength.length];//包括签名
        //System.arraycopy(data, 0, data1, 0, data.length);
        //System.arraycopy(bsignatureLength, 0, data1, data.length, bsignatureLength.length);
        //System.arraycopy(signature, 0, data1, data.length+bsignatureLength.length, signature.length);
        //protocol.setBody(data1);
        //protocol.setLength(62+data1.length);//签到消息总长度(消息头+消息体)
        //System.out.println(data.length);
        //System.out.println(data1.length);

        protocol.setBody(data);
        protocol.setLength(62+data.length);

        return protocol.encoder();
    }
}