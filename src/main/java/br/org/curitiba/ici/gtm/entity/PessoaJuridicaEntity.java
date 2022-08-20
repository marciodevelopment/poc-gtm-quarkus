package br.org.curitiba.ici.gtm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name = "GTMPEJPessoa_Juridica")
public class PessoaJuridicaEntity  {
	@Id
	@Column(name = "Cod_Pessoa")
	private Integer codPessoa;
}
