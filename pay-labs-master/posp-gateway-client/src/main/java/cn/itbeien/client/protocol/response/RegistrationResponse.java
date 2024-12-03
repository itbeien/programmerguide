package cn.itbeien.client.protocol.response;


import cn.itbeien.client.protocol.Protocol;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
public class RegistrationResponse extends Protocol {

	private int commondID;

	private byte registerCode;
	/**
	 * 签名|工作秘钥
	 */
	private byte[] password;
	
	/**
	 * pin秘钥
	 */
	private String pinKey = "";
	
	private int batchNo;
	
	private String serverTime = "";
	
	private byte encryption;

	public int getCommondID() {
		return commondID;
	}

	public void setCommondID(int commondID) {
		this.commondID = commondID;
	}

	public byte getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(byte registerCode) {
		this.registerCode = registerCode;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public int getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}

	public String getServerTime() {
		return serverTime;
	}

	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	
	
	
	public byte getEncryption() {
		return encryption;
	}

	public void setEncryption(byte encryption) {
		this.encryption = encryption;
	}
	
	

	public String getPinKey() {
		return pinKey;
	}

	public void setPinKey(String pinKey) {
		this.pinKey = pinKey;
	}

	
}
