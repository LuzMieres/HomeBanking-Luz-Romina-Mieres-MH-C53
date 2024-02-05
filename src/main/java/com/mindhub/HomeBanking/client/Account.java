package com.mindhub.HomeBanking.client;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Account {
    LocalDate account1 = LocalDate.now();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "client-id")
    private Client client;

    private Double balance;
    private LocalDate creationDate;
    private String number;



    public Account() { }

    public Account(Double balance, LocalDate creationDate, String number) {
        this.balance = balance;
        this.creationDate = creationDate;
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public Long getId() {
        return id;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                ", number='" + number + '\'' +
                '}';
    }


}
