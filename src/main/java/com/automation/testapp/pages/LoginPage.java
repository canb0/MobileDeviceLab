package com.automation.testapp.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.automation.testapp.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(RemoteWebDriver driver) {
		super(driver);
	}

	public void loginWithImdbAccount() {
		clickElement(By.name("IMDb"), 0);
		List<WebElement> elements = findElements(By.className("android.widget.EditText"));
		elements.get(0).sendKeys(testappConf.getUserName());
		elements.get(1).sendKeys(testappConf.getPassword());
		if(!isElementPresent(By.name("android.widget.Button")))
			hideKeyboard();
		clickElement(By.name("Sign In "), 0);
		Assert.assertTrue(getText(By.id("com.imdb.mobile:id/text"), 0).contains(
				testappConf.getUser()));
		goHomePage();
	}
}
