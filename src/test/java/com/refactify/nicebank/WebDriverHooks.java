package com.refactify.nicebank;

import com.google.inject.Inject;
import com.refactify.support.MyWebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@ScenarioScoped
public class WebDriverHooks {
    private final EventFiringWebDriver webDriver;

    @Inject
    public WebDriverHooks(final MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @After
    public void finish(final Scenario scenario) {
        try {
            byte[] screenshot = webDriver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        catch (final WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        finally {
            webDriver.close();
        }
    }
}
