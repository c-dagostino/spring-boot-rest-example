package com.javarticle.spring.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by chris-dagostino on 8/9/17.
 */

@Entity
@Table(name="course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="course_id")
    private int id;

    @Column(name="title")
    @NotNull (message = "courses.error.title.notnull")
    @Size(min = 0, max = 100, message = "courses.error.title.size")
    private String title;

    @Column(name="category")
    @NotNull (message = "courses.error.category.notnull")
    @Size(min = 1, max = 30, message = "courses.error.category.size")
    private String category;

    @Column(name="author_id")
    @NotNull (message = "courses.error.author_id.notnull")
    private int authorId;

    @Column(name="course_length")
    private String length;

    @Column(name="watch_href")
    @Size(min = 0, max = 300, message = "articles.error.category.size")
    private String watchHref;


    public Course()
    {

    }

    public Course(int id, String title, int authorId, String watchHref, String length, String category)
    {
        this.id = id;
        this.title = title;
        this.watchHref = watchHref;
        this.authorId = authorId;
        this.length = length;
        this.category = category;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWatchHref() {
        return this.watchHref;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public String getLength() {
        return this.length;
    }

    public String getCategory() {
        return this.category;
    }

    public void setId(int val){
        this.id = val;
    }

    public void setTitle(String val){
        this.title = val;
    }

    public void setWatchHref(String val){
        this.watchHref = val;
    }

    public void setAuthorId(int val){
        this.authorId = val;
    }

    public void setLength(String val){
        this.length = val;
    }

    public void setCategory(String val){
        this.category = val;
    }
}
