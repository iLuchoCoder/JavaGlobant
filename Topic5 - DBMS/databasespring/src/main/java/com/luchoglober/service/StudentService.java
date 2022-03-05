package com.luchoglober.service;

import com.luchoglober.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luchoglober.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository sRepo;

    public List<Student> listStudents() {
        return sRepo.findAll();
    }

    public void saveStudent(Student student) {
        sRepo.save(student);
    }

    public Student getStudentById(Integer id) {
        return sRepo.findById(id).get();
    }

    public void deleteStudentById(Integer id) {
        sRepo.deleteById(id);
    }
}
