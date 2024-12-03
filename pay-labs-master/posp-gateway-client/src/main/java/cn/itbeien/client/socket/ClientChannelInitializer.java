package cn.itbeien.client.socket;

import cn.itbeien.client.protocol.codec.ProtocolDecode;
import cn.itbeien.client.socket.handler.PosClientHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //channel.pipeline().addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
        //channel.pipeline().addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
        //协议传输处理[解码]
        channel.pipeline().addLast("decoder",new ProtocolDecode());
        //channel.pipeline().addLast(new ClientHandler());
        channel.pipeline().addLast(new PosClientHandler());
    }
}
