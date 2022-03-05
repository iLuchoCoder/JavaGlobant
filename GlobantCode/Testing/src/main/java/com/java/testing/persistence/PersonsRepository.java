package com.java.testing.persistence;

import com.java.testing.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<Person, Integer> {


}
