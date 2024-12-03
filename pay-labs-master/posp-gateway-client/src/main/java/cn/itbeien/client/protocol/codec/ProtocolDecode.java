package cn.itbeien.client.protocol.codec;

import cn.itbeien.client.protocol.Protocol;
import cn.itbeien.client.util.ByteUtil;
import cn.itbeien.client.util.SerializationTool;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static cn.itbeien.client.protocol.Protocol.HEADER_LENGTH;


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
        list.add( SerializationTool.deserialize(data, Protocol.get(command)) );
    }
}
