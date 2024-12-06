package com.beien.exception.warnig;//package com.mopon.root.exception.constant;

public enum DtWarningLevelEnum {

	/**
	 * 监控级别：成功； 表示监控信息执行或发送成功，主要用于第三方接口调用返回等场合
	 */
	GREEN("GREEN", "绿"),

	/**
	 * 监控级别：需注意； 表示发生了非业务，可控制的异常，如因用户输入字段不合法，验证码验证失败等错误
	 */
	BLUE("BLUE", "蓝"),

	/**
	 * 监控级别：内部错误；表示发生了内部业务错误； 包括凭证有效期等逻辑检查不符等错误
	 */
	YELLOW("YELLOW", "黄"),

	/**
	 * 监控级别：外部错误；表示发生了外部业务错误；包括接口调用失败，报文参数解析等错误
	 */
	ORANGE("ORANGE", "橙"),

	/**
	 * 监控级别：紧急错误；表示发生了紧急业务错误；包括如预付费不够将会引起下属所有交易失败的需要马上通知处理的错误提示；
	 */
	RED("RED", "红");

	private String code;

	private String name;

	DtWarningLevelEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}
