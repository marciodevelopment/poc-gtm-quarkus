package br.org.curitiba.ici.gtm.respository;

import javax.enterprise.context.ApplicationScoped;

import br.org.curitiba.ici.gtm.entity.BancoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class BancoRepository implements PanacheRepositoryBase<BancoEntity, Integer> {

	public boolean notExistsById(Integer codBanco) {
		String countQuery = " select count(*) "
				+ " from BancoEntity banco "
				+ " where banco.codBanco = :codBanco ";
		Long qtdeBanco = (Long) this
		.getEntityManager()
		.createQuery(countQuery)
		.setParameter("codBanco", codBanco)
		.setMaxResults(1)
		.getSingleResult();
		return qtdeBanco.intValue() == 0;
	}
	
	public boolean notExists(BancoEntity banco) {
		return this.notExistsById(banco.getCodBanco());
	}
	

}
