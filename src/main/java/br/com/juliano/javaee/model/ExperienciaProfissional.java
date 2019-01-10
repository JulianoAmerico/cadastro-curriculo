package br.com.juliano.javaee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Juliano
 *
 */
@Entity
public class ExperienciaProfissional implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false, length = 50)
	private String empresa;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, length = 10)
	private Date inicio;

	@Temporal(TemporalType.DATE)
	@Column(nullable = true, length = 10)
	private Date termino;

	@Column(columnDefinition = "null default false")
	private Boolean ateMomento;

	@Column(nullable = false, length = 50)
	private String cargo;

	@Column(nullable = false, length = 50)
	private String areaAtuacao;

	@Column(nullable = false, length = 300)
	private String descricaoExperiencia;

	@ManyToOne
	@JoinColumn(name = "candidato_id")
	private Candidato candidato;

	public ExperienciaProfissional() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return this.termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public Boolean getAteMomento() {
		return ateMomento;
	}

	public void setAteMomento(Boolean ateMomento) {
		this.ateMomento = ateMomento;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getAreaAtuacao() {
		return this.areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getDescricaoExperiencia() {
		return this.descricaoExperiencia;
	}

	public void setDescricaoExperiencia(String descricaoExperiencia) {
		this.descricaoExperiencia = descricaoExperiencia;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

}
