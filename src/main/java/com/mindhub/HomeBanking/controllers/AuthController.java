package com.mindhub.HomeBanking.controllers;

import com.mindhub.HomeBanking.DTO.ClientDTO;
import com.mindhub.HomeBanking.models.Client;
import com.mindhub.HomeBanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/auth")
    @CrossOrigin(origins = "http://localhost:5173")
    public class AuthController {

        @Autowired
        private ClientRepository clientRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @PostMapping("/register")
        public ResponseEntity<?> registerUser(@RequestBody ClientDTO clientDTO) {
            Client client = new Client(clientDTO.getName(), clientDTO.getLastName(), clientDTO.getEmail());
            client.setPassword(passwordEncoder.encode(clientDTO.getPassword()));
            clientRepository.save(client);

            return ResponseEntity.ok("User registered successfully");
        }
    }

