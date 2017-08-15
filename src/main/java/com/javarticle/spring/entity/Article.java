package com.javarticle.spring.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by darrell-shofstall on 8/9/17.
 */

@Entity
@Table(name="articles")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="article_id")
    private int articleId;
    @Column(name="title")
    @Size(min = 0, max = 100, message = "articles.error.title.size")
    private String title;
    @Column(name="category")
    @NotNull (message = "articles.error.category.notnull")
    @Size(min = 1, max = 30, message = "articles.error.category.size")
    private String category;
    public int getArticleId() {
        return articleId;
    }
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
