package com.mindhub.HomeBanking;

import com.mindhub.HomeBanking.models.Account;
import com.mindhub.HomeBanking.models.Client;
import com.mindhub.HomeBanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;
import com.mindhub.HomeBanking.repositories.AccountRepository;
import com.mindhub.HomeBanking.repositories.ClientRepository;
import com.mindhub.HomeBanking.repositories.TransactionRepository;
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

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository){
		return args -> {
			Client melba = new Client( "Melba", "Morel", "melba@mindhub.com");
			System.out.println(melba);


			Account account1 = new Account("VIN002",5000, LocalDate.now());
			Account account2 = new Account("VIN001",7500, LocalDate.now().plusDays(1));

			Transaction pagoServicioLuz = new Transaction(-3000, "DEBIN PAGO SERVICIO",LocalDate.now(),TransactionType.DEBIT);
			Transaction transferenciaRecibida = new Transaction(1500, "CR INTERBANK",LocalDate.now().plusDays(1),TransactionType.CREDIT);

			melba.addAccount(account1);
			melba.addAccount(account2);

			account1.addTransaction(pagoServicioLuz);
			account2.addTransaction(transferenciaRecibida);

			clientRepository.save(melba);
			accountRepository.save(account1);
			accountRepository.save(account2);
			transactionRepository.save(pagoServicioLuz);
			transactionRepository.save(transferenciaRecibida);
			System.out.println(melba);
			System.out.println(account1);
			System.out.println(account2);
			System.out.println(pagoServicioLuz);
			System.out.println(transferenciaRecibida);

		};
	}

}