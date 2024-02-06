package com.mindhub.HomeBanking.DTO;

import com.mindhub.HomeBanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;

public class TransactionDTO {
    private Long id;
    private String  description;
    private double amount;

    private com.mindhub.homebanking.models.TransactionType type;

    public TransactionDTO(Transaction transaction){
        this.id = transaction.getId();
        this.amount = transaction.getAmount();
        this.type = transaction.getType();
        this.description = transaction.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}