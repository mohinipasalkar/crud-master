package com.hyperscale.crudmaster.controllers;

import com.hyperscale.crudmaster.models.Person;
import com.hyperscale.crudmaster.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudController {

    @Autowired
    public PersonRepository personRepository;

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String helloTest(){
        return "Hello welcome to Hyperscale-developers";
    }

    @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public String createPerson(@RequestBody Person p){
        Person newPerson = personRepository.saveAndFlush(p);
        return"Created person with id: "+newPerson.getId();
    }

    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> showPersons(){
        return personRepository.findAll();
    }

    @GetMapping("/persons/{person_id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Person> showPerson(@PathVariable Long person_id){
        return personRepository.findById(person_id);
    }

    @DeleteMapping("/persons/{person_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable("person_id") long pid){
        personRepository.deleteById(pid);
    }

    @PutMapping("/persons/{person_id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person p, @PathVariable long person_id){

        Person per =  personRepository.saveAndFlush(p);
        if(per == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(per);
    }
}
