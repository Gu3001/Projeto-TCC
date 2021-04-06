package com.dev.comapp.models;

import java.io.Serializable;
import java.sql.Time;
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
@Table(name="enderecos")
public class Enderecos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(nullable = false, length = 50)
//	@NotEmpty(message = "O nome da ficha é obrigatório")
	private Integer numQuarteirao;
	private String segmentoAnterior;
	private String lado;
	private String endereco;
	private String numero;
	private String segmento;
	private String complemento;
	private String tipoImovel;
	private Date horaEntrada = new Date();
	private String visita;
	private String pendencia;
	private String imvTrat;
	private String imvInspecionado;
	
	@ManyToOne
	private Ficha ficha;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public String getImvInspecionado() {
		return imvInspecionado;
	}
	public void setImvInspecionado(String imvInspecionado) {
		this.imvInspecionado = imvInspecionado;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	public String getImvTrat() {
		return imvTrat;
	}
	public void setImvTrat(String imvTrat) {
		this.imvTrat = imvTrat;
	}
	public Integer getNumQuarteirao() {
		return numQuarteirao;
	}
	public void setNumQuarteirao(Integer numQuarteirao) {
		this.numQuarteirao = numQuarteirao;
	}
	public String getSegmentoAnterior() {
		return segmentoAnterior;
	}
	public void setSegmentoAnterior(String segmentoAnterior) {
		this.segmentoAnterior = segmentoAnterior;
	}
	public String getLado() {
		return lado;
	}
	public void setLado(String lado) {
		this.lado = lado;
	}
	public String getSegmento() {
		return segmento;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getTipoImovel() {
		return tipoImovel;
	}
	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}
	public Date getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public String getVisita() {
		return visita;
	}
	public void setVisita(String visita) {
		this.visita = visita;
	}
	public String getPendencia() {
		return pendencia;
	}
	public void setPendencia(String pendencia) {
		this.pendencia = pendencia;
	}
	public Ficha getFicha() {
		return ficha;
	}
	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
