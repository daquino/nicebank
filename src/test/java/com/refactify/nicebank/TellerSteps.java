package com.refactify.nicebank;

import com.refactify.support.TestAccount;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:cucumber.xml")
public class TellerSteps {
    @Autowired
    private Teller teller;
    @Autowired
    private TestAccount account;

    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(final int amount) throws Throwable {
        teller.withdrawFrom(account, amount);
    }
}
