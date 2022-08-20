package br.org.curitiba.ici.gtm.respository;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class BancoRepositoryIntegrationTest {
	@Inject
	BancoRepository repository;
	
	@Test
	void notExistsDeveRetornarTrueParaBancoNaoExistente() {
		Assertions.assertTrue(this.repository.notExistsById(-1));
	}
	
	@Test
	void notExistsDeveRetornarFalseParaBancoExistente() {
		Assertions.assertFalse(this.repository.notExistsById(1));
	}

}
