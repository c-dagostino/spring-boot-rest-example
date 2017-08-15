package com.javarticle.spring.dao;

import com.javarticle.spring.entity.Article;

import java.util.List;

/**
 * Created by darrell-shofstall on 8/9/17.
 */
public interface IArticleDAO {

    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
    boolean articleExists(String title, String category);
}
