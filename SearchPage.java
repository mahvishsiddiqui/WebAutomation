package walmart.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public static WebElement element = null;
	
	/**
	 * Returns the flight origin text box element
	 * @param driver
	 * @return
	 */
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("global-search"));
		return element;
	}
	
	public static void fillOriginTextBox(WebDriver driver, String origin) {
		element = originTextBox(driver);
		element.sendKeys(origin);
	}
	
	public static WebElement findSearchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@aria-label='Begin search']"));
		return element;
	}
	
	public static void clickSearchButton(WebDriver driver) {
		element = findSearchButton(driver);
		element.click();
	}
	public static WebElement findSearchResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"thumb-1GJ5OCB8NJM1\"]"));
		return element;
	}
	
	//verify the result produces is intended
	public static String getSearchResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='thumb-1GJ5OCB8NJM1']/a//h2"));
		return element.getText();
	}
	
	public static String verifySearchResult(WebDriver driver) {
		return getSearchResult(driver);
	}
	
	public static void clickSearchResult(WebDriver driver) {
		
		element = findSearchResult(driver);
		element.click();
	}
	
	
	
	//verify the result produces is intended
	public static String getItemTitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='product-desc']/h1"));
		return element.getText();
	}
	
	public static String verifyItemTitle(WebDriver driver) {
		return getSearchResult(driver);
	}
	
	//verify the result produces is intended
	public static String getImageDetails(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='product-images']//img"));
		return element.getAttribute("class");
	}
	
	public static String verifyImageDetails(WebDriver driver) {
		return getSearchResult(driver);
	}
	
	//verify the result produces is intended
		public static String getRemoveButtonState(WebDriver driver) {
			element = driver.findElement(By.xpath("//button[@id='less-btn-productQty-1GJ5OCB8NJM1']"));
			return element.getAttribute("disabled");
		}
		
		public static String verifyRemoveNone(WebDriver driver) {
			return getRemoveButtonState(driver);
		}
		
		public static WebElement getAddButton(WebDriver driver) {
			element = driver.findElement(By.xpath("//*[@id='more-btn-productQty-1GJ5OCB8NJM1']"));
			return element;
		}
		
		public static WebElement addToCart(WebDriver driver) {
			element = driver.findElement(By.xpath("//*[@id='favourite-a2c-container']//button"));
			return element;
		}
		
		public static WebElement verifyElementInCart(WebDriver driver) {
			element = driver.findElement(By.xpath("//*[@id='ac-title']"));
			return element;
		}
		
		public static String verifyAddOne(WebDriver driver) {
			String updateText="";
			element= getAddButton(driver);
			element.click();
			element= addToCart(driver);
			element.click();
			//change frame
			driver.switchTo().activeElement();
			element= verifyElementInCart(driver);
			updateText= element.getText();
			//reset frame
			driver.switchTo().defaultContent();
			return updateText;
		}
	
	/**
	 * Returns the flight destination text box element
	 * @param driver
	 * @return
	 */
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination"));
		return element;
	}

	/**
	 * Returns the departure date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement departureDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-departing"));
		return element;
	}

	/**
	 * Returns the return date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement returnDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning"));
		return element;
	}

	/**
	 * Returns the search button box element
	 * @param driver
	 * @return
	 */
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.id("search-button"));
		return element;
	}

	/**
	 * Click on search button
	 * @param driver
	 */
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
	
	/**
	 * Navigate to flights tab
	 * @param driver
	 */
	public static void navigateToFlightsTab(WebDriver driver) {
		driver.findElement(By.id("header-history")).click();
		element = driver.findElement(By.id("tab-flight-tab"));
		element.click();
	}
}

