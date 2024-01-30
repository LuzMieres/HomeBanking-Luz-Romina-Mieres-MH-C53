package com.mindhub.HomeBanking.controllers;


import com.mindhub.HomeBanking.client.Client;
import com.mindhub.HomeBanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @GetMapping
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    @GetMapping("/{id}")
    public Client getOneClientById (@PathVariable Long id){
        return clientRepository.findById(id).orElse(null);
    }
}