package com.ebrace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebrace.entity.Article;
import com.ebrace.exception.EbraceException;
import com.ebrace.exception.ResultEnum;
import com.ebrace.service.impl.ArticleService;
import com.ebrace.util.RestResult;
import com.ebrace.util.ResultUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	ArticleService articleService;
	
	@GetMapping("/hello")
	public RestResult<?> greet() throws EbraceException {
		articleService.greet();
		return ResultUtil.success("Dome echo success!");
		
	}
	
	@GetMapping("/hi")
	public RestResult<?> hi() throws EbraceException {
		try {
			int x = 1/0;
			log.info("hello success! x = "+ x);
		} catch (Exception e) {
			log.error(e.toString());
			throw new EbraceException(ResultEnum.TESTERROR);
		}		
		return ResultUtil.success("Dome echo success!");
		
	}
	
	@GetMapping("/echo")
	public RestResult<?> demoecho() {
		log.info("Dome echo success");
		return ResultUtil.success("Dome echo success");
	}
	
	@PostMapping("/article")
	public RestResult<?> saveArticle(Article article) {
	
		return ResultUtil.success(articleService.saveArticle(article));
	}
	
	@GetMapping("/article/{id}")
	public RestResult<?> findArticleById(@PathVariable("id") Integer id) {
		return ResultUtil.success(articleService.findArticleById(id));
	}
	
	@DeleteMapping("/article/{id}")
	public RestResult<?> deleteArticleById(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return ResultUtil.success("delete id:"+ id + "success");
	}
	
	

}
