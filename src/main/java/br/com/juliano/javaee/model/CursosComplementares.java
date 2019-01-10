package br.com.juliano.javaee.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cursoscomplementares")
public class CursosComplementares extends Cursos {

	public CursosComplementares() {
	}

}
