package br.com.juliano.javaee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Idioma implements Serializable {

	private enum Idiomas {
		INGLES, ALEMAO, PORTUGUES, JAPONES, FRANCES;

	}

	private enum Niveis {
		BASICO, INTERMEDIARIO, AVANCADO;
	}

	@Enumerated(EnumType.STRING)
	@Column
	private Idiomas idioma;

	@Enumerated(EnumType.STRING)
	@Column
	private Niveis nivel;

	public Idioma() {
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
