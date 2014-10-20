package com.refactify.support;

import com.refactify.nicebank.Account;

public class TestAccount extends Account {
    public TestAccount() {
        super(1234);
        saveIt();
    }
}
