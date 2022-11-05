package com.Bank.service;

import com.Bank.entity.Account;
import com.Bank.entity.Bill;
import com.Bank.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DepositService {

    private final AccountService accountService;

    @Autowired
    public DepositService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Object deposit(Long accountId, BigDecimal depositAmount) {
        Account account = accountService.getById(accountId);
        Bill defaultBill = AccountUtils.findDefaultBill(account);
        defaultBill.setAmount(defaultBill.getAmount().add(depositAmount));
        accountService.update(account);
        return "deposit Success";


    }
}
