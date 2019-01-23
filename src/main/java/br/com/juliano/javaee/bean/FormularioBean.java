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
import br.com.juliano.javaee.model.CursosComplementares;
import br.com.juliano.javaee.model.Endereco;
import br.com.juliano.javaee.model.ExperienciaProfissional;
import br.com.juliano.javaee.model.FormacaoAcademica;
import br.com.juliano.javaee.model.FormacaoAcademica.NivelFormacao;
import br.com.juliano.javaee.model.Idioma;

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
	
	private NivelFormacao[] nivelFormacaoValues = FormacaoAcademica.NivelFormacao.values();

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
	
	public String inserirExpProfissional() {
		ExperienciaProfissional exp = new  ExperienciaProfissional();
		exp.setEdicao(true);
		candidato.getExpProfissional().add(exp);
		return null;
	}
	
	public String salvarExpProfissional(ExperienciaProfissional exp) {
		exp.setEdicao(false);
		return null;
	}
	
	public String editarExpProfissional(ExperienciaProfissional exp) {
		exp.setEdicao(true);
		return null;
	}
	
	public String excluirExpProfissional(ExperienciaProfissional exp) {
		candidato.getExpProfissional().remove(exp);
		return null;
	}
	
	public String inserirFormacaoAcademica() {
		FormacaoAcademica formacaoAcademica = new FormacaoAcademica();
		formacaoAcademica.setEdicao(true);
		candidato.getFormacaoAcademica().add(formacaoAcademica);
		return null;
	}
	
	public String inserirCursoComplementar() {
		CursosComplementares cursoComplementar = new CursosComplementares();
		cursoComplementar.setEdicao(true);
		candidato.getCursosComplementares().add(cursoComplementar);
		return null;
	}
	
	public String inserirIdioma() {
		Idioma idioma = new Idioma();
		idioma.setEdicao(true);
		candidato.getIdioma().add(idioma);
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
	
	public NivelFormacao[] getNivelFormacaoValues() {
		return nivelFormacaoValues;
	}
	
	public Collection<String> getEstados() {
		return estados;
	}
}
