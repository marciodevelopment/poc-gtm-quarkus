package br.org.curitiba.ici.gtm.web.resource.response;

import br.org.curitiba.ici.gtm.entity.AgenciaEntity;
import lombok.Getter;

@Getter
public class AgenciaResponse {
	private Integer codPessoa;
	private Integer codBanco;
	private Integer codAgencia;
	private String situacaoAgenciaRetorno;
	private Boolean agenciaCentralizadora;
	private String nomeBanco;
	private String nomePessoa;

	public AgenciaResponse(AgenciaEntity agencia) {
		this.codPessoa = agencia.getPessoa().getCodPessoa();
		this.codBanco = agencia.getBanco().getCodBanco();
		this.nomeBanco = agencia.getBanco().getNomeBanco();
		this.nomePessoa =  agencia.getPessoa().getNomePessoa();
		this.codAgencia = agencia.getCodAgencia();
		this.situacaoAgenciaRetorno = agencia.getSituacaoAgenciaRetorno();
		this.agenciaCentralizadora = agencia.getAgenciaCentralizadora();
	}
	
}
