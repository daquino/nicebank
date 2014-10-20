package com.refactify.support;

import com.refactify.nicebank.Account;

public class KnowsTheAccount {
    private Account account;

    public Account getMyAccount() {
        if(account == null) {
            account = new Account(1234);
            account.saveIt();
        }
        return account;
    }
}
