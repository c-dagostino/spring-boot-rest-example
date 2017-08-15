package com.javarticle.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import com.javarticle.spring.entity.Author;
import com.javarticle.spring.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by ChrisDAgostino on 8/11/17.
 */
@RestController
public class AuthorsController {

    @Autowired
    private IAuthorService authorService;

    @CrossOrigin
    @RequestMapping(value = "author/{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") Integer id) {
        Author course = authorService.GetAuthorById(id);
        return new ResponseEntity<Author>(course, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> list = authorService.GetAllAuthors();
        return new ResponseEntity<List<Author>>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "author", method = RequestMethod.POST)
    public ResponseEntity<Void> upsertAuthor(@Validated @RequestBody Author author, UriComponentsBuilder builder) {
        authorService.UpsertAuthor(author);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/author/{id}").buildAndExpand(author.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "author/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> DeleteAuthor(@PathVariable("id") Integer id) {
        authorService.DeleteAuthor(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}

