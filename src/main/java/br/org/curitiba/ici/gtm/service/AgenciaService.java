package br.org.curitiba.ici.gtm.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.org.curitiba.ici.gtm.entity.AgenciaEntity;
import br.org.curitiba.ici.gtm.exceptions.ConstraintViolationException;
import br.org.curitiba.ici.gtm.respository.AgenciaRepository;
import br.org.curitiba.ici.gtm.type.OrderDirection;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class AgenciaService {
	private final AgenciaRepository agenciaRepository;
	private final BancoService bancoService;
	
	
	@Transactional
	public void persist(AgenciaEntity agencia) {
		checkBancoParaPersistirAgencia(agencia);
		if (agenciaRepository.exists(agencia.getPessoa())) {
			throw new ConstraintViolationException("Agência já existente para o código de pessoa.", "agencia.pessoa.codPessoa");
		}
		agenciaRepository.persist(agencia);
	}

	public Optional<AgenciaEntity> findByIdOptional(Integer codPessoa) {
		return agenciaRepository.findByIdOptional(codPessoa);
	}

	private void checkBancoParaPersistirAgencia(AgenciaEntity agencia) {
		if (bancoService.notExists(agencia.getBanco())) {
			throw new ConstraintViolationException("Banco inexistente.", "agencia.banco.codBanco");
		}
	}
	
	@Transactional
	public void update(AgenciaEntity agencia) {
		checkBancoParaPersistirAgencia(agencia);
		agenciaRepository.getEntityManager().merge(agencia);
		
	}

	public List<AgenciaEntity> pesquisar(Optional<String> nome, OrderDirection orderDirection, int page, int pageSize) {
		return agenciaRepository.pesquisar(nome.orElse(""), orderDirection.toPanacheDirection(), page, pageSize);
	}

	@Transactional
	public boolean deleteById(Integer codPessoa) {
		return agenciaRepository.deleteById(codPessoa);
	}

}
