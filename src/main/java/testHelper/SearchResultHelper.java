package testHelper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchResultHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchResultHelper.class);

	/**
	 * To verify the searched results
	 * <p>
	 * Would return true if one of the search items has text message contains
	 * all the key words
	 * 
	 * @param driver
	 *            WebDriver to use
	 * @param keyWordsToVerify
	 *            Key Words to verify the result
	 * @return true if one of the search item contains all the search key words
	 */
	public static boolean verifySearchResultByKeyWords(WebDriver driver, String... keyWordsToVerify) {
		List<WebElement> searchItems = driver.findElements(By.tagName("article"));
		LOGGER.info("Number of Searched Items: " + searchItems.size());
		for(WebElement item:searchItems){
			if(hasItemContainsAllKeyWords(item,keyWordsToVerify))
				return true;
		}
		return false;
	}
	/**
	 * To verify the searched results
	 * <p>
	 * Would return true if number of "articles" is larger than zero
	 * 
	 * @param driver WebDriver to use
	 * @return
	 */
	public static boolean verifySearchResultSimple(WebDriver driver){
		List<WebElement> searchItems = driver.findElements(By.tagName("article"));
		LOGGER.info("Number of Searched Items: " + searchItems.size());
		return searchItems.size()>0;
	}
	private static boolean hasItemContainsAllKeyWords(WebElement item, String... keyWordsToVerify){
		for(String keyWord: keyWordsToVerify){
			if(!item.getText().contains(keyWord)){
				LOGGER.debug("Item Text: "+ item.getText());
				return false;
			}
				
		}
		return true;
	}
}
