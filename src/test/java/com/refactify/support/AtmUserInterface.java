package com.refactify.support;

import com.google.inject.Inject;
import com.refactify.nicebank.*;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@ScenarioScoped
public class AtmUserInterface implements Teller {
    private final EventFiringWebDriver webDriver;

    @Inject
    public AtmUserInterface(final MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void withdrawFrom(final Account account, final int amount) {
        try {
            webDriver.get("http://localhost:" + ServerHooks.PORT);
            webDriver.findElement(By.id("amount")).sendKeys(String.valueOf(amount));
            webDriver.findElement(By.id("withdraw")).click();
        }
        finally {
        }

    }
}
