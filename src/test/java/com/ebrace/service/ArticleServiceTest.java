package com.ebrace.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ebrace.entity.Article;
import com.ebrace.service.impl.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArticleServiceTest {

	
	@Autowired
	ArticleService articleService;
	
//	@Test
//	public void testfindAll(){
//		List<Article> list = articleService.findAll();
//		Assert.assertEquals(3, list.size());
//	}
//	
	@Test
	public void testfindArticleById() {
		Article a = articleService.findArticleById(3);
		Assert.assertEquals("kent", a.getCreater());
		
	}
	
//	@Test
//	public void testSaveArticle() {
//		Article article = new Article();
//		article.setContent("大漠孤烟直，长河落日圆");
//		article.setTitle("唐诗");
//		article.setCreater("humphrey");
//		article.setCreateDate(new Date());
//		articleService.saveArticle(article);
//		Article article2 =articleService.findArticleById(1);
//		Assert.assertEquals(article.getContent(), article2.getContent());
//		
//	}
//	
//	@Test
//	public void deleteArticle() {		
//		articleService.deleteArticle(5);
//		List<Article> list = articleService.findAll();
//		Assert.assertEquals(3, list.size());
//	}

}
