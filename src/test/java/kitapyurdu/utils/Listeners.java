package kitapyurdu.utils;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static kitapyurdu.utils.Driver.closeApp;
import static kitapyurdu.utils.Driver.driver;
import static kitapyurdu.utils.ExtentReport.*;

public class Listeners implements ITestListener{

    @Override
    public void onStart(ITestContext context) {
        createReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Successfully Completed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //Failed message
        test.fail(result.getThrowable().getMessage());

        //Screenshot
        File file = driver.getScreenshotAs(OutputType.FILE);
        String filePath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + result.getMethod().getMethodName() + ".png";
        try {
            FileUtils.copyFile(file,new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Add screenshot to report
        try {
            test.addScreenCaptureFromPath(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        closeApp();
    }

    @Override
    public void onFinish(ITestContext context) {
        saveReport();
    }



}
