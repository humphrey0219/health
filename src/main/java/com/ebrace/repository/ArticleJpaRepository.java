package com.ebrace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebrace.entity.Article;

public interface ArticleJpaRepository extends JpaRepository<Article, Integer> {

}
