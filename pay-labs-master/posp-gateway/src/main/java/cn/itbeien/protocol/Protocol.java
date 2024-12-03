package cn.itbeien.protocol;


import cn.itbeien.enums.CommandIDEnums;
import cn.itbeien.protocol.request.RegistrationRequest;
import cn.itbeien.util.ByteUtil;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class Protocol {

	private final static Map<Integer, Class<? extends Protocol>> packetType = new ConcurrentHashMap<>();

	static {
		packetType.put(CommandIDEnums.SignIn.getCommand(), RegistrationRequest.class);
	}

	/**
	 * 消息头长度
	 */
	public static final int HEADER_LENGTH = 62;
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


	public static Class<? extends Protocol> get(Integer command) {
		return packetType.get(command);
	}
	
	public static void main(String[] args) {
		System.out.println(ByteUtil.getBytes(12345678).length);
	}

}
