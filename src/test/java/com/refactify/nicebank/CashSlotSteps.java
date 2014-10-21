package com.refactify.nicebank;

import com.google.inject.Inject;
import com.refactify.support.TestCashSlot;
import cucumber.api.java.en.And;
import cucumber.runtime.java.guice.ScenarioScoped;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ScenarioScoped
public class CashSlotSteps {
    private CashSlot cashSlot;

    @Inject
    public CashSlotSteps(final TestCashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @And("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(final int dollars) throws Throwable {
        assertThat(cashSlot.contents(), is(dollars));
    }
}
