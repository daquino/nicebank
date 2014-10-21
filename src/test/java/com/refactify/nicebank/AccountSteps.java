package com.refactify.nicebank;

import com.refactify.nicebank.transforms.MoneyConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ContextConfiguration("classpath:cucumber.xml")
public class AccountSteps {
    @Autowired
    private Account account;

    @Given("^I have credited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) final Money amount) throws Throwable {
        account.credit(amount);
    }

    @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) final Money amount) throws Throwable {
        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;
        boolean assertionNotPassedYet = true;
        while (assertionNotPassedYet) {
            try {
                assertThat(account.getBalance(), is(amount));
                assertionNotPassedYet = false;
            } catch (AssertionError ae) {
                try {
                    Thread.sleep(pollIntervalMilliSecs);
                } catch (InterruptedException e) {
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
