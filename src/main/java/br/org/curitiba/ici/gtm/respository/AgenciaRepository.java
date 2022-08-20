package br.org.curitiba.ici.gtm.respository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.org.curitiba.ici.gtm.entity.AgenciaEntity;
import br.org.curitiba.ici.gtm.entity.PessoaEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Direction;

@ApplicationScoped
public class AgenciaRepository implements PanacheRepositoryBase<AgenciaEntity, Integer> {
	
	public List<AgenciaEntity> pesquisar(String nomePessoa, 
			Direction diretionOrderBy, 
			int pageIndex, int pageSize) {
		String query =
						  " select a "
						+ " from AgenciaEntity a "
						+ " join fetch a.pessoa  "
						+ " join fetch a.banco   "
						+ " where a.pessoa.nomePessoa like ?1 ";
		
		return
			find(query, Sort.by("a.pessoa.nomePessoa", diretionOrderBy), nomePessoa + "%")
			.page(pageIndex, pageSize)
			.list();
	}

	public boolean existsByIdPessoa(Integer codPessoa) {

		String countQuery = " select count(*) "
				+ " from AgenciaEntity a "
				+ " where a.pessoa.codPessoa = :codPessoa ";
		Long qtdeBanco = (Long) this
		.getEntityManager()
		.createQuery(countQuery)
		.setParameter("codPessoa", codPessoa)
		.setMaxResults(1)
		.getSingleResult();
		return qtdeBanco.intValue() > 0;
	}
	
	public boolean exists(PessoaEntity pessoa) {
		return this.existsByIdPessoa(pessoa.getCodPessoa());
	}
	
	
}
