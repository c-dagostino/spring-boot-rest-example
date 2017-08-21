package com.javarticle.spring.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by darrell-shofstall on 8/11/17.
 */
public class AuthorDTO extends BaseDTO{

    private static final long serialVersionUID = 1L;

    private int authorId;


    @NotNull (message = "courses.error.first_name.notnull")
    @Size(min = 0, max = 100, message = "authors.error.first_name.size")
    private String firstName;


    @NotNull (message = "courses.error.last_name.notnull")
    @Size(min = 0, max = 150, message = "authors.error.last_name.size")
    private String lastName;

    public AuthorDTO(){};

    public AuthorDTO(int id, String firstName, String lastName)
    {
        this.authorId = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public int getId() {
        return this.authorId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }


    public void setId(int val){
        this.authorId = val;
    }

    public void setFirstName(String val){
        this.firstName = val;
    }

    public void setLastName(String val){
        this.lastName = val;
    }
}
