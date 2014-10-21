package com.refactify.support;

import com.refactify.nicebank.Account;

public class AccountFactory {
    public static Account createTestAccount() {
        Account account = new Account(1234);
        account.saveIt();
        return account;
    }
}
