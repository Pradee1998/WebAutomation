package TestComponents;



import Testing.ExtendreportTestNg;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listners extends baseTest implements ITestListener {
    ExtentReports extent = ExtendreportTestNg.getReportObject();
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
      test=  extent.createTest(result.getMethod().getMethodName());
      extentTest.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Test pased");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        try {
            driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


        String path;
        try {
            path = takeScreenshot(driver,result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        extentTest.get().addScreenCaptureFromPath(path,result.getMethod().getMethodName());


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional to implement
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());


        extent.flush();
    }

}
