package cn.itbeien.client.util;


import cn.itbeien.client.protocol.Protocol;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;

import static cn.itbeien.client.protocol.Protocol.HEADER_LENGTH;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * 获取当前时间
 * Copyright© 2024 itbeien
 */
@Slf4j
public class SerializationTool {


    private SerializationTool() {

    }

    /**
     * 序列化
     *
     * @param obj 对象
     * @return 字节数组
     */
    public static <T> byte[] serialize(T obj) {
        log.info("开始协议编码");
        Protocol protocol = (Protocol) obj;
        ByteBuf buf =  Unpooled.buffer(62+protocol.getBody().length);
        buf.writeBytes(ByteUtil.getBytes(protocol.getLength()));
        buf.writeBytes(ByteUtil.getBytes(protocol.getSequenceID()));
        buf.writeBytes(ByteUtil.getBytes(protocol.getVersion()));
        buf.writeBytes(ByteUtil.getBytes(protocol.getDeviceLogicID()));
        buf.writeBytes(ByteUtil.getBytes(protocol.getDevicePhysicalID()));
        buf.writeBytes(ByteUtil.getBytes(protocol.getMerchantId()));
        buf.writeBytes(ByteUtil.getBytes(protocol.getOpNumber()));
        buf.writeBytes(ByteUtil.getBytes(protocol.getBatchID()));
        buf.writeBytes(ByteUtil.getBytes(protocol.getTransactionID()));
        buf.writeBytes(protocol.getBody());
        log.info("协议编码完成");
        return buf.array();
    }

    /**
     * 反序列化
     *
     * @param data
     * @param clazz
     * @param <T>
     */
    public static <T> T deserialize(byte[] data, Class<T> clazz) {

        Protocol protocol = null;
       try{
           byte[] messageLength = ByteUtil.getValue(data, 0, 4);//消息长度
           byte[] sequenceID = ByteUtil.getValue(data, 4, 4);//消息流水号
           byte[] version = ByteUtil.getValue(data, 8, 4);//协议版本号
           byte[] deviceLogicID = ByteUtil.getValue(data, 12, 10);//终端逻辑编号
           byte[] devicePhysicalID = ByteUtil.getValue(data, 22, 20);//终端物理编号
           byte[] merchantId = ByteUtil.getValue(data, 42, 10);//商户编号
           byte[] opNumber = ByteUtil.getValue(data, 52, 2);//操作员
           byte[] batchID = ByteUtil.getValue(data, 54, 4);//批次号
           byte[] transactionID = ByteUtil.getValue(data, 58, 4);//交易号
           byte[] body = ByteUtil.getValue(data, HEADER_LENGTH, ByteUtil.getInt(messageLength) - HEADER_LENGTH);

           protocol = (Protocol) clazz.newInstance();

           protocol.setLength(ByteUtil.getInt(ByteUtil.getValue(data, 0, 4)));
           protocol.setSequenceID(ByteUtil.getInt(sequenceID));
           protocol.setDeviceLogicID(ByteUtil.getString(deviceLogicID));
           protocol.setMerchantId(ByteUtil.getString(merchantId));
           protocol.setBatchID(ByteUtil.getInt(batchID));
           protocol.setTransactionID(ByteUtil.getInt(transactionID));
           protocol.setOpNumber(ByteUtil.getString(opNumber));
           protocol.setVersion(ByteUtil.getString(version));
           protocol.setDevicePhysicalID(ByteUtil.getString(devicePhysicalID));
           protocol.setBody(body);
           log.info("协议解析完成");
       }catch (Exception e){
           throw new IllegalStateException(e.getMessage(), e);
       }
       return (T) protocol;
    }



}
