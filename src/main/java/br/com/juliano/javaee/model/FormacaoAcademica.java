package br.com.juliano.javaee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "formacao_academica")
public class FormacaoAcademica extends Cursos {

	private enum NivelFormacao {
		ENSINO_MEDIO_COMPLETO("Ensino Médio Completo"), 
		ENSINO_MEDIO_INCOMPLETO("Ensino Médio Incompleto"), 
		SUPERIOR_COMPLETO("Superior Completo"), 
		SUPERIOR_INCOMPLETO("Superior Incompleto"), 
		POS_GRADUACAO("Pós-Graduação"), 
		MESTRADO("Mestrado"),
		DOUTORADO("Doutorado"), 
		POS_DOUTORADO("Pós-Doutorado");
		
		private String label;
		
		private NivelFormacao(String label) {
			this.label = label;
		}
		
		@SuppressWarnings("unused")
		public String getLabel() {
			return label;
		}
	}

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private NivelFormacao nivelFormacao;

	@ManyToOne
	@JoinColumn(name = "candidato_id")
	private Candidato candidato;
	
	private boolean edicao;

	public FormacaoAcademica() {
	}

	public NivelFormacao getNivelFormacao() {
		return this.nivelFormacao;
	}

	public void setNivelFormacao(NivelFormacao nivelFormacao) {
		this.nivelFormacao = nivelFormacao;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	public boolean isEdicao() {
		return edicao;
	}
	
	public void setEdicao(boolean edicao) {
		this.edicao = edicao;
	}

}
