package com.javarticle.spring.service;

import com.javarticle.spring.entity.Author;

import java.util.List;

/**
 * Created by ChrisDAgostino on 8/10/17.
 */
public interface IAuthorService {

    List<Author> GetAllAuthors();
    Author GetAuthorById(int id);
    void UpsertAuthor(Author course);
    void DeleteAuthor(int id);
}
