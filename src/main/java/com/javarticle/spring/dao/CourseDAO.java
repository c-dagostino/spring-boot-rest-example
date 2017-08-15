package com.javarticle.spring.dao;

/**
 * Created by ChrisDAgostino on 8/11/17.
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.javarticle.spring.entity.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class CourseDAO implements ICourseDAO {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Course GetCourseById(int id) {
        return entityManager.find(Course.class, id);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Course> GetAllCourses() {

        String hql = "FROM Course as c ORDER BY c.id";
        return (List<Course>) entityManager.createQuery(hql).getResultList();
    }
    @Override
    public void UpsertCourse(Course course) {
        Course dbCourse = entityManager.find(Course.class, course.getId());

        if (dbCourse != null)
        {
            dbCourse.setTitle(course.getTitle());
            dbCourse.setAuthorId(course.getAuthorId());
            dbCourse.setCategory(course.getCategory());
            dbCourse.setLength(course.getLength());
            dbCourse.setWatchHref(course.getWatchHref());
        }
        else {
            entityManager.persist(course);
        }

    }


    @Override
    public void DeleteCourse(int id) {
        entityManager.remove(GetCourseById(id));
    }

}