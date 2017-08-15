package com.javarticle.spring.service;

import com.javarticle.spring.dao.IAuthorDAO;
import com.javarticle.spring.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ChrisDAgostino on 8/10/17.
 */

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private IAuthorDAO authorDAO;



    @Override
    public Author GetAuthorById(int id) {
        return authorDAO.GetAuthorById(id);

    }
    @Override
    public List<Author> GetAllAuthors(){
        return authorDAO.GetAllAuthors();
    }
    @Override
    public void UpsertAuthor(Author author){
        authorDAO.UpsertAuthor(author);
    }

    @Override
    public void DeleteAuthor(int id) {
        authorDAO.DeleteAuthor(id);
    }
}
