package residence;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testHelper.SearchHelper;
import testHelper.SearchResultHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import static testHelper.TestConstanst.*;

/**
 * Test Case to verify the bostad page in blocket.se
 * 
 * @author esaihee
 *
 */
public class FindResidencesTestCase {
	private static WebDriver driver;

	/**
	 * To setup the test env like web driver
	 */
	@BeforeTest
	public static void setup() {
		driver = testHelper.CommonSetup.setupWebDriver(BLOCKET_BOSTAD_URL);
	}

	/**
	 * To verify whether a location and residence type could be find in an known
	 * area
	 * 
	 * @param location
	 *            area of the residence like Kungsholmen
	 * @param type
	 *            swedish words like lägenhet to descripte the type of residence
	 */
	@Test
	@Parameters({ "location", "type" })
	public static void findResidences(String location, String type) {

		SearchHelper.searchResidenceHelper(driver, location, type);

		if (SearchResultHelper.verifySearchResultSimple(driver)) {
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
