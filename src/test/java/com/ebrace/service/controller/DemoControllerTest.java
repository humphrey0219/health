//package com.ebrace.service.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
////import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
////import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import lombok.extern.slf4j.Slf4j;
//
//
//@Slf4j
//@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
//@SpringBootTest
//@AutoConfigureMockMvc
//public class DemoControllerTest {
//	
//	@Autowired
//	private MockMvc mvc;
//	
//	/**
//	 * 单元测试echo
//	 */
//	@Test
//	public void testDemoecho()throws Exception {
//		String content =
//		mvc.perform(get("/demo/echo")).andExpect(status().isOk()).andExpect(content()
//				.string("{\"result\":true,\"message\":\"success\",\"errorCode\":0,\"data\":\"Dome echo success\"}"))
//		.andDo(print())
//		.andReturn().getResponse().getContentAsString()
//		;
//		
//		log.info("====================");
//		log.info("content is :{}",content);
//		
//	}
//	
//	
//	
//	
//
//}
