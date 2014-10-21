package com.refactify.support;

import com.refactify.nicebank.Account;
import com.refactify.nicebank.ServerHooks;
import com.refactify.nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class AtmUserInterface implements Teller {

    @Autowired
    private EventFiringWebDriver webDriver;

    @Override
    public void withdrawFrom(final Account account, final int amount) {
        try {
            webDriver.get("http://localhost:" + ServerHooks.PORT);
            webDriver.findElement(By.id("amount")).sendKeys(String.valueOf(amount));
            webDriver.findElement(By.id("withdraw")).click();
        } finally {
        }

    }
}
