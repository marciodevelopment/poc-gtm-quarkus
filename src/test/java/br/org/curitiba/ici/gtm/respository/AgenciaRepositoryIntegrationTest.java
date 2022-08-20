package br.org.curitiba.ici.gtm.respository;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.org.curitiba.ici.gtm.entity.AgenciaEntity;
import io.quarkus.panache.common.Sort.Direction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class AgenciaRepositoryIntegrationTest {
	@Inject
	AgenciaRepository respository;
	
	
	@Test
	void pesquisarDeveRetornarTodosOsRegistros() {
		List<AgenciaEntity> agencias = respository.pesquisar("", Direction.Ascending, 0, Integer.MAX_VALUE);
		Assertions.assertEquals(2, agencias.size());
	}
	
	@Test
	void pesquisarDeveRetornarApenasUmRegistroComInicioIN() {
		List<AgenciaEntity> agencias = respository.pesquisar("IN", Direction.Ascending, 0, Integer.MAX_VALUE);
		Assertions.assertEquals(1, agencias.size());
	}
	
	@Test
	void existsDeveRetornarFalseParaAgenciaDeUsuarioInexistente() {
		Assertions.assertFalse(respository.existsByIdPessoa(-1));
	}
	
	@Test
	void existsDeveRetornarTrueParaAgenciaDeUsuarioExistente() {
		Assertions.assertTrue(respository.existsByIdPessoa(1));
	}
	
	

}
