package com.beien.socket;


import com.beien.service.IMqProductService;
import com.beien.service.ITicketConsumerService;
import com.beien.service.TicketFeign;
import com.beien.service.impl.MqProcuctService;
import com.beien.service.impl.TicketConsumerService;
import com.beien.util.SpringUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author beien
 * @date 2023/3/9 21:52
 * Copyright© 2023 beien
 */
@Component
//@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler {
    @Resource
    private IMqProductService mqProductService;

   @Resource
   private ITicketConsumerService ticketConsumerService;

    @Autowired
    private TicketFeign ticketFeign;

    protected Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    @PostConstruct
    //因为是new出来的handler,没有托给spring容器,
    // 所以一定要先初始化,否则Autowired失效
    public void init() {
        //serverHandler = this;
    }
    public ServerHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("服务名称+ip+ServerHandler.channelRead0 接收客戶端消息:{}",msg);//知道现在流程走到哪一步了
        //MqProcuctService mqProductService = new MqProcuctService();
        mqProductService.createMsg(String.valueOf(msg));
        //发送一条入园消息到rocketmq,供后续的报表系统生成实时入园数据

        //feign从nacos中发现验票服务 并通过feign组件调用验票服务
        //ticketFeign = (TicketFeign) SpringUtil.getBean("ticketFeign");
        ticketFeign.orderFromClient("ticket");//验票服务
        //ticketConsumerService = (ITicketConsumerService) SpringUtil.getBean("ticketConsumerService");
        //ticketConsumerService.callTicketService();//验票服务
        //ticketFeign.orderFromClient("ticket");
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
