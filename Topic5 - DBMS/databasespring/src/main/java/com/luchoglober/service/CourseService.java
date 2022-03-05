package com.luchoglober.service;

import com.luchoglober.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luchoglober.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository cRepo;

    public List<Course> listCourses() {
        return cRepo.findAll();
    }

    public void saveCourse(Course course) {
        cRepo.save(course);
    }

    public Course getCourseById(Integer id) {
        return cRepo.findById(id).get();
    }

    public void deleteCourseById(Integer id) {
        cRepo.deleteById(id);
    }
}
