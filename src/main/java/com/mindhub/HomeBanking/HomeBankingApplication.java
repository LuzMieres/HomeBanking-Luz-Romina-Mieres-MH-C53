package com.mindhub.HomeBanking;

import com.mindhub.HomeBanking.models.*;
import com.mindhub.HomeBanking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.Set;

@SpringBootApplication
public class HomeBankingApplication {


	public static int cvv(){
		Random rand = new Random();
		int randomNumber = rand.nextInt(900) + 100;
		return randomNumber;
	}


	public static void main(String[] args) {
		SpringApplication.run(HomeBankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository, LoanRepository loanRepository, ClientLoanRepository clientLoanRepository, CardRepository cardRepository){
		return args -> {

			Client melba = new Client( "Melba", "Morel", "melba@mindhub.com");
			Client luz = new Client("Luz", "Mieres", "luzmieres@gmail.com");
			System.out.println(melba);

			Account vin001 = new Account("VIN001",7500, LocalDate.now().plusDays(1));
			Account vin002 = new Account("VIN002",5000, LocalDate.now());

			Transaction transfereniaRecibida = new Transaction(3000, "CR CREDIT INTERBANK",LocalDate.now(),TransactionType.CREDIT);
			Transaction pagoServicioLuz = new Transaction(-2500, "PAGO SERVICIO LUZ",LocalDate.now().plusDays(1),TransactionType.DEBIT);

			melba.addAccount(vin001);
			melba.addAccount(vin002);

			luz.addAccount(vin002);

			vin001.addTransaction(pagoServicioLuz);
			vin002.addTransaction(transfereniaRecibida);

			Loan hipoteca = new Loan("Hipoteca", 500000, Set.of(12,24,36,48,60));
			Loan personal = new Loan("Personal",100000, Set.of(6,12,24));
			Loan automotriz = new Loan("Automotriz", 300000, Set.of(6,12,24,36));

			ClientLoan clientLoan1 = new ClientLoan(400000, 24, melba, hipoteca);
			ClientLoan clientLoan2 = new ClientLoan(100000, 12, luz,personal);
			ClientLoan clientLoan3 = new ClientLoan(150000, 24, luz, automotriz);

			hipoteca.addClientLoans(clientLoan1);
			personal.addClientLoans(clientLoan2);
			automotriz.addClientLoans(clientLoan3);

			melba.addClientLoans(clientLoan1);
			luz.addClientLoans(clientLoan2);
			luz.addClientLoans(clientLoan3);

			clientRepository.save(luz);
			clientRepository.save(melba);
			accountRepository.save(vin002);
			accountRepository.save(vin001);
			transactionRepository.save(transfereniaRecibida);
			transactionRepository.save(pagoServicioLuz);
			loanRepository.save(hipoteca);
			loanRepository.save(personal);
			loanRepository.save(automotriz);
			clientLoanRepository.save(clientLoan1);
			clientLoanRepository.save(clientLoan2);
			clientLoanRepository.save(clientLoan3);
			System.out.println(melba);
			System.out.println(luz);
			LocalDate now = LocalDate.now();
			LocalDate trhu = LocalDate.now().plusYears(5);
			Card debitC = new Card(melba.getName()+" "+melba.getLastName(),CardColor.GOLD ,TransactionType.DEBIT, cvv(),"4005-4548-1457-3648", now, trhu);
			Card creditC = new Card(melba.getName()+" "+melba.getLastName(),CardColor.TITANIUM ,TransactionType.CREDIT, cvv(),"4045-1158-2238-2648", now, trhu);
			Card debitC2 = new Card(luz.getName()+" "+luz.getLastName(),CardColor.SILVER ,TransactionType.DEBIT, cvv(),"4255-4823-4572-4688", now, trhu);
			melba.addCard(debitC);
			melba.addCard(creditC);
			luz.addCard(debitC2);
			cardRepository.save(debitC);
			cardRepository.save(debitC2);
			cardRepository.save(creditC);
			clientRepository.save(luz);
			clientRepository.save(melba);
			System.out.println(debitC2);

		};
	}

}
