package com.javarticle.spring.repository;

import com.javarticle.spring.entity.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by darrell-shofstall on 8/11/17.
 */
public interface IArticleRepository extends PagingAndSortingRepository<Article, Integer> {


}
