package br.com.juliano.javaee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="idioma")
public class Idioma implements Serializable {

	public enum Idiomas {
		INGLES("Ingl�s"),
		ALEMAO("Alem�o"),
		PORTUGUES("Portugu�s"),
		JAPONES("Japon�s"),
		FRANCES("Franc�s");

		private String label;

		Idiomas(String label){
			this.label = label;
		}

		public String getLabel() {
			return label;
		}

	}

	public enum Niveis {
		BASICO("B�sico"),
		INTERMEDIARIO("Intermedi�rio"),
		AVANCADO("Avan�ado"),
		FLUENTE("Fluente");

		private String label;

		Niveis(String label){
			this.label = label;
		}

		public String getLabel() {
			return label;
		}
	}

	@Id
	@GeneratedValue
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "idioma", nullable = true)
	private Idiomas idioma;

	@Enumerated(EnumType.STRING)
	@Column(name = "nivel", nullable = true)
	private Niveis nivel;

	@ManyToOne
	@JoinColumn(name = "candidato_id")
	private Candidato candidato;

	@Transient
	private boolean edicao;

	public Idioma() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Idiomas getIdioma() {
		return this.idioma;
	}

	public void setIdioma(Idiomas nome) {
		this.idioma = nome;
	}

	public Niveis getNivel() {
		return this.nivel;
	}

	public void setNivel(Niveis nivel) {
		this.nivel = nivel;
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
