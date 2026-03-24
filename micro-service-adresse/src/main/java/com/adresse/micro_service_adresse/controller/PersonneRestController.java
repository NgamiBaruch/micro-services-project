package com.adresse.micro_service_adresse.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.adresse.micro_service_adresse.entity.Personne;

@FeignClient(name = "micro-service-personne")
//@RequestMapping("/api")
public interface PersonneRestController {

    @GetMapping("/api/personnes")
    public List<Personne> getPersonnes();

    @GetMapping("/api/personnes/{num}")
    public Personne getPersonne(@PathVariable("num") Long num);

}
