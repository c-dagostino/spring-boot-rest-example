package com.javarticle.spring.controller;

import com.javarticle.spring.entity.Article;
import com.javarticle.spring.entity.Course;
import com.javarticle.spring.service.ICourseService;
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
public class CoursesController {

    @Autowired
    private ICourseService courseService;

    @CrossOrigin
    @RequestMapping(value = "course/{id}", method = RequestMethod.GET)
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id) {
        Course course = courseService.GetCourseById(id);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "courses", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> list = courseService.GetAllCourses();
        return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "course", method = RequestMethod.POST)
    public ResponseEntity<Void> upsertCourse(@Validated @RequestBody Course course, UriComponentsBuilder builder) {
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


}
