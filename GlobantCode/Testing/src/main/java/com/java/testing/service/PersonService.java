package com.java.testing.service;

import com.java.testing.service.model.PersonDTO;

import java.util.List;

public interface PersonService {

    List<PersonDTO> getAll();

    PersonDTO getPersonById(Integer id);
}
