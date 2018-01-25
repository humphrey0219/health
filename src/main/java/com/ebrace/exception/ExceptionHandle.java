package com.ebrace.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebrace.util.RestResult;
import com.ebrace.util.ResultUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResult<?> handler( Exception e){
        if( e instanceof EbraceException){
        	EbraceException ebraceException = (EbraceException) e;
            return ResultUtil.failed( ebraceException.getCode(), ebraceException.getMessage());
        }else {
            log.info("[系统异常] {}",e);
            return ResultUtil.failed(ResultEnum.UNKNOW_ERROR.getCode(),ResultEnum.UNKNOW_ERROR.getMessage());// -1, "未知错误");
        }
    }

}
