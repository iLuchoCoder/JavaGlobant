package com.java.testing.service.impl;

import com.java.testing.persistence.PersonsRepository;
import com.java.testing.persistence.model.Person;
import com.java.testing.service.PersonService;
import com.java.testing.service.model.PersonDTO;
import com.java.testing.util.Validators;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonsRepository repository;

    @Override
    public List<PersonDTO> getAll() {
        return repository.findAll().stream().map(person -> PersonDTO.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .build())
            .toList();
    }

    @Override
    public PersonDTO getPersonById(Integer id) {
        if (Validators.isValidId(id)){
            Person person = repository.findById(id).orElseThrow(() -> new RuntimeException("can't find the person"));
            return PersonDTO.builder()
                    .id(person.getId())
                    .firstName(person.getFirstName())
                    .lastName(person.getLastName())
                    .build();
        } else {
            throw new RuntimeException("invalid id");
        }
    }
}
