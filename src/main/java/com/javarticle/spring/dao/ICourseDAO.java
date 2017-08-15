package com.javarticle.spring.dao;

import com.javarticle.spring.entity.Course;

import java.util.List;

/**
 * Created by darrell-shofstall on 8/9/17.
 */
public interface ICourseDAO {

    List<Course> GetAllCourses();
    Course GetCourseById(int id);
    void UpsertCourse(Course course);
    void DeleteCourse(int id);
}
