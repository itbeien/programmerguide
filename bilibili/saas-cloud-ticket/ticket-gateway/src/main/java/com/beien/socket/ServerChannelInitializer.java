package com.beien.socket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author beien
 * @date 2023/3/9 21:50
 * Copyright© 2023 beien
 */
@Component  //交给spring容器去管理
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Autowired
    private ServerHandler serverHandler;
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
        channel.pipeline().addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
        //channel.pipeline().addLast(new ServerHandler());
        channel.pipeline().addLast(serverHandler);
    }
}
