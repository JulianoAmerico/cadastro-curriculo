package br.com.juliano.javaee.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="cursosComplementares")
public class CursosComplementares extends Cursos {

	public CursosComplementares() {
	}

}
