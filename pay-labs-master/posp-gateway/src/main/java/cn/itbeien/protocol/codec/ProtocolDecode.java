package cn.itbeien.protocol.codec;

import cn.itbeien.protocol.Protocol;
import cn.itbeien.util.ByteUtil;
import cn.itbeien.util.SerializationTool;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static cn.itbeien.protocol.Protocol.HEADER_LENGTH;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * 反序列化 字节数组->对象
 * Copyright© 2024 itbeien
 */
@Slf4j
public class ProtocolDecode extends ByteToMessageDecoder{
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readable = byteBuf.readableBytes();
        if (readable < 62) {
            return;
        }
        // 将ByteBuf转换为byte[]
        byte[] data = new byte[readable];
        byteBuf.readBytes(data);
        byte[] body = ByteUtil.getValue(data, HEADER_LENGTH, readable - HEADER_LENGTH);
        int command = ByteUtil.getInt(ByteUtil.getValue(body, 0, 4));
        log.info("开始解析协议");
        list.add( SerializationTool.deserialize(data,Protocol.get(command)) );
    }
}
