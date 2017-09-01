package com.javarticle.spring.service;

import com.javarticle.spring.dao.CourseDAO;
import com.javarticle.spring.dao.ICourseDAO;
import com.javarticle.spring.dto.CourseDTO;
import com.javarticle.spring.dto.CoursesDTO;
import com.javarticle.spring.entity.Course;
import com.javarticle.spring.repository.ICourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ChrisDAgostino on 8/10/17.
 */

@Service
public class CourseService implements ICourseService {


    @Autowired
    private ICourseDAO courseDAO;
    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseDTO GetCourseById(int id) {

        Course course = courseDAO.GetCourseById(id);

        return ConvertToDto(course);

    }
    @Override
    public List<CourseDTO> GetAllCourses(){

        List<Course> courses = courseDAO.GetAllCourses();
        return courses.stream().map(item -> ConvertToDto(item)).collect(Collectors.toList());
    }
    @Override
    public void UpsertCourse(Course course){
        courseDAO.UpsertCourse(course);
    }

    @Override
    public void DeleteCourse(int id) {
        courseDAO.DeleteCourse(id);
    }

    @Override
    public CoursesDTO GetPage(int pageNumber, int pageSize) {
        Pageable request = new PageRequest(pageNumber, pageSize, Sort.Direction.ASC, "courseId");
        Page<Course> coursePage = courseRepository.findAll(request);

       List<CourseDTO> courses = coursePage.map(course -> ConvertToDto(course)).getContent();

        return BuildResponseDto(coursePage, courses);
    }

    @Override
    public CourseDTO ConvertToDto(Course course) {
        CourseDTO courseDto = modelMapper.map(course, CourseDTO.class);
        return courseDto;
    }

    @Override
    public Course ConvertToEntity(CourseDTO courseDto) throws ParseException {
        Course course = modelMapper.map(courseDto, Course.class);

        return course;

    }

    @Override
    public CoursesDTO BuildResponseDto(Page<Course> courses, List<CourseDTO> listDto ) {

        CoursesDTO responseDto = new CoursesDTO();
        responseDto.setCourses(listDto);
        responseDto.setPageableDTO(courses);

        return responseDto;
    }
}
