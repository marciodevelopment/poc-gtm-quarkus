package br.org.curitiba.ici.gtm.respository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.org.curitiba.ici.gtm.entity.PessoaEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Direction;

@ApplicationScoped
public class PessoaRepository implements PanacheRepositoryBase<PessoaEntity, Integer> {
	
	public List<PessoaEntity> pesquisar(String nomePessoa, Direction diretionOrderBy, int pageIndex, int pageSize) {
		return
			find("nomePessoa like ?1", 
					Sort.by("nomePessoa", diretionOrderBy), 
					nomePessoa + "%")
			.page(pageIndex, pageSize)
			.list();
		
	}

	
	public boolean notExists(PessoaEntity pessoa) {
		return this.notExistsById(pessoa.getCodPessoa());
	}
	
	public boolean notExistsById(Integer codPessoa) {
		String countQuery = " select count(*) "
				+ " from PessoaEntity pessoa "
				+ " where pessoa.codPessoa = :codPessoa ";
		Long qtdeBanco = (Long) this
		.getEntityManager()
		.createQuery(countQuery)
		.setParameter("codPessoa", codPessoa)
		.setMaxResults(1)
		.getSingleResult();
		return qtdeBanco.intValue() == 0;
	}
}
