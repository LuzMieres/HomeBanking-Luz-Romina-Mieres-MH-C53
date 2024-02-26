package com.mindhub.HomeBanking.controllers;


import com.mindhub.HomeBanking.DTO.AccountDTO;
import com.mindhub.HomeBanking.models.Account;
import com.mindhub.HomeBanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    public ResponseEntity<List<AccountDTO>> getAllAccounts(){
        List<Account> accounts = (List<Account>) accountRepository.findAll();

        return new ResponseEntity<>(accounts.stream().map(AccountDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneAccById(@PathVariable Long id){
        Account account = accountRepository.findById(id).orElse(null);

        if(account == null) {
            return new ResponseEntity<>("The ID does not match with our db, try again", HttpStatus.NOT_FOUND);
        }
        AccountDTO accountDTO = new AccountDTO(account);

        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }
}