package com.javarticle.spring.service;

import com.javarticle.spring.entity.Article;

import java.util.List;

/**
 * Created by darrell-shofstall on 8/9/17.
 */
public interface IArticleService {

    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    boolean addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
}
