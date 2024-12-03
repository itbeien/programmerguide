package cn.itbeien.protocol.codec;

import cn.itbeien.protocol.Protocol;
import cn.itbeien.util.SerializationTool;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * 序列化 对象->字节数组
 * Copyright© 2024 itbeien
 */
@Slf4j
public class ProtocolEncode extends MessageToByteEncoder<Protocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Protocol protocol, ByteBuf byteBuf) throws Exception {
        byte[] data = SerializationTool.serialize(protocol);
        byteBuf.writeBytes(data);
    }
}
