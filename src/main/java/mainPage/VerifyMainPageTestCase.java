package mainPage;
import static testHelper.TestConstanst.BLOCKET_URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import testHelper.CommonSetup;


public class VerifyMainPageTestCase {
	private static WebDriver driver;
	private static final String BLOCKET_TITLE = "Blocket";
	private static final String ALL_ADS_TAB = "Alla annonser";
	private static final String JOBB_TAB = "Jobb";
	private static final String RESIDENCE_TAB = "Bostad";
	
	/**
	 * To setup the test env like web driver
	 */
	@BeforeTest
	public static void setup() {
		driver = CommonSetup.setupWebDriver(BLOCKET_URL);
	}
	
	@Test
	public static void verifyMainPage(){
		
		Assert.assertTrue(driver.getTitle().equals(BLOCKET_TITLE));
		
		WebElement alla = driver.findElement(By.linkText(ALL_ADS_TAB));
		Assert.assertTrue(alla.getText().equals(ALL_ADS_TAB),"Tab Alla annonser exists");
		
		WebElement jobb = driver.findElement(By.linkText(JOBB_TAB));
		Assert.assertTrue(jobb.getText().equals(JOBB_TAB),"Tab Jobb exists");
		
		WebElement bostad = driver.findElement(By.linkText(RESIDENCE_TAB));
		Assert.assertTrue(bostad.getText().equals(RESIDENCE_TAB),"Tab Bostad exists");
		
	}
	
	/**
	 * To release the web driver after testing
	 */
	@AfterTest
	public static void teardown() {
		driver.quit();
	}
}
