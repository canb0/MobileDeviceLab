package com.automation.testapp.tests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.testapp.pages.HomePage;
import com.automation.testapp.pages.LoginPage;
import com.automation.testapp.pages.MoviePage;
import com.automation.testapp.pages.SearchPage;
import com.automation.testapp.pages.WatchListPage;

import base.BaseTest;

public class TestFactory extends BaseTest{
	
	HomePage homePage = null;
	LoginPage loginPage = null;
	SearchPage searchPage = null;
	MoviePage moviePage = null;
	WatchListPage watchListPage = null;
	
	@BeforeTest
	public void setClass(){
		homePage = HomePage.GetInstance(driver);
		loginPage = homePage.openLoginPage();
		loginPage.loginWithImdbAccount();
		
	}
	
	@Test
	public void addToWatchList(){
		 searchPage = homePage.searchMovie();
		 moviePage  = searchPage.selectAMovie();
		 watchListPage = moviePage.addWatchList();
		 watchListPage.check_if_movieIsValid_And_CleanData();
	}
}
