package com.adresse.micro_service_adresse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Adresse {

    //Attributs

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="rue")
    private String rue;

    @Column(name="codePostal")
    private String codePostal;

    @Column(name = "ville")
    private String ville;

    //Join with microservice personne

    private Long idPersonne;

    @Transient
    private Personne personne;
}
