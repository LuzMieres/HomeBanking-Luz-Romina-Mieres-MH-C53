package com.mindhub.HomeBanking;

import com.mindhub.HomeBanking.client.Account;
import com.mindhub.HomeBanking.client.Client;
import com.mindhub.HomeBanking.repositories.AccountRepository;
import com.mindhub.HomeBanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HomeBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBankingApplication.class, args);
	}
	 // Create a date object

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository) {
		return args -> {
			Client melba = new Client("Melba", "Morel", "melba@mindhub.com");
			Account account1 = new Account(5000.0, LocalDate.now(), "VIN001");
			Account account2 = new Account(7500.0, LocalDate.now().plusDays(1), "VIN002");
            Client ana = new Client("Ana", "Gonzalez", "anagonzalez@gmail.com");
			Client luz = new Client("Luz", "Mieres", "luzmieres@gmail.com");
			// Asociar cuentas al cliente
			melba.addAccount(account1);
			melba.addAccount(account2);

			// Guardar el cliente actualizado
			clientRepository.save(melba);
			accountRepository.save(account1);
			accountRepository.save(account2);
			clientRepository.save(ana);
			clientRepository.save(luz);
			System.out.println(melba);
			System.out.println(ana);
			System.out.println(luz);
		};
	}
}