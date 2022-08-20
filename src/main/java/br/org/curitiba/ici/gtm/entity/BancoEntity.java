package br.org.curitiba.ici.gtm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name = "GtmBanBanco")
public class BancoEntity implements Serializable {
	
	private static final long serialVersionUID = 3430394672609862148L;
	
	@Id
	@Column(name = "Cod_Banco")
	private Integer codBanco;
	@Column(name = "Nme_Banco")
	private String nomeBanco;
	
}
