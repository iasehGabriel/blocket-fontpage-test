package job;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static testHelper.TestConstanst.*;
import testHelper.CommonSetup;
import testHelper.SearchHelper;
import testHelper.SearchResultHelper;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Test Case to verify the jobb page in blocket.se
 * 
 * @author esaihee
 *
 */
public class FindJobsTestCase {

	private static WebDriver driver;

	/**
	 * To setup the test env like web driver
	 */
	@BeforeTest
	public static void setup() {
		driver = CommonSetup.setupWebDriver(BLOCKET_JOBB_URL);
	}

	/**
	 * To verify whether a known job like Test Automation in Stockholm could be
	 * searched
	 * 
	 * @param jobPosition
	 *            position of job like Test Automation
	 * @param jobLocation
	 *            location of job like Stockholm
	 */
	@Test
	@Parameters({ "jobPosition", "jobLocation" })
	public static void findJobs(String jobPosition, String jobLocation) {
		SearchHelper.searchJobHelper(driver, jobPosition, jobLocation);
		SearchResultHelper.verifySearchResultByKeyWords(driver, jobPosition, jobLocation);
	}

	/**
	 * To release the web driver after testing
	 */
	@AfterTest
	public static void teardown() {
		driver.quit();
	}
}
