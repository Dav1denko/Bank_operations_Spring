package com.Bank.utils;

import com.Bank.entity.Account;
import com.Bank.entity.Bill;
import com.Bank.exceptions.NotDefaultBillException;

public class AccountUtils {

    public static Bill findDefaultBill(Account accountFrom) {
        return accountFrom.getBills().stream().filter(Bill::getDefault).
                findAny().
                orElseThrow(() -> new NotDefaultBillException("Unable to find default bill for account with id: "
                        + accountFrom.getAccountId()));
    }
}
