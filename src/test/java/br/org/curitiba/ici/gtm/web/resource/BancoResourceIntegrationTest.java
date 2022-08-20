package br.org.curitiba.ici.gtm.web.resource;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.org.curitiba.ici.gtm.web.resource.response.BancoResponse;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
class BancoResourceIntegrationTest {
	private static final String BANCOS = "/bancos";
	
	@Test
	void getTest() {
		@SuppressWarnings("unchecked")
		ArrayList<BancoResponse> bancos = given()
		        .contentType(ContentType.JSON)
		        .when()
		        .get(BANCOS)
		        .then()
		        .extract().response().as(new ArrayList<>().getClass());
				Assertions.assertFalse(bancos.isEmpty());
	}

}
