package cn.itbeien.protocol.request;


import cn.itbeien.protocol.Protocol;
import cn.itbeien.util.ByteUtil;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * 签到
 * Copyright© 2024 itbeien
 */
public class RegistrationRequest extends Protocol {

	private String versionNo;

	public String getVersionNo() {
		return versionNo;
	}
	
	protected void decode() throws Exception {
		this.versionNo = ByteUtil.getString(ByteUtil.getValue(this.getBody(), 4, 4));
	}
	
}
