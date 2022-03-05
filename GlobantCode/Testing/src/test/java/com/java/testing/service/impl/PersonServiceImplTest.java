package com.java.testing.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.java.testing.persistence.PersonsRepository;
import com.java.testing.persistence.model.Person;
import com.java.testing.service.model.PersonDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImplTest {

    @Mock
    private PersonsRepository repository;

    @InjectMocks
    private PersonServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEmpty() {
        when(repository.findAll()).thenReturn(this.mockList(true));

        List<PersonDTO> result = service.getAll();

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void testGetAll() {
        when(repository.findAll()).thenReturn(this.mockList(false));

        List<PersonDTO> result = service.getAll();

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(2, result.get(1).getId());
    }

    private List<Person> mockList(boolean empty) {
        if (empty) {
            return new ArrayList();
        }

        List<Person> personsMock = new ArrayList();
        personsMock.add(Person.builder().id(1).firstName("John").lastName("Doe").build());
        personsMock.add(Person.builder().id(2).firstName("Peter").lastName("Parker").build());
        personsMock.add(Person.builder().id(3).firstName("Anthony").lastName("Stark").build());

        return personsMock;
    }

}
