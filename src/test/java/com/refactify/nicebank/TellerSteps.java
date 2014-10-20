package com.refactify.nicebank;

import com.refactify.support.AtmUserInterface;
import com.refactify.support.TestAccount;
import cucumber.api.java.en.When;

public class TellerSteps {
    private Teller teller;
    private TestAccount account;

    public TellerSteps(final AtmUserInterface teller, final TestAccount account) {
        this.teller = teller;
        this.account = account;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(final int amount) throws Throwable {
        teller.withdrawFrom(account, amount);
    }
}
