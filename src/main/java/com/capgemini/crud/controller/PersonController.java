package com.capgemini.crud.controller;

import com.capgemini.crud.entity.Person;
import com.capgemini.crud.json.ErrorResponse;
import com.capgemini.crud.json.SuccessResponse;
import com.capgemini.crud.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> findAllPeople() {
        List<Person> people = personService.findAll();
        if(people.size() > 0)
            return ResponseEntity.ok(people);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/{pnumber}")
    public ResponseEntity<Person> findPersonByPnumber(@PathVariable("pnumber") String pnumber) {
        Optional<Person> person =  personService.findByPnumber(pnumber);
        if(person.isPresent()) {
            return ResponseEntity.ok(person.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity savePerson(@Valid @RequestBody Person person) {
        Optional<Person> temp = personService.findByPnumber(person.getPnumber());
        if(temp.isPresent()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Person with specefied pnumber already exists"));
        } else {
            return ResponseEntity.ok(personService.savePerson(person));
        }
    }

    @PutMapping
    public ResponseEntity updatePerson(@Valid @RequestBody Person person) {
        Optional<Person> temp = personService.findByPnumber(person.getPnumber());
        if(temp.isPresent()) {
            return ResponseEntity.ok(personService.savePerson(person));
        } else {
            return ResponseEntity.badRequest().body(new ErrorResponse("Cannot update details as specified person does not exist"));
        }
    }

    @DeleteMapping("/{pnumber}")
    public ResponseEntity deletePerson(@PathVariable String pnumber) {
        Optional<Person> temp = personService.findByPnumber(pnumber);
        if(temp.isPresent()) {
            personService.deletePerson(pnumber);
            return ResponseEntity.ok().body(new SuccessResponse("Person deleted successfully"));
        } else {
            return ResponseEntity.badRequest().body(new ErrorResponse("Person not deleted as they do not exist"));
        }
    }
}
