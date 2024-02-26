package com.mindhub.HomeBanking.models;

import com.mindhub.HomeBanking.DTO.ClientLoanDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name, lastName, email;

    @OneToMany(mappedBy="client", fetch = FetchType.EAGER)
    Set<Account> accounts = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<ClientLoan> clientLoans = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private List<Card> cards = new ArrayList<>();

    @Column(name = "password")
    private String password;

    public Client(){

    }

    public Client(String name, String lastName, String email) {
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

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<ClientLoan> getClientLoans() {
        return clientLoans;
    }

    public void setClientLoans(Set<ClientLoan> clientLoans) {
        this.clientLoans = clientLoans;
    }

    public List<ClientLoanDTO> getLoans(){
        return this.getClientLoans().stream().map(ClientLoanDTO::new).toList();
    }

    public List<Card> getCard() {
        return cards;
    }

    public void setCard(List<Card> card) {
        this.cards = card;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addAccount(Account account){
        account.setClient(this);
        accounts.add(account);
    }

    public void addCard(Card card){
        card.setClient(this);
        cards.add(card);
    }

    public void addClientLoans(ClientLoan clientLoan){
        clientLoan.setClient(this);
        clientLoans.add(clientLoan);
    }
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", accounts=" + accounts +
                ", cards=" + cards +
                '}';
    }

}