package com.automation.testapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.automation.testapp.base.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class MoviePage extends BasePage {

	private static MoviePage instance;
	protected static Object lock = new Object();

	public MoviePage(RemoteWebDriver driver) {
		super(driver);
	}

	public static MoviePage GetInstance(RemoteWebDriver driver) {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new MoviePage(driver);
				}
			}
		}
		return instance;
	}

	public WatchListPage addWatchList() {
		clickElement(By.name("Not in watchlist"), 0);
		if (findElement(By.name("In watchlist"), 0) != null)
			Assert.assertTrue(true, "Element is added to watch list");
		else
			Assert.assertTrue(false,"Element is added to watch list");
		return WatchListPage.GetInstance(driver);
		
	}

}
