package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.model.ShoestockModel;
import runner.TestRule;
import utils.ReporterUtils;

public class RealizarConsultaSteps {

	private static ShoestockModel shoes = new ShoestockModel(TestRule.getDriver());

	@When("Preencho o campo de busca com o (.*) desejado")
	public void preencho_o_campo_de_busca_com_o_produto_desejado(String item) throws Exception {
		 shoes.inputSearch(item);
	}

	@When("Clico no botão de busca")
	public void clico_no_botao_de_busca() throws Exception {
		shoes.btnSearch();
	}

	@Then("Devo visualizar os itens buscados")
	public void devo_visualizar_os_itens_buscados() throws Exception {
		ReporterUtils.logPrint("Itens buscados");
	}
}