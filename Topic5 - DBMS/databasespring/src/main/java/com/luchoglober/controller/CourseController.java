package com.luchoglober.controller;

import com.luchoglober.models.Course;
import com.luchoglober.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService cService;

    @GetMapping(path="/getCourses")
    public List<Course> listCourses(){
        return cService.listCourses();
    }

    @GetMapping(path="/getCourseById/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id){
        try{
            Course c = cService.getCourseById(id);
            return new ResponseEntity<Course>(c, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/registerCourse")
    public void saveCourse(@RequestBody Course course){
        cService.saveCourse(course);
    }

    @PutMapping(path="/updateCourseById/{id}")
    public ResponseEntity<?> updateCourseById(@RequestBody Course course, @PathVariable Integer id){
        try{
            Course cExist = cService.getCourseById(id);

            cExist.setCourse_id(course.getCourse_id());
            cExist.setCourseName(course.getCourseName());

            cService.saveCourse(cExist);
            return new ResponseEntity<Course>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path="/deleteCourseById/{id}")
    public void deleteCourseById(@PathVariable Integer id){
        cService.deleteCourseById(id);
    }

}
