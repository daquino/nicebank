package com.refactify.support;

import com.refactify.nicebank.Account;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class TestAccount extends Account {
    public TestAccount() {
        super(1234);
        saveIt();
    }
}
