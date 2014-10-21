package com.refactify.support;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class MyWebDriver extends EventFiringWebDriver {
    public MyWebDriver() {
        super(new FirefoxDriver());
    }
}
