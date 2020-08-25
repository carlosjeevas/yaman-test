package selenium.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.command.CommandAction;
import selenium.search_elements.SearchElement;

public abstract class Page {

	protected WebDriver webDriver;
	protected CommandAction command;
	protected SearchElement searchElement;
	protected WebDriverWait webDriverWait;

	/**
	 * Default options to Page Objects
	 * 
	 * @param webDriver
	 * @param command
	 * @param searchElement
	 */
	public Page(WebDriver webDriver, CommandAction command, SearchElement searchElement) {
		this.webDriver = webDriver;
		this.webDriverWait = new WebDriverWait(webDriver, 30);
		this.command = command;
		this.searchElement = searchElement;
	}

	public byte[] takeScreenshot() throws Exception {
		return command.screenshot();
	}
}
