package br.com.juliano.javaee.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cursos_complementares")
public class CursosComplementares extends Cursos {

	@ManyToOne
	@JoinColumn(name = "candidato_id")
	private Candidato candidato;
	
	private boolean edicao;

	public CursosComplementares() {
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
