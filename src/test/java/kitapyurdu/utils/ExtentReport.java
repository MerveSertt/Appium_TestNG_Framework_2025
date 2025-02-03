package kitapyurdu.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReport {
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void createReport(){
        String path = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Kitap Yurdu App Report");
        reporter.config().setDocumentTitle("Kitap Yurdu Report");


        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Merve");
    }

    public static void createTest(String testAdi){
        test = extent.createTest(testAdi);
    }

    public static void informationNotes(String message){
        test.info(message);
    }

    public static void saveReport(){
        extent.flush();
    }


}
