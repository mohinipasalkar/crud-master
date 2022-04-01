package com.hyperscale.crudmaster.controllers;

import com.hyperscale.crudmaster.models.Person;
import com.hyperscale.crudmaster.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CrudController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/hello")
    public String helloTest(){
        return "Hello welcome to Hyperscale-developers";
    }

    @PostMapping("/person")
    public String createPerson(@RequestBody Person p){
        Person newPerson = personRepository.saveAndFlush(p);
        return"Created person with id: "+newPerson.getId();
    }

    @GetMapping("/persons")
    public List<Person> showPersons(){
        return personRepository.findAll();
    }
}
