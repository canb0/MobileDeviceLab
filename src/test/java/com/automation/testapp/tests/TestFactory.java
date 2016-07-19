package com.automation.testapp.tests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.testapp.pages.HomePage;
import com.automation.testapp.pages.LoginPage;
import com.automation.testapp.pages.MoviePage;
import com.automation.testapp.pages.SearchPage;
import base.BaseTest;

public class TestFactory extends BaseTest{
	
	HomePage homePage = null;
	LoginPage loginPage = null;
	SearchPage searchPage = null;
	MoviePage moviePage = null;
	
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
		 moviePage.addWatchList();
	}
}
