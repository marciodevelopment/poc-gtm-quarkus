package br.org.curitiba.ici.gtm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "GTMAGNAgencia")
public class AgenciaEntity implements Serializable {
	

	private static final long serialVersionUID = -6056443222277334514L;

	@Id
	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Cod_Pessoa")
	@NotNull(message = "Pessoa não pode ser nulo")
	private PessoaEntity pessoa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Cod_Banco")
	private BancoEntity banco;
	
	@Column(name = "Cod_Agencia")
	private Integer codAgencia;
	
	@Setter
	@Column(name = "Ind_Sit_Agencia_Retorno_X")
	private String situacaoAgenciaRetorno;
	
	
	@Column(name = "Flg_Agencia_Centralizadora")
	private Boolean agenciaCentralizadora;
	

	protected AgenciaEntity() {}
	
	public AgenciaEntity(PessoaEntity pessoa, BancoEntity banco, Integer codAgencia, 
			Boolean agenciaCentralizadora) {
		super();
		this.pessoa = pessoa;
		this.banco = banco;
		this.codAgencia = codAgencia;
		this.agenciaCentralizadora = agenciaCentralizadora;
	}

	public AgenciaEntity atualizar(
			@NotNull BancoEntity banco, 
			@NotNull Integer codAgencia, 
			boolean agenciaCentralizadora, 
			String situacaoAgenciaRetorno) {
		this.banco = banco;
		this.codAgencia = codAgencia;
		this.agenciaCentralizadora = agenciaCentralizadora;
		this.situacaoAgenciaRetorno = situacaoAgenciaRetorno;
		return this;
	}

	
	
}
