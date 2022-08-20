package br.org.curitiba.ici.gtm.web.resource;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import javax.transaction.Transactional;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.org.curitiba.ici.gtm.web.resource.request.AtualizacaoAgenciaRequest;
import br.org.curitiba.ici.gtm.web.resource.request.NovaAgenciaRequest;
import br.org.curitiba.ici.gtm.web.resource.response.AgenciaResponse;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@TestMethodOrder(OrderAnnotation.class)
@QuarkusTest
class AgenciaResourceIntegrationTest {
	private static final String AGENCIAS = "/agencias";
	private static Integer codPessoaCriada = 7;
	
	
	@Order(1)
	@Test
	@Transactional
	void deveSalvarUmaNovaAgencia() {
		NovaAgenciaRequest agenciRequest = new NovaAgenciaRequest(codPessoaCriada, 2, 998, "A", true);
		given()
		.contentType(ContentType.JSON)
        .body(agenciRequest)
          .when()
          .post(AGENCIAS)
          .then()
          .statusCode(Status.CREATED.getStatusCode());
    }
	

	@Test
	void naoDeveSalvarNovaAgenciaParaPessoaExistente() {
        NovaAgenciaRequest agenciRequest = new NovaAgenciaRequest(1, 2, 998, "A", true);
        given()
        .contentType(ContentType.JSON)
        .body(agenciRequest)
          .when()
          .post(AGENCIAS)
          .then()
          .statusCode(Status.BAD_REQUEST.getStatusCode());
    }
	
	
	@Test
	void deveAtualizarUmaAgencia() {
		AtualizacaoAgenciaRequest atualizacao = new AtualizacaoAgenciaRequest(1, 
				2, 
				"A", 
				false);
		 given()
		 	.contentType(ContentType.JSON)
	        .and()
	        .body(atualizacao)
	        .put(AGENCIAS + "/cod-pessoa/2")
	        .then()
	        .statusCode(Status.OK.getStatusCode());
    }
    
	
	@Test
	void naoDeveAtualizarUmaAgenciaNaoExistente() {
		AtualizacaoAgenciaRequest atualizacao = new AtualizacaoAgenciaRequest(1, 
				2, 
				"A", 
				false);
		 given()
		 	.contentType(ContentType.JSON)
	        .and()
	        .body(atualizacao)
	        .put(AGENCIAS + "/cod-pessoa/-1")
	        .then()
	        .statusCode(Status.NOT_FOUND.getStatusCode());
    }
	
	@Order(2)
	@Test
	void deveDeletarUmaAgencia() {
		given()
		.contentType(ContentType.JSON)
		.when()
        .delete(AGENCIAS + "/cod-pessoa/" + codPessoaCriada)
        .then()
        .statusCode(Status.OK.getStatusCode());
	}
	
	
	@Test
	void naoDeveDeletarUmaAgenciaInexistente() {
		given()
		.contentType(ContentType.JSON)
		.when()
        .delete(AGENCIAS + "/cod-pessoa/-1")
        .then()
        .statusCode(Status.NOT_FOUND.getStatusCode());
	}
	
	
	@Test
	void deveEncontrarUmaPessoaParaPrimeiraPaginaDeTamanho1() {
		@SuppressWarnings("unchecked")
		ArrayList<AgenciaResponse> agencias = given()
        .contentType(ContentType.JSON)
        .when()
        .queryParam("page", 0)
        .queryParam("page-size", 1)
        .get(AGENCIAS)
        .then()
        .extract().response().as(new ArrayList<>().getClass());
		Assertions.assertEquals(1, agencias.size());
	}


}
