package com.microservices.micro_service_personne;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.microservices.micro_service_personne.dao.PersonneRepository;
import com.microservices.micro_service_personne.entity.Personne;
import com.netflix.discovery.shared.Application;

@SpringBootApplication
public class MicroServicePersonneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicePersonneApplication.class, args);
	}

	//Test de l'application

	@Bean
	ApplicationRunner start(PersonneRepository personneRepository)
	{
		return args -> {
			personneRepository.save(new Personne(null, "John", "Doe"));
			personneRepository.save(new Personne(null, "Alice", "Johnson"));
			personneRepository.save(new Personne(null, "Bob", "Brown"));

			//personneRepository.findAll().forEach(System.out::println);
		};
	}

}
