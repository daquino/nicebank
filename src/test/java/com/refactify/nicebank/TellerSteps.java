package com.refactify.nicebank;

import com.refactify.support.KnowsTheDomain;
import cucumber.api.java.en.When;

public class TellerSteps {

    private KnowsTheDomain helper;

    public TellerSteps(final KnowsTheDomain helper) {
        this.helper = helper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(final int amount) throws Throwable {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), amount);
    }
}
