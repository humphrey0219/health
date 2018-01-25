package com.ebrace.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 错误信息处理类
 * @author kent
 *
 * @param <T>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestResult<T> {
	
	private boolean result;
	private String message;
	private Integer errorCode;
	private T data; 

}
