package com.example.opencart.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/opencart",  
    glue = "com.example.opencart.steps",
    plugin = {"pretty", "html:target/opencart-report.html"},
    monochrome = true
)
public class OpencartRunner extends AbstractTestNGCucumberTests {
}