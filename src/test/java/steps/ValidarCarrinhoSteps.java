package steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.model.ShoestockModel;
import runner.TestRule;
import utils.ReporterUtils;

public class ValidarCarrinhoSteps {

	private static ShoestockModel shoes = new ShoestockModel(TestRule.getDriver());

	@When("Clico no primeiro item buscado")
	public void clico_no_primeiro_item_buscado() throws Exception {
		shoes.firstChosenItem();
	}
	
	@When("Seleciono o (.*) do tênis")
	public void seleciono_o_tamanho_do_tenis(String size) throws Exception {
		shoes.tennisSize(size);
	}
	
	@When("Clico no botão comprar")
	public void clico_no_botao_comprar() throws Exception {
		shoes.btnComprar();
	}
	
	@Then("Devo visualizar os itens no carrinho")
	public void devo_visualizar_os_itens_no_carrinho() throws Exception {
		Assert.assertEquals(true, shoes.txtMeuCarrinho());
		ReporterUtils.logPrint("Itens no carrinho");
	}
}