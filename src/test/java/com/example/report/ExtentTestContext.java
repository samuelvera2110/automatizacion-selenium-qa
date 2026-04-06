package com.example.report;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestContext {

    private static final ThreadLocal<ExtentTest> currentTest = new ThreadLocal<>();

    private ExtentTestContext() {}

    public static void set(ExtentTest test) {
        currentTest.set(test);
    }

    public static ExtentTest get() {
        return currentTest.get();
    }

    public static void remove() {
        currentTest.remove();
    }
}