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
@Table(name="tratametno")
public class Tratamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(nullable = false, length = 50)
//	@NotEmpty(message = "O nome da ficha é obrigatório")
	private String larv1Tipo;
	private Long larv1QtdeGramas;
	private Long larv1QtdeDepTrat;
	private String larv2Tipo;
	private Long larv2QtdeGramas;
	private Long larv2QtdeDepTrat;
	private String adultTipo;
	private Long adultQtdeCargas;
	
	@ManyToOne
	private Enderecos enderecos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLarv1Tipo() {
		return larv1Tipo;
	}

	public void setLarv1Tipo(String larv1Tipo) {
		this.larv1Tipo = larv1Tipo;
	}

	public Long getLarv1QtdeGramas() {
		return larv1QtdeGramas;
	}

	public void setLarv1QtdeGramas(Long larv1QtdeGramas) {
		this.larv1QtdeGramas = larv1QtdeGramas;
	}

	public Long getLarv1QtdeDepTrat() {
		return larv1QtdeDepTrat;
	}

	public void setLarv1QtdeDepTrat(Long larv1QtdeDepTrat) {
		this.larv1QtdeDepTrat = larv1QtdeDepTrat;
	}



	public String getLarv2Tipo() {
		return larv2Tipo;
	}

	public void setLarv2Tipo(String larv2Tipo) {
		this.larv2Tipo = larv2Tipo;
	}

	public Long getLarv2QtdeGramas() {
		return larv2QtdeGramas;
	}

	public void setLarv2QtdeGramas(Long larv2QtdeGramas) {
		this.larv2QtdeGramas = larv2QtdeGramas;
	}

	public Long getLarv2QtdeDepTrat() {
		return larv2QtdeDepTrat;
	}

	public void setLarv2QtdeDepTrat(Long larv2QtdeDepTrat) {
		this.larv2QtdeDepTrat = larv2QtdeDepTrat;
	}

	public String getAdultTipo() {
		return adultTipo;
	}

	public void setAdultTipo(String adultTipo) {
		this.adultTipo = adultTipo;
	}

	public Long getAdultQtdeCargas() {
		return adultQtdeCargas;
	}

	public void setAdultQtdeCargas(Long adultQtdeCargas) {
		this.adultQtdeCargas = adultQtdeCargas;
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
