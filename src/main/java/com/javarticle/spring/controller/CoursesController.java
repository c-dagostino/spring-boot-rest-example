package com.javarticle.spring.controller;

import com.javarticle.spring.dto.CourseDTO;
import com.javarticle.spring.dto.CoursesDTO;
import com.javarticle.spring.entity.Article;
import com.javarticle.spring.entity.Course;
import com.javarticle.spring.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ChrisDAgostino on 8/11/17.
 */
@RestController
public class CoursesController {

    @Autowired
    private ICourseService courseService;
    @Autowired
    private ModelMapper modelMapper;

    @CrossOrigin
    @RequestMapping(value = "course/{id}", method = RequestMethod.GET)
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Integer id) {
        CourseDTO dto = courseService.GetCourseById(id);

        return new ResponseEntity<CourseDTO>(dto, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "courses", method = RequestMethod.GET)
    public ResponseEntity<List<CourseDTO>> getAllCourses() {

        return new ResponseEntity<List<CourseDTO>>(courseService.GetAllCourses(), HttpStatus.OK);
    }

    @RequestMapping(value = "coursesByPage", method = RequestMethod.GET)
    public ResponseEntity<List<CourseDTO>> getPage(@RequestParam(name = "p", defaultValue = "1") int pageNumber) {

        List<CourseDTO> courses = courseService.GetPage(pageNumber);

        return new ResponseEntity(courses, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "course", method = RequestMethod.POST)
    public ResponseEntity<Void> upsertCourse(@Validated @RequestBody CourseDTO courseDto, UriComponentsBuilder builder) throws ParseException {

        Course course = ConvertToEntity(courseDto);
        courseService.UpsertCourse(course);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/course/{id}").buildAndExpand(course.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "course/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> DeleteCourse(@PathVariable("id") Integer id) {
        courseService.DeleteCourse(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    private CourseDTO convertToDto(Course course) {
        CourseDTO courseDto = modelMapper.map(course, CourseDTO.class);
        return courseDto;
    }

    private Course ConvertToEntity(CourseDTO courseDto) throws ParseException {
        Course course = modelMapper.map(courseDto, Course.class);

        return course;

    }

    private CoursesDTO buildResponseDto(Page<Course> courses, List<CourseDTO> listDto ) {

        CoursesDTO responseDto = new CoursesDTO();
        responseDto.setCourses(listDto);
        responseDto.setPageableDTO(courses);

        return responseDto;
    }


}
