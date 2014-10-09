package com.refactify.nicebank.transforms;

import com.refactify.support.KnowsTheDomain;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.*;

public class WebDriverHooks {
    private KnowsTheDomain helper;

    public WebDriverHooks(final KnowsTheDomain helper) {
        this.helper = helper;
    }

    @After
    public void finish(final Scenario scenario) {
        try {
            byte[] screenshot = helper.getWebDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        catch (final WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        finally {
            helper.getWebDriver().close();
        }
    }
}
