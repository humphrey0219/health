package com.ebrace.util;

import com.ebrace.exception.ResultEnum;

/**
 * 成功失败的工具类
 * @author kent
 *
 */
public class ResultUtil {
	
	/** 返回默认成功 */
	public static RestResult<?> success(){
		return RestResult.builder().errorCode(0).result(true).message("success").build();
	}
	
	/** 返回结果带有默认返回值 */
	public static RestResult<?> success(Object data){
		return RestResult.builder().errorCode(0).result(true).message("success").data(data).build();
	}
	
	/** 失败 带上错误吗以及错误消息 */	
	public static RestResult<?> failed(final int code, String message) {
		return RestResult.builder().result(false).errorCode(code).message(message).build();
	}
	
	/** 失败 带上错误吗以及错误消息以及消息体 */	
	public static RestResult<?> failed(final int code, String message,Object data) {
		return RestResult.builder().result(false).errorCode(code).message(message).data(data).build();
	}
	
	/** 失败 带上错误吗以及错误消息 */	
	public static RestResult<?> failed(ResultEnum re) {
		return RestResult.builder().result(false).errorCode(re.getCode()).message(re.getMessage()).build();
	}

}
