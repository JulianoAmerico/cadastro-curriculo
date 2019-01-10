package br.com.juliano.javaee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "idioma")
public class Idioma implements Serializable {

	private enum Idiomas {
		INGLES, ALEMAO, PORTUGUES, JAPONES, FRANCES;

	}

	private enum Niveis {
		BASICO, INTERMEDIARIO, AVANCADO;
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

}
