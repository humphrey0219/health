package com.ebrace.service;

import java.util.List;

import com.ebrace.entity.Article;
import com.ebrace.exception.EbraceException;

public interface IArticleService {
	
	public void greet()throws EbraceException;
	
	public List<Article> findAll()throws EbraceException;
	
	public Article findArticleById(Integer id)throws EbraceException;
	
	public Article saveArticle(Article article)throws EbraceException;
	
	public void deleteArticle(Integer id)throws EbraceException;
	
	

}
