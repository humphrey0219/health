/**
 * 
 */
package com.ebrace.exception;

/**
 * @author kent
 * 自定义异常
 */
public class EbraceException extends RuntimeException {
	private static final long serialVersionUID = 4992451002735902872L;
	
	private Integer code;
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}

	public EbraceException(ResultEnum result) {
		super(result.getMessage());
		this.code = result.getCode();
	}
	

	

	/**
	 * @param cause
	 */
	public EbraceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EbraceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public EbraceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
