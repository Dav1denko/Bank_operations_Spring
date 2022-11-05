package com.Bank.controller;

import com.Bank.controller.dto.DepositRequestDTO;
import com.Bank.controller.dto.PaymentRequestDTO;
import com.Bank.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {

    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/deposits")
    public Object deposit(@RequestBody DepositRequestDTO depositRequestDTO) {
        return depositService.deposit(depositRequestDTO.getAccountId(), depositRequestDTO.getAmount());
    }
}
