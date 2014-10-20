package com.refactify.nicebank;

import com.refactify.support.KnowsTheCashSlot;
import cucumber.api.java.en.And;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CashSlotSteps {
    private KnowsTheCashSlot cashSlotHelper;

    public CashSlotSteps(final KnowsTheCashSlot cashSlotHelper) {
        this.cashSlotHelper = cashSlotHelper;
    }

    @And("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(final int dollars) throws Throwable {
        assertThat(cashSlotHelper.getCashSlot().contents(), is(dollars));
    }
}
