package listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListeners implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("*****Test Started : "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("*****Test passed : "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("*****Test failed : "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("*****Test Skipped : "+result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("*****Test Suite Started*****");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        System.out.println("*****Test Suite Finished*****");

    }
}
