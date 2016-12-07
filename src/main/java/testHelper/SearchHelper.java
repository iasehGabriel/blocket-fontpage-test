package testHelper;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Helper class for search different things
 * @author esaihee
 *
 */
public class SearchHelper {
	public static void searchAmongAllaHelper(WebDriver driver, String keyWordToSearch) {
		WebElement searchTextBox = driver.findElement(By.id("searchtext"));
		searchTextBox.sendKeys(keyWordToSearch);
		searchTextBox.submit();
	}

	public static void searchJobHelper(WebDriver driver, String position, String location) {
		List<WebElement> ttInputs = driver.findElements(By.className("tt-input"));
		ttInputs.get(0).sendKeys(position);
		ttInputs.get(1).sendKeys(location);
		WebElement searchButton = driver.findElement(By.id("searchbutton"));
		searchButton.click();
	}

	public static void searchResidenceHelper(WebDriver driver, String location, String type) {
		WebElement locationInput = driver.findElement(By.className("tt-input"));
		locationInput.sendKeys(location);

		WebElement apartmentType = driver.findElement(By.className("selected-text"));
		apartmentType.click();

		String classType = getClassFromResidenceType(type);

		WebElement apartment = driver.findElement(By.className(classType));
		apartment.click();

		WebElement searchBottun = driver.findElement(By.id("searchbutton"));
		searchBottun.click();
	}

	private static String getClassFromResidenceType(String type) {
		String className = "value-3020";
		if (type.toLowerCase().contains("läg")) {
			return "value-3020";
		} else if (type.toLowerCase().contains("vil")) {
			return "value-3100";
		} else if (type.toLowerCase().contains("rad")) {
			return "value-3120";
		} else if (type.toLowerCase().contains("tom")) {
			return "value-3060";
		} else if (type.toLowerCase().contains("går")) {
			return "value-3070";
		} else if (type.toLowerCase().contains("frit")) {
			return "value-3040";
		}
		return className;
	}
	
}
