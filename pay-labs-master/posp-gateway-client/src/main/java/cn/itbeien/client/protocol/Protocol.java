package cn.itbeien.client.protocol;


import cn.itbeien.client.enuns.CommandIDEnums;
import cn.itbeien.client.protocol.response.RegistrationResponse;
import cn.itbeien.client.util.ByteUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * 消息协议类V1.0
 * Copyright© 2024 itbeien
 */
public class Protocol {


	private final static Map<Integer, Class<? extends Protocol>> packetType = new ConcurrentHashMap<>();

	static {
		packetType.put(CommandIDEnums.SignIn.getCommand(), RegistrationResponse.class);
	}

	public static Class<? extends Protocol> get(Byte command) {
		return packetType.get(command);
	}

	public static Class<? extends Protocol> get(Integer command) {
		return packetType.get(command);
	}

	/**
	 * 消息头长度
	 */
	public static final int HEADER_LENGTH = 62;//协议调整前为42个长度
	/**
	 * 消息总长度
	 */
	private int length;
		
	/**
	 * 消息流水号,标识POS终端的每笔交易和服务端交易一一对应
	 */
	private int sequenceID;
	
	/**
	 * 设备逻辑编号
	 */
	private String deviceLogicID;
	
	/**
	 * 设备物理编号
	 */
	private String devicePhysicalID; 
	
	/**
	 * 商户编号,预留字段
	 */
	private String merchantId;
	
	/**
	 * 批次号
	 */
	private int batchID;
	
	/**
	 * 交易流水号
	 */
	private int transactionID;
	
	/**
	 * 操作员
	 */
	private String opNumber;
	
	/**
	 * 版本号
	 */
	private String version;
	
	/**
	 * 消息体
	 */
	private byte[] body;
	
	public Protocol() {
		
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getSequenceID() {
		return sequenceID;
	}

	public void setSequenceID(int sequenceID) {
		this.sequenceID = sequenceID;
	}

	public String getDeviceLogicID() {
		return deviceLogicID;
	}

	public void setDeviceLogicID(String deviceLogicID) {
		this.deviceLogicID = deviceLogicID;
	}

	

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public String getOpNumber() {
		return opNumber;
	}

	public void setOpNumber(String opNumber) {
		this.opNumber = opNumber;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}


	public String getDevicePhysicalID() {
		return devicePhysicalID;
	}

	public void setDevicePhysicalID(String devicePhysicalID) {
		this.devicePhysicalID = devicePhysicalID;
	}

	public byte[] getBody() {
		return body;
	}

	public void setBody(byte[] body) {
		this.body = body;
	}


	/**
	 * 方法用途: 协议编码<br>
	 * 实现步骤: <br>
	 * @return 协议编码后包装的BUFFER对象
	 */
	public byte[] encoder() {
		ByteBuf buf = Unpooled.buffer(62+this.body.length);
		buf.writeBytes(ByteUtil.getBytes(this.length));
		buf.writeBytes(ByteUtil.getBytes(this.sequenceID));
		buf.writeBytes(ByteUtil.getBytes(this.version));
		buf.writeBytes(ByteUtil.getBytes(this.deviceLogicID));
		buf.writeBytes(ByteUtil.getBytes(this.devicePhysicalID));
		buf.writeBytes(ByteUtil.getBytes(this.merchantId));
		buf.writeBytes(ByteUtil.getBytes(this.opNumber));
		buf.writeBytes(ByteUtil.getBytes(this.batchID));
		buf.writeBytes(ByteUtil.getBytes(this.transactionID));
		buf.writeBytes(this.body);
		byte[] data = new byte[buf.readableBytes()];
		buf.readBytes(data);
		//buf.release();
		return data;
	}


}
