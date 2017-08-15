package com.javarticle.spring.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by chris-dagostino on 8/9/17.
 */

@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="author_id")
    private int id;

    @Column(name="first_name")
    @NotNull (message = "courses.error.first_name.notnull")
    @Size(min = 0, max = 100, message = "authors.error.first_name.size")
    private String firstName;

    @Column(name="last_name")
    @NotNull (message = "courses.error.last_name.notnull")
    @Size(min = 0, max = 150, message = "authors.error.last_name.size")
    private String lastName;

    public Author(){};

    public Author(int id, String firstName, String lastName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }


    public void setId(int val){
        this.id = val;
    }

    public void setFirstName(String val){
        this.firstName = val;
    }

    public void setLastName(String val){
        this.lastName = val;
    }
}
