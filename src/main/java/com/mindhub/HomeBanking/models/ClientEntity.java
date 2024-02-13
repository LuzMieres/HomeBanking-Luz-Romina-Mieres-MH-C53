package com.mindhub.HomeBanking.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="client_id")
    private Long id;

    private String name, lastName, email;

    @OneToMany(mappedBy="client", fetch = FetchType.EAGER)
    Set<AccountEntity> accounts = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<CardEntity> cards = new HashSet<>();
    public ClientEntity(){

    }

    public ClientEntity(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
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
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<AccountEntity> getAccounts() {
        return accounts;
    }

    public Set<CardEntity> getCards() {
        return cards;
    }

    public void setCards(Set<CardEntity> cards) {
        this.cards = cards;
    }

    public void addAccount(AccountEntity account){
        account.setClient(this);
        accounts.add(account);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", accounts=" + accounts +
                '}';
    }

    public Set<ClientLoanEntity> getClientLoans() {
        Set<ClientLoanEntity> clientLoans = new HashSet<>();
        return clientLoans;
    }

    public Set<LoanEntity> getLoans() {
        Set<LoanEntity> loans = new HashSet<>();
        for (ClientLoanEntity clientLoan : getClientLoans()) {
            loans.add(clientLoan.getLoan());
        }
        return loans;
    }

    public void addCard(CardEntity card) {
        cards.add(card);
        card.setClient(this);
    }

}
