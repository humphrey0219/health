package com.ebrace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebrace.entity.Article;
import com.ebrace.exception.EbraceException;
import com.ebrace.repository.ArticleJpaRepository;
import com.ebrace.service.IArticleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArticleService implements IArticleService {
	
	@Autowired
	private ArticleJpaRepository articleJpaRepository;

	@Override
	public List<Article> findAll() throws EbraceException{
		return articleJpaRepository.findAll();
	}

	@Override
	public Article findArticleById(Integer id) throws EbraceException{
		return articleJpaRepository.findOne(id);
	}

	@Override
	public Article saveArticle(Article article) throws EbraceException{
		Article a = articleJpaRepository.save(article);
		return a;
	}

	@Override
	public void deleteArticle(Integer id) throws EbraceException{
		
		Article a = articleJpaRepository.findOne(id);
		
		articleJpaRepository.delete(a);

	}

	@Override
	public void greet() throws EbraceException {
		int a = 1/0;
		log.info("a value is {}",a);
		
	}

}
