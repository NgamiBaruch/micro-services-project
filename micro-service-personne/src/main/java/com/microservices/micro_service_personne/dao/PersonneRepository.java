package com.microservices.micro_service_personne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.micro_service_personne.entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
