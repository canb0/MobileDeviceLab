package com.automation.testapp.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;

public class BasePage extends BasePageUtil {


	public BasePage(RemoteWebDriver driver) {
		super(driver);
	}

	protected void LoadHomePage() {

	}

	protected void openHamburgerMenu() {

		clickElement(By.name("Open Drawer"), 0);
	}

	protected void goHomePage() {
		clickElement(By.id("com.imdb.mobile:id/design_menu_item_text"), 0);
	}

	protected void goWatchlistPage() {
		clickElement(By.name("Open Drawer"), 0);
		clickElement(By.name("Your Watchlist"),0);
	}

	protected String GetWebDriverUrl() {
		return driver.getCurrentUrl();
	}
}
