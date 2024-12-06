package com.beien.exception;


import com.beien.exception.data.AbstractDtMonitorData;

import java.util.Objects;

/**
 * 业务异常类型:用于业务校验出现异常对外跑出改异常类型
 * 异常类附带包含有监控预警的信息
 * <p>Description: </p>
 * @date 2023年5月21日
 * @author
 * @version 1.0
 * <p>Copyright:Copyright(c)2023</p>
 */
public class DtBusinessException extends AbstractDtException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8760915806948863203L;

	/**
	 * 错误码
	 */
	private IDtErrorCode dtErrorCode;

	/**
	 * 扩展错误信息
	 */
	private String extendErrorMessage;

	/**
	 *
	 */
	private AbstractDtMonitorData abstractDtMonitorData;

	public DtBusinessException(IDtErrorCode moponErrorCode, AbstractDtMonitorData abstractMoponMonitorData) {
		super(moponErrorCode.getErroCodePrefix().getDtProductProjectCode() + ":" + moponErrorCode.getMessage());
		this.dtErrorCode = moponErrorCode;
		this.abstractDtMonitorData = abstractDtMonitorData;
	}

	public DtBusinessException(IDtErrorCode moponErrorCode, String extendErrorMessage,
							   AbstractDtMonitorData abstractMoponMonitorData) {
		super(moponErrorCode.getErroCodePrefix().getDtProductProjectCode() + ":" + moponErrorCode.getMessage() + ":"
				+ (Objects.nonNull(extendErrorMessage) ? extendErrorMessage : ""));
		this.dtErrorCode = moponErrorCode;
		this.extendErrorMessage = extendErrorMessage;
		this.abstractDtMonitorData = abstractDtMonitorData;
	}

	public IDtErrorCode getDtErrorCode() {
		return dtErrorCode;
	}

	public AbstractDtMonitorData getMonitorData() {
		return abstractDtMonitorData;
	}

	public String getExtendErrorMessage() {
		return extendErrorMessage;
	}
}
