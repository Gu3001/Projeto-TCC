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
	private Integer larv1Tipo;
	private Integer larv1QtdeGramas;
	private Integer larv1QtdeDepTrat;
	private Integer larv2Tipo;
	private Integer larv2QtdeGramas;
	private Integer larv2QtdeDepTrat;
	private Integer adultTipo;
	private Integer adultQtdeCargas;
	
	@ManyToOne
	private Enderecos enderecos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLarv1Tipo() {
		return larv1Tipo;
	}

	public void setLarv1Tipo(Integer larv1Tipo) {
		this.larv1Tipo = larv1Tipo;
	}

	public Integer getLarv1QtdeGramas() {
		return larv1QtdeGramas;
	}

	public void setLarv1QtdeGramas(Integer larv1QtdeGramas) {
		this.larv1QtdeGramas = larv1QtdeGramas;
	}

	public Integer getLarv1QtdeDepTrat() {
		return larv1QtdeDepTrat;
	}

	public void setLarv1QtdeDepTrat(Integer larv1QtdeDepTrat) {
		this.larv1QtdeDepTrat = larv1QtdeDepTrat;
	}

	public Integer getLarv2Tipo() {
		return larv2Tipo;
	}

	public void setLarv2Tipo(Integer larv2Tipo) {
		this.larv2Tipo = larv2Tipo;
	}

	public Integer getLarv2QtdeGramas() {
		return larv2QtdeGramas;
	}

	public void setLarv2QtdeGramas(Integer larv2QtdeGramas) {
		this.larv2QtdeGramas = larv2QtdeGramas;
	}

	public Integer getLarv2QtdeDepTrat() {
		return larv2QtdeDepTrat;
	}

	public void setLarv2QtdeDepTrat(Integer larv2QtdeDepTrat) {
		this.larv2QtdeDepTrat = larv2QtdeDepTrat;
	}

	public Integer getAdultTipo() {
		return adultTipo;
	}

	public void setAdultTipo(Integer adultTipo) {
		this.adultTipo = adultTipo;
	}

	public Integer getAdultQtdeCargas() {
		return adultQtdeCargas;
	}

	public void setAdultQtdeCargas(Integer adultQtdeCargas) {
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
