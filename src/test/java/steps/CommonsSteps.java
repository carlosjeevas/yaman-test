package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import page_object.model.ShoestockModel;
import runner.TestRule;
import utils.PropertiesUtil;
import utils.ReporterUtils;

public class CommonsSteps {

	private static ShoestockModel shoes = new ShoestockModel(TestRule.getDriver());

	@Given("Que estou na página do Shoestock")
	public void que_estou_na_pagina_do_shoestock() throws Exception {
		Assert.assertEquals(true, shoes.isDisplayed());
	}

	@Given("Que realizei o login no sistema com o email (.*) e a senha (.*)")
	public void que_realizei_login_no_sistema(String email, String password) throws Exception {

		if (!shoes.nameUserLogged()) {
			TestRule.getDriver().navigate().to(PropertiesUtil.getProp("uri.login"));

			shoes.inputUsername(email);
			shoes.inputPassword(password);

			ReporterUtils.logPrint("Efetuando login no sistema");

			shoes.btnAcessarConta();
		}
		Assert.assertEquals(true, shoes.isDisplayed());
	}

}
