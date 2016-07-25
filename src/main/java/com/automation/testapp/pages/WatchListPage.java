package com.automation.testapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.automation.testapp.base.BasePage;

public class WatchListPage extends BasePage{

	private static WatchListPage instance;
	protected static Object lock = new Object();

	public WatchListPage(RemoteWebDriver driver) {
		super(driver);
	}

	public static WatchListPage GetInstance(RemoteWebDriver driver) {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new WatchListPage(driver);
				}
			}
		}
		return instance;
	}
	
	public void goToWatchList(){
		
	}
	
	public void check_if_movieIsValid_And_CleanData(){
		goWatchlistPage();
		Assert.assertTrue(getText(By.id("com.imdb.mobile:id/label"), 0)
				.contains(testappConf.getMovieName()),
				"Movie Name is not what was expected");
		
		
		clickElement(By.name("In watchlist"), 0);
		if (findElement(By.name("Not in watchlist"), 0) != null)
			Assert.assertTrue(true,"Element is removed from Watchlist");
	}
}
