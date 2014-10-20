package com.refactify.nicebank;

import com.refactify.nicebank.transforms.MoneyConverter;
import com.refactify.support.KnowsTheAccount;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountSteps {
    private KnowsTheAccount accountHelper;

    public AccountSteps(final KnowsTheAccount accountHelper) {
        this.accountHelper = accountHelper;
    }

    @Given("^I have credited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) final Money amount) throws Throwable {
        accountHelper.getMyAccount().credit(amount);
    }

    @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) final Money amount) throws Throwable {
        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;
        boolean assertionNotPassedYet = true;
        while(assertionNotPassedYet) {
            try {
                assertThat(accountHelper.getMyAccount().getBalance(), is(amount));
                assertionNotPassedYet = false;
            }
            catch(AssertionError ae) {
                try {
                    Thread.sleep(pollIntervalMilliSecs);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
                timeoutMilliSecs -= pollIntervalMilliSecs;
                if (timeoutMilliSecs <= 0) {
                    throw ae;
                }
            }
        }
    }
}
