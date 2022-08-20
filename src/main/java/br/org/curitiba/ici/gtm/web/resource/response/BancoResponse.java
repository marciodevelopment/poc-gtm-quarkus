package br.org.curitiba.ici.gtm.web.resource.response;

import br.org.curitiba.ici.gtm.entity.BancoEntity;
import lombok.Getter;

@Getter
public class BancoResponse {
	private Integer codBanco;
	private String nomeBanco;
	
	public BancoResponse(BancoEntity banco) {
		this.codBanco = banco.getCodBanco();
		this.nomeBanco = banco.getNomeBanco();
	}
}
