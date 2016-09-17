package com.automation.testapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.automation.testapp.base.BasePage;

public class SearchPage extends BasePage {

	private static SearchPage instance;
	protected static Object lock = new Object();

	public SearchPage(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static SearchPage GetInstance(RemoteWebDriver driver) {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new SearchPage(driver);
				}
			}
		}
		return instance;
	}

	public MoviePage selectAMovie() {

		clickElement(By.id("com.imdb.mobile:id/image"), 0);
		Assert.assertTrue(getText(By.id("com.imdb.mobile:id/title"), 0).contains(
				testappConf.getMovieName()),"Result contains the right movie name");
		return MoviePage.GetInstance(driver);
	}
}
