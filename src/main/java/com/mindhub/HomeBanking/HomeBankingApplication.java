package com.mindhub.HomeBanking;

import com.mindhub.HomeBanking.models.*;
import com.mindhub.HomeBanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class HomeBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeBankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository, PaymentsRepository paymentsRepository, ClientLoanRepository clientLoanRepository) {
		return args -> {
			Client melba = new Client("Melba", "Morel", "melba@mindhub.com");

			Account account1 = new Account("VIN002", 5000, LocalDate.now());
			Account account2 = new Account("VIN001", 7500, LocalDate.now().plusDays(1));

			Transaction pagoServicioLuz = new Transaction(-3000, "DEBIN PAGO SERVICIO", LocalDate.now(), TransactionType.DEBIT);
			Transaction transferenciaRecibida = new Transaction(1500, "CR INTERBANK", LocalDate.now().plusDays(1), TransactionType.CREDIT);

			Loan mortgage = new Loan("Hipoteca", 500000, new HashSet<>(Arrays.asList(12, 24, 36, 48, 60)));
			Loan personalLoan = new Loan("Personales", 100000, new HashSet<>(Arrays.asList(6, 12, 24)));
			Loan autoLoan = new Loan("Automotrices", 300000, new HashSet<>(Arrays.asList(6, 12, 24, 36)));

			melba.addAccount(account1);
			melba.addAccount(account2);

			account1.addTransaction(pagoServicioLuz);
			account2.addTransaction(transferenciaRecibida);

			clientRepository.save(melba);
			accountRepository.save(account1);
			accountRepository.save(account2);
			transactionRepository.save(pagoServicioLuz);
			transactionRepository.save(transferenciaRecibida);
			loanRepository.save(mortgage);
			loanRepository.save(personalLoan);
			loanRepository.save(autoLoan);

			// Crear las entidades ClientLoan
			ClientLoan melbaHipotecario = new ClientLoan(melba, mortgage, 400000);
			melbaHipotecario.setPayments(60);
			clientLoanRepository.save(melbaHipotecario);

			ClientLoan melbaPersonalLoan = new ClientLoan(melba, personalLoan, 50000);
			melbaPersonalLoan.setPayments(12);
			clientLoanRepository.save(melbaPersonalLoan);

			// Crear otro cliente
			Client luz = new Client("Luz", "Mieres", "luzmieres@gmail.com");
			clientRepository.save(luz);

			// Crear préstamos para otro cliente
			ClientLoan otroClientePersonal = new ClientLoan(luz, personalLoan, 100000);
			otroClientePersonal.setPayments(24);
			clientLoanRepository.save(otroClientePersonal);

			ClientLoan otroClienteAutomotor = new ClientLoan(luz, autoLoan, 200000);
			otroClienteAutomotor.setPayments(36);
			clientLoanRepository.save(otroClienteAutomotor);

			System.out.println(melba);
			System.out.println(account1);
			System.out.println(account2);
			System.out.println(pagoServicioLuz);
			System.out.println(transferenciaRecibida);
		};
	}
}