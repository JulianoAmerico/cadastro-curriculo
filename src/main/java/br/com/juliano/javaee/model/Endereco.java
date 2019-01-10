package br.com.juliano.javaee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {

	@Column(nullable=false, length=50)
	private String rua;
	
	@Column(nullable=false,length=9)
	private String cep;
	
	@Column(nullable=false,length=50)
	private String bairro;
	
	@Column(nullable=false,length=50)
	private String cidade;
	
	@Column(nullable=false,length=50)
	private String estado;

	public Endereco() {
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
