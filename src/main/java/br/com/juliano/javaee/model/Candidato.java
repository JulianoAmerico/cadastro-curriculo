package br.com.juliano.javaee.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "candidato")
public class Candidato implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@Embedded
	private Endereco endereco;

	@Column(nullable = false, length = 30)
	private String nacionalidade;

	@Column(nullable = false, length = 15)
	private String estadoCivil;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false, length = 10)
	private Date dataNascimento;

	@Column(nullable = false, length = 13)
	private String telefoneCelular;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(nullable = true, length = 100)
	private String linkedin;

	@Column(nullable = false, length = 50)
	private String objetivoProfissional;

	@Column(nullable = false)
	private Double pretensaoSalarial;

	@OneToMany(mappedBy = "candidato")
	private List<ExperienciaProfissional> expProfissional;

	@OneToMany(mappedBy = "candidato")
	private List<Idioma> idioma;

	@OneToMany(mappedBy = "candidato")
	private List<FormacaoAcademica> formacaoAcademica;

	@OneToMany(mappedBy = "candidato")
	private List<CursosComplementares> cursosComplementares;

	public Candidato() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefoneCelular() {
		return this.telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkedin() {
		return this.linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getObjetivoProfissional() {
		return this.objetivoProfissional;
	}

	public void setObjetivoProfissional(String objetivoProfissional) {
		this.objetivoProfissional = objetivoProfissional;
	}

	public Double getPretensaoSalarial() {
		return this.pretensaoSalarial;
	}

	public void setPretensaoSalarial(Double pretensaoSalarial) {
		this.pretensaoSalarial = pretensaoSalarial;
	}

	public List<ExperienciaProfissional> getExpProfissional() {
		return expProfissional;
	}

	public void setExpProfissional(List<ExperienciaProfissional> expProfissional) {
		this.expProfissional = expProfissional;
	}

	public List<Idioma> getIdioma() {
		return idioma;
	}

	public void setIdioma(List<Idioma> idioma) {
		this.idioma = idioma;
	}

	public List<FormacaoAcademica> getFormacaoAcademica() {
		return formacaoAcademica;
	}

	public void setFormacaoAcademica(List<FormacaoAcademica> formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}

	public List<CursosComplementares> getCursosComplementares() {
		return cursosComplementares;
	}

	public void setCursosComplementares(List<CursosComplementares> cursosComplementares) {
		this.cursosComplementares = cursosComplementares;
	}

}
