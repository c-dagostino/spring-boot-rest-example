package com.javarticle.spring.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by darrell-shofstall on 8/11/17.
 */
public class CourseDTO extends BaseDTO{

    private static final long serialVersionUID = 1L;

    private int courseId;

    @NotNull (message = "courses.error.title.notnull")
    @Size(min = 0, max = 100, message = "courses.error.title.size")
    private String title;


    @NotNull (message = "courses.error.category.notnull")
    @Size(min = 1, max = 30, message = "courses.error.category.size")
    private String category;


    @NotNull (message = "courses.error.author_id.notnull")
    private int authorId;


    private String length;

    @Size(min = 0, max = 300, message = "articles.error.category.size")
    private String watchHref;


    public CourseDTO()
    {

    }

    public CourseDTO(int id, String title, int authorId, String watchHref, String length, String category)
    {
        this.courseId = id;
        this.title = title;
        this.watchHref = watchHref;
        this.authorId = authorId;
        this.length = length;
        this.category = category;
    }

    public int getId() {
        return this.courseId;
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
        this.courseId = val;
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
