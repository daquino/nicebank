package com.refactify.nicebank;

import com.refactify.support.TestCashSlot;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ContextConfiguration("classpath:cucumber.xml")
public class CashSlotSteps {

    @Autowired
    private CashSlot cashSlot;

    @And("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(final int dollars) throws Throwable {
        assertThat(cashSlot.contents(), is(dollars));
    }
}
