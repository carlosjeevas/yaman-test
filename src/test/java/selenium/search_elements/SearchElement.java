package selenium.search_elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Helper to get Objects for browser or devices
 * 
 * @author Carlos Moreira
 *
 */
public abstract class SearchElement {

	protected final static int TIME_OUT = 30;
	protected final String FOCUS_SCRIPT = " arguments[0].scrollIntoView(true); arguments[0].focus();";
	protected WebDriver webDriver;
	protected WebDriverWait webDriverWait;

	/**
	 * Constructor
	 * 
	 * @param webDriver
	 */
	public SearchElement(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.webDriverWait = new WebDriverWait(this.webDriver, TIME_OUT);
	}

	/**
	 * @param name
	 * @param friendly
	 * @return
	 * @throws Exception
	 */
	public WebElement findElementBy(By by, String reportName) throws Exception {
		try {
			waitToBeReady();
			WebElement webElement = null;
			webDriver.switchTo().defaultContent();

			List<WebElement> iframes = iFrames();

			if (iframes.size() == 0) {
				webElement = findelementDefaultContent(by, false);
			} else {
				try {
					webElement = findelementDefaultContent(by, true);
				} catch (Exception e) {
					Exception e1 = null;
					for (WebElement iframe : iframes) {

						try {
							webDriver.switchTo().defaultContent();
							webDriver.switchTo().frame(iframe);
							webElement = findelementDefaultContent(by, true);
							// webElement = webDriver.findElement(by);
							e1 = null;
							break;
						} catch (Exception e2) {
							e1 = e2;
						}
					}
					if (e1 != null) {
						throw new Exception(e1);

					}
				}

			}

			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			((JavascriptExecutor) webDriver).executeScript(FOCUS_SCRIPT, webElement);
			return webElement;
		} catch (Exception e) {
			String errMsg = String.format(" Objeto %s não localizado por %s ", reportName.trim(), by.toString());
			System.out.println(errMsg + e);
			throw new Exception(errMsg);
		}
	}

	private WebElement findelementDefaultContent(By by, boolean fast) throws Exception {
		if (!fast) {
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		return webDriver.findElement(by);

	}

	/**
	 * 
	 * @param name
	 * @param friendly
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> findElementsBy(By by, String reportName) throws Exception {
		try {
			waitToBeReady();
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			List<WebElement> webElements = null;

			webDriver.switchTo().defaultContent();
			List<WebElement> iframes = iFrames();

			if (iframes.size() == 0) {
				webElements = webDriver.findElements(by);
			} else {
				try {
					webElements = webDriver.findElements(by);
				} catch (Exception e) {

					Exception e1 = null;
					for (WebElement iframe : iframes) {

						try {
							webDriver.switchTo().defaultContent();
							webDriver.switchTo().frame(iframe);
							webElements = webDriver.findElements(by);
							e1 = null;
							break;
						} catch (Exception e2) {
							e1 = e2;
						}
					}
					if (e1 != null) {
						throw new Exception(e1);
					}
				}

			}

			return webElements;
		} catch (Exception e) {
			String errMsg = String.format("Lista de Objeto %s não localizado por %s ", reportName.trim(),
					by.toString());
			System.out.println(errMsg + e);
			throw new Exception(errMsg);
		}
	}

	private List<WebElement> iFrames() {
		return webDriver.findElements(By.xpath("//frame | //iframe"));
	}

	/**
	 * 
	 * @param name
	 * @param friendly
	 * @return
	 * @throws Exception
	 */
	public WebElement findChildElementBy(WebElement parent, By by, String reportName) throws Exception {
		try {
			waitToBeReady();
			webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, by));
			WebElement webElement = parent.findElement(by);
			System.out.println(by.toString() + " - " + parent.toString());
			return webElement;

		} catch (Exception e) {
			String errMsg = String.format(" Objeto %s não localizado por %s ", reportName.trim(), by.toString());
			System.out.println(errMsg + e);
			throw new Exception(errMsg);
		}
	}

	/**
	 * 
	 * @param name
	 * @param friendly
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> findChildElementsBy(WebElement parent, By by, String reportName) throws Exception {
		try {
			waitToBeReady();
			webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, by));
			List<WebElement> webElements = parent.findElements(by);

			return webElements;
		} catch (Exception e) {
			String errMsg = String.format("Lista de objetos %s nao localizado por %s ", reportName.trim(),
					by.toString());
			System.out.println(errMsg + e);
			throw new Exception(errMsg);
		}
	}

	/**
	 * 
	 * @param Xpath
	 * @param friendly
	 * @return
	 */
	public Boolean exists(By by, String reportName) {
		return exists(by, reportName, TIME_OUT, true);
	}

	public Boolean exists(By by, String reportName, long timeWait) {
		return exists(by, reportName, timeWait, true);
	}

	/**
	 * 
	 * @param xpath
	 * @param friendly
	 * @param timeWait
	 * @return
	 */
	private Boolean exists(By by, String reportName, long timeWait, boolean log) {

		WebDriverWait waitExists = new WebDriverWait(this.webDriver, timeWait);

		try {
			List<WebElement> iframes = iFrames();

			if (iframes.size() == 0) {
				waitExists.until(ExpectedConditions.presenceOfElementLocated(by));
			} else {
				try {
					waitExists.until(ExpectedConditions.presenceOfElementLocated(by));
				} catch (Exception e) {
					Exception e1 = null;
					for (WebElement iframe : iframes) {

						try {
							webDriver.switchTo().defaultContent();
							webDriver.switchTo().frame(iframe);
							waitExists.until(ExpectedConditions.presenceOfElementLocated(by));
							e1 = null;
							break;
						} catch (Exception e2) {
							e1 = e2;
						}
					}
					if (e1 != null) {
						throw new Exception(e1);

					}
				}

			}
			waitExists.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			if (log) {
				String errorMsg = String.format(" Objeto %s não localizado %s ", reportName.trim(), by.toString());
				System.out.println(errorMsg + e);
			}
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @throws Exception
	 */
	public abstract void waitToBeReady() throws Exception;

	public boolean existsNoLog(By by, String reportName, int timeWait) {
		return exists(by, reportName, timeWait, false);
	}
}