package com.javarticle.spring.service;

import com.javarticle.spring.dto.CourseDTO;
import com.javarticle.spring.dto.CoursesDTO;
import com.javarticle.spring.entity.Article;
import com.javarticle.spring.entity.Course;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.List;

/**
 * Created by ChrisDAgostino on 8/10/17.
 */
public interface ICourseService {

    List<CourseDTO> GetAllCourses();
    CourseDTO GetCourseById(int id);
    void UpsertCourse(Course course);
    void DeleteCourse(int id);
    List<CourseDTO> GetPage(int pageNumber);
    CourseDTO ConvertToDto(Course course);
    Course ConvertToEntity(CourseDTO courseDto) throws ParseException;
    CoursesDTO BuildResponseDto(Page<Course> courses, List<CourseDTO> listDto );
}
