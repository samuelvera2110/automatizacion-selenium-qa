package com.example.report;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String testName  = result.getMethod().getMethodName();
        String className = result.getTestClass().getRealClass().getSimpleName();

        ExtentTest test = ExtentReportManager.getInstance()
                .createTest(className + " — " + testName)
                .assignCategory(className);

        ExtentTestContext.set(test);
        test.info("Test started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = ExtentTestContext.get();
        if (test == null) return;

        attachScreenshot(test, Status.PASS, "Screenshot on PASS");
        test.pass("Test PASSED");
        ExtentTestContext.remove();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentTestContext.get();
        if (test == null) return;

        attachScreenshot(test, Status.FAIL, "Screenshot on FAIL");
        test.fail(result.getThrowable());
        ExtentTestContext.remove();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = ExtentTestContext.get();
        if (test == null) return;

        test.skip("Test SKIPPED: " + result.getThrowable());
        ExtentTestContext.remove();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flush();
    }

    private void attachScreenshot(ExtentTest test, Status status, String title) {
        String base64 = ScreenshotUtil.captureBase64();
        if (base64 == null) {
            test.log(status, title + " (screenshot unavailable)");
            return;
        }
        try {
            test.log(status, title,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64, title).build());
        } catch (Exception e) {
            test.log(status, title + " (could not attach screenshot: " + e.getMessage() + ")");
        }
    }
}
