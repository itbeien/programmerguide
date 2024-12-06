package com.beien.exception;


/**
 * <p>Description: </p>
 * @date 2023年5月21日
 * @author itbeien.cn
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class DtComponentException extends AbstractDtException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2333790764399190094L;

	private IDtErrorCode moponErrorCode;

	private String extendErrorMessage;

	/**
	 * 该属性可以为空，在业务组应用该组件是该属性不能为空.
	 */
	private Class<? extends AbstractMoponMonitorData> moponMonitorData;

    public DtComponentException(IDtErrorCode moponErrorCode) {
        super(moponErrorCode.getSelfDefineCode() + ":" + moponErrorCode.getMessage());
        this.moponErrorCode = moponErrorCode;
    }


	public DtComponentException(IDtErrorCode moponErrorCode, String extendErrorMessage) {
		super(moponErrorCode.getSelfDefineCode() + ":" + moponErrorCode.getMessage() + "["
				+ extendErrorMessage + "]");
		this.moponErrorCode = moponErrorCode;
		this.extendErrorMessage = extendErrorMessage;
	}

	public DtComponentException(IDtErrorCode moponErrorCode, String extendErrorMessage,
								Class<? extends AbstractMoponMonitorData> moponMonitorData) {
		super(moponErrorCode.getSelfDefineCode() + ":" + moponErrorCode.getMessage() + "["
				+ extendErrorMessage + "]");
		this.moponErrorCode = moponErrorCode;
		this.extendErrorMessage = extendErrorMessage;
		this.moponMonitorData = moponMonitorData;
	}

	public IDtErrorCode getMoponErrorCode() {
		return moponErrorCode;
	}

	public void setMoponErrorCode(IDtErrorCode moponErrorCode) {
		this.moponErrorCode = moponErrorCode;
	}

	public String getExtendErrorMessage() {
		return extendErrorMessage;
	}

	public void setExtendErrorMessage(String extendErrorMessage) {
		this.extendErrorMessage = extendErrorMessage;
	}

	public Class<? extends AbstractMoponMonitorData> getMoponMonitorData() {
		return moponMonitorData;
	}

	public void setMoponMonitorData(Class<? extends AbstractMoponMonitorData> moponMonitorData) {
		this.moponMonitorData = moponMonitorData;
	}

}
