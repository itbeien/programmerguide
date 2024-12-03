package cn.itbeien.socket;

import cn.itbeien.protocol.codec.ProtocolDecode;
import cn.itbeien.protocol.codec.ProtocolEncode;
import cn.itbeien.socket.handler.PosHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Component  //交给spring容器去管理
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
   /* @Autowired
    private ServerHandler serverHandler;*/
    @Autowired
    private PosHandler posHandler;
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //协议传输处理[解码]
        channel.pipeline().addLast("decoder",new ProtocolDecode());
        //channel.pipeline().addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
        //channel.pipeline().addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
        //channel.pipeline().addLast(serverHandler);
        channel.pipeline().addLast(posHandler);
        //协议传输处理[编码]
        channel.pipeline().addLast("encoder",new ProtocolEncode());
    }
}
