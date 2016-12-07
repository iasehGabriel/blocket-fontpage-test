package allads;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import static testHelper.TestConstanst.*;
import testHelper.CommonSetup;
import testHelper.SearchHelper;
import testHelper.SearchResultHelper;

/**
 * Test Case to search blockset.se alla annonser page
 * 
 * @author esaihee
 *
 */
public class FindAllAdsTestCase {
	private static WebDriver driver;

	/**
	 * To setup the test env like web driver
	 */
	@BeforeTest
	public static void setup() {
		driver = CommonSetup.setupWebDriver(BLOCKET_STOCKHOLM_URL);
	}

	/**
	 * Test Case to verify whether a common key word like Bolia Sofa could be
	 * searched
	 * 
	 * @param keyWordToSearch common things to be searched like Bolia Sofa
	 * <p>
	 * A space separator shall be used
	 */
	@Test
	@Parameters({ "keyWordToSearch" })
	public static void findAllAds(String keyWordToSearch) {
		SearchHelper.searchAmongAllaHelper(driver, keyWordToSearch);

		if (SearchResultHelper.verifySearchResultByKeyWords(driver, keyWordToSearch)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Not found qualified items");
		}

	}

	/**
	 * To release the web driver after testing
	 */
	@AfterTest
	public static void teardown() {
		driver.quit();
	}

}
