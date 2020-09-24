package com.test1;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        log("The test is fail!");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log("The test Skipped");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        log("The test is success!");
    }

    private void log(String string) {
        System.out.println(string);

    }
}
