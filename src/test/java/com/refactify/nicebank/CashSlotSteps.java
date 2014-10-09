package com.refactify.nicebank;

import com.refactify.support.KnowsTheDomain;
import cucumber.api.java.en.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CashSlotSteps {
    private KnowsTheDomain helper;

    public CashSlotSteps(final KnowsTheDomain helper) {
        this.helper = helper;
    }

    @And("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(final int dollars) throws Throwable {
        assertThat(helper.getCashSlot().contents(), is(dollars));
    }
}
