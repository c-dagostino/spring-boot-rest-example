package com.javarticle.spring.dto;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by ChrisDAgostino on 8/15/17.
 */
public class CoursesDTO  extends PageableDTO {

    private static final long serialVersionUID = 1L;

    private List<CourseDTO> courses;

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }

    public void setPageableDTO(Page page) {
        this.setCurrentPageNumber(page.getNumber());
        this.setTotalElements(page.getTotalElements());
        this.setTotalPages(page.getTotalPages());
        this.setHasNextPage(page.hasNext());
        this.setHasPreviousPage(page.hasPrevious());
        this.setFirstPage(page.isFirst());
        this.setLastPage(page.isLast());
        this.setNumberOfElements(page.getNumberOfElements());
        this.setPageSize(page.getSize());
    }


    public CoursesDTO() {
    }

}
