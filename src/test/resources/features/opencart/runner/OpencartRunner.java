package com.example.opencart.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/**.feature",  // donde vivirán tus features
    glue = "com.example.opencart.steps",   // donde vivirán tus steps
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true,
    language = "es"
)
public class OpencartRunner extends AbstractTestNGCucumberTests {
}