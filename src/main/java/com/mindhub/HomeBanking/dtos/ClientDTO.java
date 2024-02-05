package com.mindhub.HomeBanking.dtos;

import com.mindhub.HomeBanking.client.Client;

import java.util.Set;
import java.util.stream.Collectors;


public class ClientDTO {
    private Long id;
    private String nombre;
    private String email;
    private Set<AccountDTO> accounts;


    public ClientDTO() {}

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.nombre = client.getName();
        this.email = client.getEmail();
        this.accounts = client.getAccounts().stream().map(AccountDTO::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Set<AccountDTO> getAccounts() {return accounts; }

}
