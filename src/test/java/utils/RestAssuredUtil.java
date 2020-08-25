package utils;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredUtil {

	public static Response getObject(String url) {
		Response response = null;
		try {
			response = RestAssured.given()
					.get(url).then().extract().response();
		} catch (Exception e) {
			Assert.fail("Falha ao acessar a API");
		}

		Assert.assertEquals("Resposta do Objeto", 200, response.getStatusCode());
		return response;
	}

}