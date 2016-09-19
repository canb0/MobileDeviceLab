package com.automation.testapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.automation.testapp.base.BasePage;

public class MoviePage extends BasePage {

	public MoviePage(RemoteWebDriver driver) {
		super(driver);
	}

	public WatchListPage addWatchList() {
		clickElement(By.name("Not in watchlist"), 0);
		if (findElement(By.name("In watchlist"), 0) != null)
			Assert.assertTrue(true, "Element is added to watch list");
		else
			Assert.assertTrue(false,"Element is added to watch list");
		return new WatchListPage(driver);
		
	}

}
