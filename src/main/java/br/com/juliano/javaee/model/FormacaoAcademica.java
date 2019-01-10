package br.com.juliano.javaee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "formacaoAcademica")

public class FormacaoAcademica extends Cursos implements Serializable {

	private enum NivelFormacao {
		ENSINO_MEDIO_COMPLETO,
		ENSINO_MEDIO_INCOMPLETO, 
		SUPERIOR_COMPLETO, 
		SUPERIOR_INCOMPLETO, 
		POS_GRADUACAO, 
		MESTRADO,
		DOUTORADO, 
		POS_DOUTORADO;
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private NivelFormacao nivelFormacao;

	public FormacaoAcademica() {
	}

	public NivelFormacao getNivelFormacao() {
		return this.nivelFormacao;
	}

	public void setNivelFormacao(NivelFormacao nivelFormacao) {
		this.nivelFormacao = nivelFormacao;
	}

}
