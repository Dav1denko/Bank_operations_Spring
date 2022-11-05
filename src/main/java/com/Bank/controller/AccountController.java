package com.Bank.controller;


import com.Bank.controller.dto.AccountRequestDTO;
import com.Bank.controller.dto.AccountResponseDTO;
import com.Bank.entity.Bill;
import com.Bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{accountID}")
    public AccountResponseDTO getByID(@PathVariable Long accountID) {
        return new AccountResponseDTO(accountService.getById(accountID));
    }

    @PostMapping("/accounts")
    public Long create(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.save(accountRequestDTO.getName(),
                accountRequestDTO.getEmail(), accountRequestDTO.getBills().stream()
                        .map(billRequestDTO -> new Bill(billRequestDTO.getAmount(), billRequestDTO.getDefault()))
                        .collect(Collectors.toList()));

    }
}
