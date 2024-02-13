package com.mindhub.HomeBanking.DTO;

import com.mindhub.HomeBanking.models.TransactionEntity;
import com.mindhub.HomeBanking.models.TransactionType;

public class TransactionDTO {
    private Long id;
    private String  description;
    private double amount;

    private TransactionType type;

    public TransactionDTO(TransactionEntity transaction){
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