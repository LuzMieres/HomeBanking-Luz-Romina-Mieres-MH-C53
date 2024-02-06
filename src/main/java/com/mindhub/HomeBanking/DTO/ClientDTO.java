package com.mindhub.HomeBanking.DTO;

import com.mindhub.HomeBanking.models.Client;

import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {

    private Long id;
    private String name, lastName,email;

    private Set<AccountDTO> accounts;

    public ClientDTO(){

    }

    public ClientDTO(Client cliente){
        this.id = cliente.getId();
        this.name = cliente.getName();
        this.lastName =  cliente.getLastName();
        this.email = cliente.getEmail();
        this.accounts = cliente.getAccounts().stream().map(AccountDTO::new).collect(Collectors.toSet());
    }

    public String getLastName() {
        return lastName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<AccountDTO> getAccounts() {
        return accounts;
    }

    public String getEmail() {
        return email;
    }
}