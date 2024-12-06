package com.beien.exception;

/**
 * 异常处理规范公用抽象类
 * <p>Description: </p>
 * @date 2023年5月21日
 * @author itbeien.cn
 * @version 1.0
 * <p>Copyright:Copyright(c)2023</p>
 */
public abstract class AbstractDtException extends Exception {

	public AbstractDtException(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -369559404517534369L;

}
