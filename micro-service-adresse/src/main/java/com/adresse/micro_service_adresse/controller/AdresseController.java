package com.adresse.micro_service_adresse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adresse.micro_service_adresse.dao.AdresseRepository;
import com.adresse.micro_service_adresse.entity.Adresse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AdresseController {

    //Attributs

    private PersonneRestController personneRestController;

    private AdresseRepository adresseRepository;

    //Get all adress

    @GetMapping("/adresses")
    public List<Adresse> getAdresses()
    {
        List<Adresse> adresses = adresseRepository.findAll();
        for(Adresse a : adresses)
        {
            a.setPersonne(personneRestController.getPersonne(a.getIdPersonne()));
        }

        return adresses;
    }

    //Create adresses

    @PostMapping("/adresses/create")
    public Adresse addAdresse(@RequestBody Adresse adresse)
    {
        return adresseRepository.save(adresse);
    }

    //getAdress by id

    @GetMapping("/adresses/{id}")
    public Adresse getAdresse(@PathVariable("id") Long id)
    {
        Adresse a = adresseRepository.findById(id).orElse(null);
        a.setPersonne(personneRestController.getPersonne(a.getIdPersonne()));
        return a;
    }




}
