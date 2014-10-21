package com.refactify.support;

import com.refactify.nicebank.Account;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class TestAccount extends Account {
    public TestAccount() {
        super(1234);
        saveIt();
    }
}
