package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/RealizarConsulta.feature",
				 glue = "classpath:/",
				 plugin = { "pretty", "html:target/report-html", "json:target/report.json" },
				 tags = {"@automatizado"},
				 monochrome = true)
public class RealizarConsultaTest {
}