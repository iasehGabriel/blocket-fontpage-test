package testHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Setup Helper for before Test procedure in TestNG
 * @author esaihee
 *
 */
public class CommonSetup {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonSetup.class);
	/**
	 * To setup a chrome web driver on tested page
	 * @param url the webpage supposed to be tested
	 * @return a ChromeDriver as WebDriver
	 * @see ChromeDriver
	 */
	public static WebDriver setupWebDriver(String url){
		LOGGER.info("Starting " +testHelper.TestConstanst.BLOCKET_STOCKHOLM_URL);
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		driver.navigate().to(url);
		return driver;
	}
}
