package br.org.curitiba.ici.gtm.web.resource;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.org.curitiba.ici.gtm.web.resource.response.PessoaResponse;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
class PessoaResourceIntegrationTest {
	private static final String PESSOAS = "/pessoas";
	
	@Test
	void deveEncontrarUmaPessoaParaPrimeiraPaginaDeTamanho1() {
		@SuppressWarnings("unchecked")
		ArrayList<PessoaResponse> pessoas = given()
        .contentType(ContentType.JSON)
        .when()
        .queryParam("page", 0)
        .queryParam("page-size", 1)
        .get(PESSOAS)
        .then()
        .extract().response().as(new ArrayList<>().getClass());
		Assertions.assertEquals(1, pessoas.size());
	}

}
