package steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.model.ShoestockModel;
import runner.TestRule;
import utils.ReporterUtils;

public class ValidarTelaPagamentoSteps {

private static ShoestockModel shoes = new ShoestockModel(TestRule.getDriver());
	
	@When("Clico no botão continuar")
	public void clico_no_botao_continuar() throws Exception {
		shoes.btnContinuar();
	}
	
	@Then("Devo visualizar a tela de pagamento com o itens adicionados")
	public void devo_visualizar_a_tela_de_pagamento_com_o_itens_adicionados() throws Exception{
		Assert.assertEquals(true, shoes.txtPayment());
		ReporterUtils.logPrint("Tela de pagamento");
	}
}