package base.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import walmart.classes.SearchPage;

public class PageObjectModel {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		//System.setProperty("webdriver.gecko.driver", "/Users/adminaccount/Documents/workspace/Selenium/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/Users/adminaccount/Documents/workspace/Selenium/chromedriver");
		driver = new ChromeDriver();
		baseUrl = "https://www.walmart.ca/";
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//verify the search result
	@Test
	public void test1() {
		String title="";
		driver.get(baseUrl);
		SearchPage.fillOriginTextBox(driver, "PRD1GJ5OCB8NJM1");
		SearchPage.clickSearchButton(driver);
		title = SearchPage.verifySearchResult(driver);
		assertEquals("Intex 28131EH 12 ft. x 30 in. Easy Set Pool", title);
		
	}
	
	//verify item page
	@Test
	public void test2() {
		String title="";
		driver.get(baseUrl);
		SearchPage.fillOriginTextBox(driver, "PRD1GJ5OCB8NJM1");
		SearchPage.clickSearchButton(driver);
		SearchPage.clickSearchResult(driver);
		title = SearchPage.verifyItemTitle(driver);
		assertEquals("Intex 28131EH 12 ft. x 30 in. Easy Set Pool", title);
	}
	
	//verify image exist
	@Test
	public void test3() {
		String title="";
		driver.get(baseUrl);
		SearchPage.fillOriginTextBox(driver, "PRD1GJ5OCB8NJM1");
		SearchPage.clickSearchButton(driver);
		SearchPage.clickSearchResult(driver);
		title = SearchPage.getImageDetails(driver);
		assertEquals("image", title);
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
