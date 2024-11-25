package com.beien.socket;


import com.beien.service.IPayConsumerService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Component
public class ServerHandler extends SimpleChannelInboundHandler {

   @Autowired
   private IPayConsumerService payConsumerService;

    protected Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("服务名称+ip+ServerHandler.channelRead0 接收客戶端消息:{}",msg);//知道现在流程走到哪一步了
        payConsumerService.callPayService();//支付服务
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        logger.info("客户端连接通知：{}", ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("服务端异常断开", cause.getMessage());
    }

}
