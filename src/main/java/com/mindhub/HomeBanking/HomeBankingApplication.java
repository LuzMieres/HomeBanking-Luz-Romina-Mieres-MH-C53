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
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository, PaymentsRepository paymentsRepository, ClientLoanRepository clientLoanRepository, CardRepository cardRepository) {
		return args -> {
			ClientEntity melba = new ClientEntity("Melba", "Morel", "melba@mindhub.com");

			AccountEntity account1 = new AccountEntity("VIN002", 5000, LocalDate.now());
			AccountEntity account2 = new AccountEntity("VIN001", 7500, LocalDate.now().plusDays(1));

			TransactionEntity pagoServicioLuz = new TransactionEntity(-3000, "DEBIN PAGO SERVICIO", LocalDate.now(), TransactionType.DEBIT);
			TransactionEntity transferenciaRecibida = new TransactionEntity(1500, "CR INTERBANK", LocalDate.now().plusDays(1), TransactionType.CREDIT);

			LoanEntity mortgage = new LoanEntity("Hipoteca", 500000, new HashSet<>(Arrays.asList(12, 24, 36, 48, 60)));
			LoanEntity personalLoan = new LoanEntity("Personales", 100000, new HashSet<>(Arrays.asList(6, 12, 24)));
			LoanEntity autoLoan = new LoanEntity("Automotrices", 300000, new HashSet<>(Arrays.asList(6, 12, 24, 36)));

			// Crear otro cliente
			ClientEntity luz = new ClientEntity("Luz", "Mieres", "luzmieres@gmail.com");
			clientRepository.save(luz);

			// Crear tarjeta de débito GOLD para Melba
			CardEntity debitCard = new CardEntity();
			debitCard.setCardHolder(melba.getName() + " " + melba.getLastName());
			debitCard.setNumber("3325-6745-7876-4445");
			debitCard.setCvv("990");
			debitCard.setFromDate(LocalDate.now());
			debitCard.setThruDate(LocalDate.now().plusYears(5));
			debitCard.setType(CardType.DEBIT);
			debitCard.setColor(CardColor.GOLD);
			debitCard.setClient(melba);

			// Crear tarjeta de crédito Titanium para Melba
			CardEntity creditCardTitanium = new CardEntity();
			creditCardTitanium.setCardHolder(melba.getName() + " " + melba.getLastName());
			creditCardTitanium.setNumber("2234-6745-5522-7888");
			creditCardTitanium.setCvv("750");
			creditCardTitanium.setFromDate(LocalDate.now());
			creditCardTitanium.setThruDate(LocalDate.now().plusYears(5));
			creditCardTitanium.setType(CardType.CREDIT);
			creditCardTitanium.setColor(CardColor.TITANIUM);
			creditCardTitanium.setClient(melba);

			// Crear tarjeta de crédito plateada para el segundo cliente (Luz)
			CardEntity silverCreditCard = new CardEntity();
			silverCreditCard.setCardHolder(luz.getName() + " " + luz.getLastName());
			silverCreditCard.setNumber("2034-6589-3456-8997");
			silverCreditCard.setCvv("237");
			silverCreditCard.setFromDate(LocalDate.now());
			silverCreditCard.setThruDate(LocalDate.now().plusYears(5));
			silverCreditCard.setType(CardType.CREDIT);
			silverCreditCard.setColor(CardColor.SILVER);
			silverCreditCard.setClient(luz);

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
			cardRepository.save(debitCard);
			cardRepository.save(creditCardTitanium);
			cardRepository.save(silverCreditCard);

			ClientLoanEntity melbaHipotecario = new ClientLoanEntity(melba, mortgage, 400000);
			melbaHipotecario.setPayments(60);
			clientLoanRepository.save(melbaHipotecario);

			ClientLoanEntity melbaPersonalLoan = new ClientLoanEntity(melba, personalLoan, 50000);
			melbaPersonalLoan.setPayments(12);
			clientLoanRepository.save(melbaPersonalLoan);

			ClientLoanEntity luzPrestamoPersonal = new ClientLoanEntity(luz, personalLoan, 100000);
			luzPrestamoPersonal.setPayments(24);
			clientLoanRepository.save(luzPrestamoPersonal);

			ClientLoanEntity luzPrestamoAutomotor = new ClientLoanEntity(luz, autoLoan, 200000);
			luzPrestamoAutomotor.setPayments(36);
			clientLoanRepository.save(luzPrestamoAutomotor);

			System.out.println(melba);
			System.out.println(account1);
			System.out.println(account2);
			System.out.println(pagoServicioLuz);
			System.out.println(transferenciaRecibida);
			System.out.println(melbaHipotecario);
			System.out.println(melbaPersonalLoan);
			System.out.println(luzPrestamoPersonal);
			System.out.println(luzPrestamoAutomotor);
		};
	}
}