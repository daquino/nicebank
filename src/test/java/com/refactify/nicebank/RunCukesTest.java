package com.refactify.nicebank;

import cucumber.api.*;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE, format = {"pretty", "html:out"}, features = "classpath:features")
public class RunCukesTest {
}
