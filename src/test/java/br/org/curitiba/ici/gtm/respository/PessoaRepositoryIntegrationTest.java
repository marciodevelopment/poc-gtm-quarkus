package br.org.curitiba.ici.gtm.respository;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.org.curitiba.ici.gtm.entity.PessoaEntity;
import io.quarkus.panache.common.Sort.Direction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class PessoaRepositoryIntegrationTest {
	@Inject
	PessoaRepository repository;

	@Test
	void pesquisarDeveRetonarTodosRegistros() {
		List<PessoaEntity> pessoas = repository.pesquisar("", Direction.Ascending, 0, Integer.MAX_VALUE);
		Assertions.assertEquals(11, pessoas.size());
	}
	
	@Test
	void pesquisarDeveRetonarDoisRegistrosComLetraInicialP() {
		List<PessoaEntity> pessoas = repository.pesquisar("P", Direction.Ascending, 0, Integer.MAX_VALUE);
		Assertions.assertEquals(2, pessoas.size());
	}
	
	@Test
	void pesquisarNaoDeveRetonarNenhumRegistrosComLetraInicialZ() {
		List<PessoaEntity> pessoas = repository.pesquisar("Z", Direction.Ascending, 0, Integer.MAX_VALUE);
		Assertions.assertEquals(0, pessoas.size());
	}
	
	@Test
	void notExistsDeveRetornarTrueParaPessoaNaoExistente() {
		Assertions.assertTrue(this.repository.notExistsById(-1));
	}
	
	@Test
	void notExistsDeveRetornarFalseParaPessoaExistente() {
		Assertions.assertFalse(this.repository.notExistsById(1));
	}

}
