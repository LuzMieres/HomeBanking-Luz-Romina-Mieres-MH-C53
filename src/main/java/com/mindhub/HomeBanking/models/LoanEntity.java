package com.mindhub.HomeBanking.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="loanEntity_id")
    private Long id;

    private String name;
    private double maxAmount;

    @ElementCollection
    private Set<Integer> dues = new HashSet<>();

    @ManyToMany
    private Set<ClientLoanEntity> clients = new HashSet<>();

    public LoanEntity() {
    }

    public LoanEntity(String name, double maxAmount, Set<Integer> dues) {
        this.name = name;
        this.maxAmount = maxAmount;
        this.dues = dues;
    }



    public Set<ClientLoanEntity> getClients() {
        return clients;
    }

    // Método para obtener la lista de clientes para un préstamo
    public Set<ClientEntity> getClientList() {
        Set<ClientEntity> clientList = new HashSet<>();
        for (ClientLoanEntity clientLoan : clients) {
            clientList.add(clientLoan.getClient());
        }
        return clientList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Set<Integer> getDues() {
        return dues;
    }

    public void setDues(Set<Integer> dues) {
        this.dues = dues;
    }

    public void setClients(Set<ClientLoanEntity> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxAmount=" + maxAmount +
                ", dues=" + dues +
                ", clients=" + clients +
                '}';
    }
}