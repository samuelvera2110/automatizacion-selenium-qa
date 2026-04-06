package com.example.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ExtentReportManager {

    private static final String REPORT_DIR  = "target/extent-reports/";
    private static final String REPORT_NAME = "Automation-Report";

    private static ExtentReports instance;

    private ExtentReportManager() {}

    public static synchronized ExtentReports getInstance() {
        if (instance == null) {
            String timestamp  = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String reportPath = REPORT_DIR + REPORT_NAME + "-" + timestamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("QA Automation Report");
            spark.config().setReportName(REPORT_NAME);
            spark.config().setTheme(Theme.DARK);
            spark.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
            spark.config().setEncoding("UTF-8");

            instance = new ExtentReports();
            instance.attachReporter(spark);
            instance.setSystemInfo("OS",          System.getProperty("os.name"));
            instance.setSystemInfo("Java",        System.getProperty("java.version"));
            instance.setSystemInfo("Tester",      "QA Automation");
            instance.setSystemInfo("Environment", "Staging");
        }
        return instance;
    }

    public static synchronized void flush() {
        if (instance != null) {
            instance.flush();
        }
    }
}
