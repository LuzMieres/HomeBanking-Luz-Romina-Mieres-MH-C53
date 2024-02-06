package com.mindhub.HomeBanking.controllers;

import com.mindhub.HomeBanking.DTO.ClientDTO;
import com.mindhub.HomeBanking.models.Client;
import com.mindhub.HomeBanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    /*
    @GetMapping("/")
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }*/

    @GetMapping("/")
    public ResponseEntity<List<ClientDTO>> obtainClients(){
        List<Client> clients = clientRepository.findAll();

        return new ResponseEntity<>(clients.stream().map(ClientDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtainClientById(@PathVariable Long id){
        Client cliente = clientRepository.findById(id).orElse(null);

        if (cliente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found, sorry, try again later!");
        }
        ClientDTO clientDTO = new ClientDTO(cliente);
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }
    @GetMapping("/hello")
    public String getClients(){
        return "Hello Clients!";
    }



}