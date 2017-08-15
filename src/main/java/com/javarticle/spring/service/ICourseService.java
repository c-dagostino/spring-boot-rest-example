package com.javarticle.spring.service;

import com.javarticle.spring.entity.Course;

import java.util.List;

/**
 * Created by ChrisDAgostino on 8/10/17.
 */
public interface ICourseService {

    List<Course> GetAllCourses();
    Course GetCourseById(int id);
    void UpsertCourse(Course course);
    void DeleteCourse(int id);
}
