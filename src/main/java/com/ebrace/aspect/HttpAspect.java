package com.ebrace.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class HttpAspect {
	
	ThreadLocal<Long> startTime = new ThreadLocal<>();  
	
	@Pointcut("execution(public * com.ebrace.controller..*(..))")
	public void webLog() {
		
	}
	
	@Before("webLog()")  
	public void doBefore(JoinPoint joinPoint) {
		startTime.set(System.currentTimeMillis());  
		  
        // 接收到请求，记录请求内容  
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
        HttpServletRequest request = attributes.getRequest();  
        
        // 记录下请求内容  
        log.info("URL : {}" , request.getRequestURL().toString());  
        log.info("HTTP_METHOD : ()" , request.getMethod());  
        log.info("IP : {}" , request.getRemoteAddr());  
        log.info("CLASS_METHOD : {} . {}" , joinPoint.getSignature().getDeclaringTypeName() ,joinPoint.getSignature().getName());  
        log.info("ARGS : {}" , Arrays.toString(joinPoint.getArgs()));  
	}
	
	@AfterReturning(returning = "ret", pointcut = "webLog()")  
    public void doAfterReturning(Object ret) throws Throwable {  
        // 处理完请求，返回内容  
		if(null != ret) {
			log.info("RESPONSE : {}" , ret.toString()); 
		}
		 
		log.info("SPEND TIME : {}" , (System.currentTimeMillis() - startTime.get()));  
    }  
	
	

}
