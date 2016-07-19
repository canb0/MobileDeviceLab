package com.automation.testapp.pages;

import io.appium.java_client.android.AndroidDriver;

import java.util.List;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.automation.testapp.base.BasePage;

public class LoginPage extends BasePage {

	private static LoginPage instance;
	protected static Object lock = new Object();

	public LoginPage(RemoteWebDriver driver) {
		super(driver);
	}

	public static LoginPage GetInstance(RemoteWebDriver driver) {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new LoginPage(driver);
				}
			}
		}
		return instance;
	}

	public void loginWithImdbAccount() {
		clickElement(By.name("IMDb"), 0);
		List<WebElement> elements = findElementsByClass("android.widget.EditText");
		elements.get(0).sendKeys(testappConf.getUserName());
		elements.get(1).sendKeys(testappConf.getPassword());
		//else presenet not hidekeyboard
		if(!isElementPresent(By.name("android.widget.Button")))
			hideKeyboard();
		clickElement(By.name("Sign In "), 0);
		Assert.assertTrue(getText(By.id("com.imdb.mobile:id/text"), 0).contains(
				testappConf.getUser()));
		goHomePage();
	}
}
