package selenium.platform;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public interface Platform {
	public WebDriver getLocalWebDriver();

	public WebDriver getRemoteWebDriver(String host) throws MalformedURLException;

	public WebDriver getRemoteWebDriver(String host, int port) throws MalformedURLException;

	public void cleanUpResources();
}