package com.refactify.nicebank;

import com.refactify.support.KnowsTheAccount;
import com.refactify.support.KnowsTheTeller;
import cucumber.api.java.en.When;

public class TellerSteps {
    private KnowsTheTeller tellerHelper;
    private KnowsTheAccount accountHelper;

    public TellerSteps(final KnowsTheTeller tellerHelper, final KnowsTheAccount accountHelper) {
        this.tellerHelper = tellerHelper;
        this.accountHelper = accountHelper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(final int amount) throws Throwable {
        tellerHelper.getTeller().withdrawFrom(accountHelper.getMyAccount(), amount);
    }
}
