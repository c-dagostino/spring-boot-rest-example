package com.javarticle.spring.service;

import com.javarticle.spring.dao.ICourseDAO;
import com.javarticle.spring.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ChrisDAgostino on 8/10/17.
 */

@Service
public class CourseService implements ICourseService {

    @Autowired
    private ICourseDAO courseDAO;



    @Override
    public Course GetCourseById(int id) {
        return courseDAO.GetCourseById(id);

    }
    @Override
    public List<Course> GetAllCourses(){
        return courseDAO.GetAllCourses();
    }
    @Override
    public void UpsertCourse(Course course){
        courseDAO.UpsertCourse(course);
    }

    @Override
    public void DeleteCourse(int id) {
        courseDAO.DeleteCourse(id);
    }
}
