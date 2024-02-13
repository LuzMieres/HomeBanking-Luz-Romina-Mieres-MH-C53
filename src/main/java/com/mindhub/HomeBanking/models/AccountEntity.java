package com.mindhub.HomeBanking.models;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="account_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private ClientEntity client;
    private String number;

    private double balance;

    private LocalDate creationDate;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    Set<TransactionEntity> transaction = new HashSet<>();

    public AccountEntity(){

    }

    public AccountEntity(String number, double balance, LocalDate creationDate) {
        this.number = number;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public ClientEntity getClient() {
        return client;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Set<TransactionEntity> getTransactions() {
        return transaction;
    }

    public void addTransaction(TransactionEntity transaction){
        transaction.setAccount(this);
        this.transaction.add(transaction);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", creationDate=" + creationDate +
                '}';
    }
}