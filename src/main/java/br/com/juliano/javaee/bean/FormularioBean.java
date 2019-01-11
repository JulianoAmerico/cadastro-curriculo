package br.com.juliano.javaee.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.juliano.javaee.business.EstadosProvider;
import br.com.juliano.javaee.ejb.CandidatoBean;
import br.com.juliano.javaee.model.Candidato;
import br.com.juliano.javaee.model.Candidato.EstadoCivil;
import br.com.juliano.javaee.model.Candidato.Sexo;
import br.com.juliano.javaee.model.Endereco;

/**
 * JSF Bean que interagi com as páginas jsf de cadastro de currículo.
 * 
 * @author Juliano R. Américo
 *
 */
@Named("formulario")
@SessionScoped
public class FormularioBean implements Serializable {

	@EJB
	private CandidatoBean candidatoBean;

	private Candidato candidato = new Candidato();

	private Sexo[] sexoValues = Candidato.Sexo.values();
	
	private EstadoCivil[] estadoCivilValues = Candidato.EstadoCivil.values();

	private Collection<String> estados;

	/**
	 * Cria os objetos necessários para guardar as informações do candidato.
	 */
	public FormularioBean() {
		candidato.setEndereco(new Endereco());
		candidato.setExpProfissional(new ArrayList<>());
		candidato.setIdioma(new ArrayList<>());
		candidato.setCursosComplementares(new ArrayList<>());
		candidato.setFormacaoAcademica(new ArrayList<>());
		candidato.setSexo(Candidato.Sexo.FEMININO);
	}

	@PostConstruct
	public void init() {
		estados = EstadosProvider.getEstadosCollection();
	}

	public String processar() {
		candidatoBean.gravar(candidato);
		return null;
	}

	public CandidatoBean getCandidatoBean() {
		return candidatoBean;
	}

	public void setCandidatoBean(CandidatoBean candidatoBean) {
		this.candidatoBean = candidatoBean;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Sexo[] getSexoValues() {
		return sexoValues;
	}
	
	public EstadoCivil[] getEstadoCivilValues() {
		return estadoCivilValues;
	}

	public Collection<String> getEstados() {
		return estados;
	}

}
