package com.example.parabank.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features  = "src/test/resources/features/parabank",
    glue      = "com.example.parabank.steps",
    plugin    = {"pretty","html:target/parabank-report.html"},
    monochrome = true
)
public class ParabankRunner extends AbstractTestNGCucumberTests {
}