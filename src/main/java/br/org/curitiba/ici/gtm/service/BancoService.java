package br.org.curitiba.ici.gtm.service;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

import br.org.curitiba.ici.gtm.entity.BancoEntity;
import br.org.curitiba.ici.gtm.respository.BancoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class BancoService {
	private final BancoRepository bancoRepository;
	
	public BancoEntity getReference(Integer codBanco) {
		return bancoRepository.getEntityManager().getReference(BancoEntity.class, codBanco);
	}

	public Collection<BancoEntity> listAll() {
		return this.bancoRepository.findAll().list();
	}

	public boolean notExists(BancoEntity banco) {
		return bancoRepository.notExists(banco);
	}

}
