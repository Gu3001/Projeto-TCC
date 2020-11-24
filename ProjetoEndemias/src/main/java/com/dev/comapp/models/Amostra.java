package com.dev.comapp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="amostra")
public class Amostra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(nullable = false, length = 50)
//	@NotEmpty(message = "O nome da ficha é obrigatório")
	private Integer qtdTubitos;
	private Integer numAmostraInicial;
	private Integer numAmostraFinal;

	
	@ManyToOne
	private Enderecos enderecos;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQtdTubitos() {
		return qtdTubitos;
	}
	public void setQtdTubitos(Integer qtdTubitos) {
		this.qtdTubitos = qtdTubitos;
	}
	public Integer getNumAmostraInicial() {
		return numAmostraInicial;
	}
	public void setNumAmostraInicial(Integer numAmostraInicial) {
		this.numAmostraInicial = numAmostraInicial;
	}
	public Integer getNumAmostraFinal() {
		return numAmostraFinal;
	}
	public void setNumAmostraFinal(Integer numAmostraFinal) {
		this.numAmostraFinal = numAmostraFinal;
	}
	public Enderecos getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(Enderecos enderecos) {
		this.enderecos = enderecos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

}
