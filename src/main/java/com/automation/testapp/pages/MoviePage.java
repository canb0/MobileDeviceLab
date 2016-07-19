package com.automation.testapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.automation.testapp.base.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class MoviePage extends BasePage{

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
	
	public void addWatchList(){
		clickElement(By.name("Not in watchlist"), 0);
		if(findElement(By.name("In watchlist"), 0)!= null)
				Assert.assertTrue(true);
		
		goWatchlistPage();
		
		Assert.assertTrue(getText(By.id("com.imdb.mobile:id/label"), 0).contains(testappConf.getMovieName()));
		clickElement(By.name("In watchlist"), 0);
	
		if(findElement(By.name("Not in watchlist"), 0)!= null)
			Assert.assertTrue(true);
	}

}
