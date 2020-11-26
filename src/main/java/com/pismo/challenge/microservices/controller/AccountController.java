package com.pismo.challenge.microservices.controller;

import com.pismo.challenge.microservices.dto.AccountDto;
import com.pismo.challenge.microservices.dto.AccountResultDto;
import com.pismo.challenge.microservices.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public AccountResultDto create(@RequestBody AccountDto accountDto) {

        return accountService.create(accountDto);
    }

    @GetMapping("/{id}")
    public AccountResultDto find(@PathVariable Long id) {

        return accountService.find(id);
    }
}
