package com.luchoglober.controller;

import com.luchoglober.models.Student;
import com.luchoglober.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService sService;

    @GetMapping(path="/getStudents")
    public List<Student> listStudents(){
        return sService.listStudents();
    }

    @GetMapping(path="/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        try{
            Student s = sService.getStudentById(id);
            return new ResponseEntity<Student>(s,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/registerStudent")
    public void saveStudent(@RequestBody Student student){
        sService.saveStudent(student);
    }

    @PutMapping(path="/updateStudentById/{id}")
    public ResponseEntity<?> updateStudentById(@RequestBody Student student, @PathVariable Integer id){
        try{
            Student sExist = sService.getStudentById(id);

            sExist.setStudent_id(student.getStudent_id());
            sExist.setFirstName(student.getFirstName());
            sExist.setLastName(student.getLastName());
            sExist.setMail(student.getMail());
            sExist.setCellphone(student.getCellphone());

            sService.saveStudent(sExist);
            return new ResponseEntity<Student>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path="/deleteStudentById/{id}")
    public void deleteStudentById(@PathVariable Integer id){
        sService.deleteStudentById(id);
    }
}
