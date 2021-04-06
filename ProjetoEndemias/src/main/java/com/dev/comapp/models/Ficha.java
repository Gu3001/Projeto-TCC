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
@Table(name="ficha")
public class Ficha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(nullable = false, length = 50)
//	@NotEmpty(message = "O nome da cidade é obrigatório")
	private Integer codigo;
	//private String nome;
	private String categoria;
	private String zona;
	private String tipo;
	private String atividade;
	private String conclusao;
	private Date dataAtividade = new Date();
	private String cicloAno;
	
	private Boolean fichaSalva = Boolean.FALSE;
	
	@ManyToOne
	private Cidade cidade;
	@ManyToOne
	private Funcionario funcionario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getConclusao() {
		return conclusao;
	}
	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}
	public Date getDataAtividade() {
		return dataAtividade;
	}
	public void setDataAtividade(Date dataAtividade) {
		this.dataAtividade = dataAtividade;
	}
	public String getCicloAno() {
		return cicloAno;
	}
	public void setCicloAno(String cicloAno) {
		this.cicloAno = cicloAno;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Boolean getFichaSalva() {
		return fichaSalva;
	}
	public void setFichaSalva(Boolean fichaSalva) {
		this.fichaSalva = fichaSalva;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
