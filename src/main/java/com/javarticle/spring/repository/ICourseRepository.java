package com.javarticle.spring.repository;

import com.javarticle.spring.entity.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by darrell-shofstall on 8/11/17.
 */
public interface ICourseRepository extends PagingAndSortingRepository<Course, Integer> {


}
