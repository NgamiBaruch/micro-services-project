package com.microservices.micro_service_personne.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.micro_service_personne.dao.PersonneRepository;
import com.microservices.micro_service_personne.entity.Personne;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PersonneController {

    //instance of personneRepository

    private PersonneRepository personneRepository;

    //Create a personne

    @PostMapping("/personne/create")
    public Personne createPersonne(@RequestBody Personne personne)
    {
        return personneRepository.save(personne);
    }

    //Get all personnes

    @GetMapping("/personnes")
    public ResponseEntity<List<Personne>> getAllPersonnes()
    {
        return ResponseEntity.ok(personneRepository.findAll());
    }

    // Get a person by num

    @GetMapping("/personnes/{num}")
    public ResponseEntity<Personne> getPersonneByNum(@PathVariable("num") Long num)
    {
        return personneRepository.findById(num)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    

}
