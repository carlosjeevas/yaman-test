package selenium.platform;

import org.openqa.selenium.WebDriver;

public abstract class AbstractBrowserPlatform extends AbstractPlatform {

	@Override
	public WebDriver getLocalWebDriver() {
		return null;
	}
}