package br.org.curitiba.ici.gtm.service;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.org.curitiba.ici.gtm.entity.AgenciaEntity;
import br.org.curitiba.ici.gtm.entity.BancoEntity;
import br.org.curitiba.ici.gtm.entity.PessoaEntity;
import br.org.curitiba.ici.gtm.exceptions.ConstraintViolationException;
import br.org.curitiba.ici.gtm.respository.AgenciaRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;


@QuarkusTest
class AgenciaServiceTest {
	@InjectMock
	BancoService bancoService;
	@InjectMock
	AgenciaRepository agenciaRepository;
	@Inject
	AgenciaService agenciaService;
	
	AgenciaEntity agencia = new AgenciaEntity(new PessoaEntity(), 
			new BancoEntity(), 
			999, 
			true);
			
	@Test
	void persistDeveLevantarExceptionParaBancoNaoExistente() {
		Mockito.when(bancoService.notExists(agencia.getBanco())).thenReturn(true);
		assertThrows(ConstraintViolationException.class, () -> {
			agenciaService.persist(agencia);
		});
	}
	
	
	@Test
	void persistNaoDeveLevantarExceptionParaBancoExistente() {
		Mockito.when(bancoService.notExists(agencia.getBanco())).thenReturn(false);
		agenciaService.persist(agencia);
		assertTrue(true);
	}
	
	@Test
	void persistDeveLevantarExceptionSeExistirAgenciaParaPessoa() {
		Mockito.when(agenciaRepository.exists(agencia.getPessoa())).thenReturn(true);
		assertThrows(ConstraintViolationException.class, () -> {
			agenciaService.persist(agencia);
		});
	}
	
	@Test
	void persistNaoDeveLevantarExceptionSeNaoExistirAgenciaParaPessoa() {
		Mockito.when(agenciaRepository.exists(agencia.getPessoa())).thenReturn(false);
		agenciaService.persist(agencia);
		assertTrue(true);
	}
	

}
