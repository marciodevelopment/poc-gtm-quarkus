package br.org.curitiba.ici.gtm.service;

import java.util.Collection;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import br.org.curitiba.ici.gtm.entity.PessoaEntity;
import br.org.curitiba.ici.gtm.respository.PessoaRepository;
import br.org.curitiba.ici.gtm.type.OrderDirection;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class PessoaService {
	private final PessoaRepository pessoaRepository;
	
	public PessoaEntity getReference(Integer codBanco) {
		return pessoaRepository.getEntityManager().getReference(PessoaEntity.class, codBanco);
	}

	public Collection<PessoaEntity> pesquisar(Optional<String> nomePessoa, OrderDirection direction, int page, int pageSize) {
		return this.pessoaRepository.pesquisar(nomePessoa.orElse(""), direction.toPanacheDirection(), page, pageSize);
	}
}
