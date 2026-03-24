package com.adresse.micro_service_adresse;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.adresse.micro_service_adresse.dao.AdresseRepository;
import com.adresse.micro_service_adresse.entity.Adresse;
import com.adresse.micro_service_adresse.entity.Personne;

@EnableFeignClients
@SpringBootApplication
public class MicroServiceAdresseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceAdresseApplication.class, args);
	}

	//Donnees de test 

	@Bean
	ApplicationRunner start(AdresseRepository repository)
	{
		return args ->
		{
			repository.save(new Adresse(null,"1234T","BP2345","Yaounde",null,new Personne()));
			repository.save(new Adresse(null,"234T","BP235","Buea",null,new Personne()));
		};
	}

}
