package com.mindhub.HomeBanking.DTO;

import com.mindhub.HomeBanking.models.AccountEntity;

import java.time.LocalDate;

public class AccountDTO {

    private Long id;

    private double balance;

    private String number;

    private LocalDate creationDate;

    public AccountDTO(){

    }

    public AccountDTO(AccountEntity account){
        this.id = account.getId();
        this.balance = account.getBalance();
        this.number = account.getNumber();
        this.creationDate = account.getCreationDate();
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
}