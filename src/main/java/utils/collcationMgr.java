package utils;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.TestResults;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by uzie on 1/12/17.
 */
public class collcationMgr  implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.print(">>>>>> Starting Eyes driver <<<<<<<<<");
        String applitoolsAPIKey = ConfigurationManager.getBundle().getString("applitools_key");
        if (null != applitoolsAPIKey) {
            Eyes e = new Eyes();
            e.setApiKey(applitoolsAPIKey);
            ConfigurationManager.getBundle().setProperty("Eyes", e);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.print(">>>>>> END <<<<<<<<<\n");
        String applitoolsAPIKey = ConfigurationManager.getBundle().getString("applitools_key");
        if (null != applitoolsAPIKey) {
            Eyes e = (Eyes)ConfigurationManager.getBundle().getObject("Eyes");
            TestResults close = e.close();
            // Add validator
            System.out.println(">>>>>> Applitools report URL: "+ close.getUrl());
        }
    }
}
