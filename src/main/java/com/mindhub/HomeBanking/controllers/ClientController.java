package com.mindhub.HomeBanking.controllers;

import com.mindhub.HomeBanking.DTO.CardDTO;
import com.mindhub.HomeBanking.DTO.ClientDTO;
import com.mindhub.HomeBanking.DTO.ClientLoanDTO;
import com.mindhub.HomeBanking.models.Client;
import com.mindhub.HomeBanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/")
    public ResponseEntity<List<ClientDTO>> obtainClients(){
        List<Client> clients = clientRepository.findAll();

        return new ResponseEntity<>(clients.stream().map(ClientDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtainClientById(@PathVariable Long id){
        Client client = clientRepository.findById(id).orElse(null);

        if (client == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found, sorry, try again later!");
        }
        ClientDTO clientDTO = new ClientDTO(client);
        List<ClientLoanDTO> clientLoanDTOs = client.getClientLoans().stream()
                .map(ClientLoanDTO::new)
                .collect(Collectors.toList());
        clientDTO.setLoans(clientLoanDTOs);
        List<CardDTO> cardDTOs = client.getCard().stream()
                .map(CardDTO::new)
                .collect(Collectors.toList());
        clientDTO.setCards(cardDTOs);
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }
    @GetMapping("/hello")
    public String getClients(){
        return "Hello Clients!";
    }
}