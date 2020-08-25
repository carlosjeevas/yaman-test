package runner;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.itextpdf.text.DocumentException;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import selenium.platform.ChromePlatform;
import selenium.platform.Platform;
import utils.PropertiesUtil;
import utils.ReporterUtils;

public class TestRule {
	private static WebDriver webDriver;
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@Before
	public void iniciate(Scenario cenario) {
		
		Date date = new Date();
		if (extentReport == null) {
			extentReport = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter(
					(PropertiesUtil.getProp("evidencia.html") + "Cenario_" + cenario.getName() + "_"
							+ (formatter.format(date) + ".html")).replace(" ", "_").replace(":", "-"));
			extentReport.attachReporter(htmlReporter);
		}

		extentTest = extentReport.createTest(cenario.getId());

		Platform correios = ChromePlatform.StartWebDriver();
		webDriver = correios.getLocalWebDriver();
		webDriver.navigate().to(PropertiesUtil.getProp("uri"));
	}

	@After
	public static void teardown(Scenario cenario) throws DocumentException, Exception {

		if (cenario.isFailed()) {
			extentTest.log(Status.FAIL, "Cenário: '" + cenario.getName() + "' executado com falha!");
			extentReport.flush();
		} else {
			extentTest.log(Status.PASS, "Cenário: '" + cenario.getName() + "' executado com sucesso!");
			extentReport.flush();
		}

		ReporterUtils.generateEvidencePdf(cenario);
		Thread.sleep(1000);
		webDriver.close();
		webDriver.quit();
	}

	public static WebDriver getDriver() {
		return webDriver;
	}

	public static ExtentTest getExtentTest() {
		return extentTest;
	}
}