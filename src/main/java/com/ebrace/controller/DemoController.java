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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Api(value = "DemoController", description = "demo接口")
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	ArticleService articleService;
	
	
	@ApiOperation(value="测试程序", notes="测试service端抛出异常之后，是否能自动捕捉处理")
	@GetMapping("/hello")
	public RestResult<?> greet() throws EbraceException {
		articleService.greet();
		return ResultUtil.success("Dome echo success!");
		
	}
	
	@ApiOperation(value="测试程序2", notes="测试controller 端抛出EbraceException异常之后，是否能自动捕捉处理")
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
	
	@ApiOperation(value="测试echo", notes="最简单的rest测试")
	@GetMapping("/echo")
	public RestResult<?> demoecho() {
		log.info("Dome echo success");
		return ResultUtil.success("Dome echo success");
	}
	
	@ApiOperation(value="saveArticle", notes="保存文章测试")
	@PostMapping("/article")
	public RestResult<?> saveArticle(Article article) {
	
		return ResultUtil.success(articleService.saveArticle(article));
	}
	
	@ApiOperation(value="findArticleById", notes="根据ID查询文章")
	@GetMapping("/article/{id}")
	public RestResult<?> findArticleById(@PathVariable("id") Integer id) {
		return ResultUtil.success(articleService.findArticleById(id));
	}
	
	@ApiOperation(value="deleteArticle", notes="删除文章")
	@DeleteMapping("/article/{id}")
	public RestResult<?> deleteArticleById(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return ResultUtil.success("delete id:"+ id + "success");
	}
	
	
	
	

}
