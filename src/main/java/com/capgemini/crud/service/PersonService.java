package com.capgemini.crud.service;

import com.capgemini.crud.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> findAll();
    Optional<Person> findByPnumber(String pnumber);
    Person savePerson(Person person);
    Person updatePerson(Person person);
    void deletePerson(String pnumber);
}
