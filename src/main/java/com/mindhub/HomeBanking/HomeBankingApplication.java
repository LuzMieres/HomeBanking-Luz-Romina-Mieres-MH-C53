package com.mindhub.HomeBanking;

import com.mindhub.HomeBanking.client.Client;
import com.mindhub.HomeBanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBankingApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData (ClientRepository clientRepository){
		return args -> {
			Client melba = new Client("Melba", "Morel", "melba@mindhub.com");
			Client ana = new Client("Ana", "Gonzalez", "anaGonzalez@gmail.com");
			Client luz = new Client("Luz", "Mieres", "luzmieres@gmail.com");
			clientRepository.save(melba);
			clientRepository.save(ana);
			clientRepository.save(luz);
			System.out.println(melba);
			System.out.println(ana);
			System.out.println(luz);

		};
	}
}