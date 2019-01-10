package br.com.juliano.javaee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Cursos implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false, length = 70)
	private String curso;

	@Column(nullable = false, length = 70)
	private String instituicao;

	@Temporal(TemporalType.DATE)
	@Column(nullable = true, length = 10)
	private Date dataConclusao;

	public Cursos() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInstituicao() {
		return this.instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Date getDataConclusao() {
		return this.dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

}
