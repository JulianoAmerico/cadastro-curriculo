package br.com.juliano.javaee.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cursos_complementares")
public class CursosComplementares extends Cursos {

	public CursosComplementares() {
	}

}
