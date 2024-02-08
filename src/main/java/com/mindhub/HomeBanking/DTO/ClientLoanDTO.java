package com.mindhub.HomeBanking.DTO;

import com.mindhub.HomeBanking.models.ClientLoan;
import com.mindhub.HomeBanking.models.Payments;

public class ClientLoanDTO {
    private Long id;
    private Long loanId;
    private String loanName;
    private double amountRequested;
    private Payments payments;

    public ClientLoanDTO(ClientLoan clientLoan) {
        this.id = clientLoan.getId();
        this.loanId = clientLoan.getLoan().getId();
        this.loanName = clientLoan.getLoan().getName();
        this.amountRequested = clientLoan.getAmount();
        this.payments = clientLoan.getPayments();
    }

    public Long getId() {
        return id;
    }

    public Long getLoanId() {
        return loanId;
    }

    public String getLoanName() {
        return loanName;
    }

    public double getAmountRequested() {
        return amountRequested;
    }

    public Payments getPayments() {
        return payments;
    }
}
