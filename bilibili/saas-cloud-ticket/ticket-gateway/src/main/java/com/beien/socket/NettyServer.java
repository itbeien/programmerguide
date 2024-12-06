package com.beien.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;
import java.util.concurrent.Callable;

/**
 *netty服务端
 */
@Service("nettyServer")
public class NettyServer implements Callable<Channel> {

    @Value("${netty.port}")
    private int port;

    @Value("${netty.url}")
    private String url;

    private static Logger logger = LoggerFactory.getLogger(NettyServer.class);


    private final EventLoopGroup parentGroup = new NioEventLoopGroup(2);
    private final EventLoopGroup childGroup = new NioEventLoopGroup();
    private Channel channel;

    @Autowired
    private ServerChannelInitializer serverChannelInitializer;

    public NettyServer(){
    }

    @Override
    public Channel call() throws Exception {
        ChannelFuture channelFuture = null;
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //.childHandler(new ServerChannelInitializer());
                    .childHandler(serverChannelInitializer);

            channelFuture = b.bind(new InetSocketAddress(url,port)).syncUninterruptibly();
            this.channel = channelFuture.channel();
        } catch (Exception e) {
            logger.error("socket server start error", e.getMessage());
        } finally {
            if (null != channelFuture && channelFuture.isSuccess()) {
                logger.info("socket server start done. ");
            } else {
                logger.error("socket server start error. ");
            }
        }
        return channel;
    }

    public void destroy() {
        if (null == channel) return;
        channel.close();
        parentGroup.shutdownGracefully();
        childGroup.shutdownGracefully();
    }

    public Channel channel() {
        return channel;
    }

}
