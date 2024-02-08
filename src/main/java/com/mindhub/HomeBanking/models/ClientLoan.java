package com.mindhub.HomeBanking.models;
import jakarta.persistence.*;

@Entity
public class ClientLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "payments_id")
    private Payments payments;

    public ClientLoan() {
    }

    public ClientLoan(Client client, Loan loan, double amount) {
        this.client = client;
        this.loan = loan;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Payments getPayments() {
        return payments;
    }

    public int setPayments(Payments payments) {
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
                '}';
    }


    public void setPayments(int i) {
    }
}