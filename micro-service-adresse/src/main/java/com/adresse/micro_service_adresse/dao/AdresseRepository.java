package com.adresse.micro_service_adresse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adresse.micro_service_adresse.entity.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

}
