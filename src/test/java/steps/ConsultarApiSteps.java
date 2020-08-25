package steps;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.PropertiesUtil;
import utils.RestAssuredUtil;

public class ConsultarApiSteps {

	private static String urlApi = null;
	private static Response response = null;

	@Given("Que possua a url da API")
	public void que_possua_a_url_da_api() throws Exception {
		urlApi = PropertiesUtil.getProp("url.api");
	}

	@When("Realizo uma requisição do tipo GET")
	public void realizo_uma_requisisao_do_tipo_get() throws Exception {
		response = RestAssuredUtil.getObject(urlApi);
	}

	@Then("Devo receber os dados retornados")
	public void devo_receber_os_dados_retornados() throws Exception {
		Assert.assertEquals(false, response.body().asString().isEmpty());
	}

	@Then("Exibir o conteúdo do campo name da estrutura list")
	public void exibir_o_conteudo_do_campo_name_da_estrutura_list() throws Exception {
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();

		jsonObject = (JSONObject) parser.parse(response.body().asString());
		jsonObject = (JSONObject) parser.parse(jsonObject.get("data").toString());
		jsonObject = (JSONObject) parser.parse(jsonObject.get("list").toString());
		
		System.out.println("Valor do campo 'name': " + jsonObject.get("name"));
	}

	@Then("Validar o status code retornado")
	public void validar_o_status_code_retornado() throws Exception {
		Assert.assertEquals("Status code diferente do esperado", 200, response.statusCode());
	}
}