package selenium.search_elements;

import org.openqa.selenium.WebDriver;

public enum SearchElementType {

	WEB {
		@Override
		public SearchElement getSearchElement(WebDriver webDriver) {
			return new SearchElementForWEB(webDriver);
		}
	};

	/**
	 * Get SearchElement
	 * 
	 * @param webDriver
	 * @return
	 */
	public abstract SearchElement getSearchElement(WebDriver webDriver);

	public static SearchElement getSearchElement(SearchElementType type, WebDriver webDriver) {
		return type.getSearchElement(webDriver);
	}
}