package listeners;

import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;


public class TestAppTestListener extends BaseTest implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("Test onFinish");
	}

	public void onStart(ITestContext arg0) {
		System.out.println("Test onStart");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("Test onTestFailedButWithinSuccessPercentage");
	}
	

	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test onFailure");
		driver.getScreenshotAs(OutputType.BASE64);
//		driver.resetApp();
		openApp();
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test onTestSkipped");
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("Test onTestStart");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test onTestSuccess");
		driver.getScreenshotAs(OutputType.BASE64);
	}
}
