package com.ebrace.exception;

/**
 * 错误码规则，暂定：
 * 101000为公共类的错误
 * 102000为医生业务功能的错误
 * 103000为技工业务功能的错误
 * 104000为消息业务功能的错误
 * 105000为权限业务功能的错误
 * @author kent
 *
 */
public enum ResultEnum {
	
	UNKNOW_ERROR(-1,"未知错误"),
	SUCCESS(0,"成功")	,
	TESTERROR(101001,"故意测试的错误");
	
	
	ResultEnum( Integer code, String message){
        this.code = code;
        this.message = message;
    }
	
	private Integer code;
	private String message;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
