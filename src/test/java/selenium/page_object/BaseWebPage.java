package selenium.page_object;

import org.openqa.selenium.WebDriver;

import selenium.command.CommandType;
import selenium.search_elements.SearchElementType;

public abstract class BaseWebPage extends Page {

	/*
	 * protected WebDriver webDriver; protected CommandAction command; protected
	 * SearchElement searchElement; protected WebDriverWait webDriverWait;
	 */

	/**
	 * Default options to Page Objects
	 * 
	 * @param webDriver
	 * @param command
	 * @param searchElement
	 */
	public BaseWebPage(WebDriver webDriver) {
		super(webDriver, CommandType.WEB.getCommand(webDriver), SearchElementType.WEB.getSearchElement(webDriver));
	}

	/**
	 * @return true if the current UI state is that which is represented by this
	 *         page object. false otherwise
	 */
	public abstract boolean isDisplayed();
}