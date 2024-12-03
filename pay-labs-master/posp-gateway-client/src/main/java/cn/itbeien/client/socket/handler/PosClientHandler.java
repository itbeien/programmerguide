package cn.itbeien.client.socket.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PosClientHandler extends SimpleChannelInboundHandler {
    private static Logger logger = LoggerFactory.getLogger(PosClientHandler.class);
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        logger.info("received data from client: {}",msg);
    }
}
