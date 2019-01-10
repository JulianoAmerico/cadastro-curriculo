package br.com.juliano.javaee.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cursos_complementares")
public class CursosComplementares extends Cursos {

	@ManyToOne(name = "candidato_id")
	private Candidato candidato;

	public CursosComplementares() {
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
}
