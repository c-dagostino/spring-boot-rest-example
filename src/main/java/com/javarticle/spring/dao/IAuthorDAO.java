package com.javarticle.spring.dao;

import com.javarticle.spring.entity.Author;

import java.util.List;

/**
 * Created by darrell-shofstall on 8/9/17.
 */
public interface IAuthorDAO {

    List<Author> GetAllAuthors();
    Author GetAuthorById(int id);
    void UpsertAuthor(Author course);
    void DeleteAuthor(int id);
}