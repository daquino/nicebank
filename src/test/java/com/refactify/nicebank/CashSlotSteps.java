package com.refactify.nicebank;

import cucumber.api.java.en.And;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CashSlotSteps {
    private CashSlot cashSlot;

    public CashSlotSteps(final CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @And("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(final int dollars) throws Throwable {
        assertThat(cashSlot.contents(), is(dollars));
    }
}
