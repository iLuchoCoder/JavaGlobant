package com.java.testing.controller;

import com.java.testing.service.PersonService;
import com.java.testing.service.model.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService service;


    @GetMapping(path = "/persons")
    public List<PersonDTO> getAllPersons() {
        return service.getAll();
    }
}
