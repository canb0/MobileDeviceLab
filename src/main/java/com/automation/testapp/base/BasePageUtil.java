package com.automation.testapp.base;

import java.util.List;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.testapp.configuration.TestAppConfiguration;
public class BasePageUtil {

	protected RemoteWebDriver driver;
	protected WebDriverWait wait;
	protected static TestAppConfiguration testappConf;
	protected static Wait<AndroidDriver> wait2;
	protected DesiredCapabilities capabilities;
	
	public BasePageUtil(RemoteWebDriver driver) {
		testappConf = TestAppConfiguration.GetInstance();
		this.driver = driver;
		if (wait == null) {
			this.wait = new WebDriverWait(driver, 20);
		}
	}
	
	protected void hideKeyboard(){
		driver.navigate().back();
	}

	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected WebElement findElement(By by, int index) {
		return waitForVisibility(by).get(index);
		
	}
	
	protected List<WebElement> findElements(By by) {
		return waitForVisibility(by);
		
	}

	protected List<WebElement> waitForVisibility(By by) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	protected void clickElement(By by, int index) {

		findElement(by, index).click();
	}

	protected String getText(By by, int index) {
		return waitForVisibility(by).get(index).getText();
	}

	protected void sendKey(By by, int index, String text) {

		findElement(by, index).sendKeys(text);
	}
}
