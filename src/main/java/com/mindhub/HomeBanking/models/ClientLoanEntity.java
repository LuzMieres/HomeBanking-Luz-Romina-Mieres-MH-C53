package com.mindhub.HomeBanking.models;
import jakarta.persistence.*;

@Entity
public class ClientLoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ClientEntity client;

    @ManyToOne
    private LoanEntity loan;

    private double amount;

    @ManyToOne
    private PaymentsEntity payments;

    public ClientLoanEntity() {
    }

    public ClientLoanEntity(ClientEntity client, LoanEntity loan, double amount) {
        this.client = client;
        this.loan = loan;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public LoanEntity getLoan() {
        return loan;
    }

    public void setLoan(LoanEntity loan) {
        this.loan = loan;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentsEntity getPayments() {
        return payments;
    }

    public int setPayments(PaymentsEntity payments) {
        this.payments = payments;
        return setPayments(payments);
    }

    @Override
    public String toString() {
        return "ClientLoan{" +
                "id=" + id +
                ", client=" + client +
                ", loan=" + loan +
                ", amount=" + amount +
                ", payments=" + payments +
                '}';
    }

    public void setPayments(int i) {
    }
}