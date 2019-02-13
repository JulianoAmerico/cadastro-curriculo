package br.com.juliano.javaee.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.juliano.javaee.ejb.CandidatoBean;
import br.com.juliano.javaee.ejb.CursosComplementaresBean;
import br.com.juliano.javaee.ejb.ExperienciaProfissionalBean;
import br.com.juliano.javaee.ejb.FormacaoAcademicaBean;
import br.com.juliano.javaee.ejb.IdiomaBean;
import br.com.juliano.javaee.model.Candidato;

@Named("pesquisa")
@ConversationScoped
public class PesquisaBean implements Serializable {

	private LocalDate consulta;
	private List<Candidato> candidatosFiltrados;
	private ListDataModel<Candidato> candidatosModel;
	private Candidato candidatoSelecionado;
	private Boolean mostraDadosPessoais = true;
	private Boolean mostraDadosProfissionais;
	private Boolean mostraFormacaoAcademica;

	@EJB
	private CandidatoBean candidatoBean;

	@EJB
	private ExperienciaProfissionalBean expProfissionalBean;

	@EJB
	private FormacaoAcademicaBean formacaoAcademicaBean;

	@EJB
	private CursosComplementaresBean cursosComplementaresBean;

	@EJB
	private IdiomaBean idiomaBean;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void init() {
	    conversation.begin();
	}

	/**
	 * Recupera do banco de dados os candidatos cadastrados na data determinada pelo usu�rio.
	 * @return null retorna a pr�pria p�gina e � atualizada.
	 */
	public String processarPesquisa() {
	    candidatosFiltrados = candidatoBean.consultarPorData(consulta);
	    candidatosModel = new ListDataModel<>(candidatosFiltrados);
	    consulta = null;
	    return null;
	}

	public String novoCadastro() {
	    conversation.end();
	    return "curriculo_etapa_1?faces-redirect=true";
	}

	/**
	 * Mostra mais informa��es do candidado filtrado.
	 * @param candidato escolhido pelo usu�rio
	 * @return retorna a p�gina com as informa��es do candidato
	 */
	public String mostrarMais(Candidato candidato) {
	    candidatoSelecionado = candidato;

	    //Carrega as outras informa��es do candidato no relacionamento LAZY.
	    candidatoSelecionado.setExpProfissional(expProfissionalBean.listar(candidatoSelecionado.getId()));
	    candidatoSelecionado.setFormacaoAcademica(formacaoAcademicaBean.listar(candidatoSelecionado.getId()));
	    candidatoSelecionado.setCursosComplementares(cursosComplementaresBean.listar(candidatoSelecionado.getId()));
	    candidatoSelecionado.setIdiomas(idiomaBean.listar(candidatoSelecionado.getId()));
	    return "detalhesCurriculo?faces-redirect=true";
	}

	/**
	 * Mostra os dados pessoais do candidato.
	 * @param event do tipo ajax.
	 */
	public void mostrarDadosPessoais(AjaxBehaviorEvent event) {
	    mostraDadosPessoais = true;
	    mostraDadosProfissionais = false;
	    mostraFormacaoAcademica = false;
	}

	/**
	 * Mostra os dados profissionais do candidato.
	 * @param event evento do tipo ajax.
	 */
	public void mostrarDadosProfissionais(AjaxBehaviorEvent event) {
	    mostraDadosPessoais = false;
        mostraDadosProfissionais = true;
        mostraFormacaoAcademica = false;
	}

	/**
	 * Mostra a forma��o acad�mica e cursos do candidato.
	 * @param event evento do tipo ajax.
	 */
	public void mostrarFormacaoAcademica(AjaxBehaviorEvent event) {
	    mostraDadosPessoais = false;
        mostraDadosProfissionais = false;
        mostraFormacaoAcademica = true;
	}

	//Getters e Setters

	public LocalDate getConsulta() {
		return consulta;
	}

	public void setConsulta(LocalDate consulta) {
		this.consulta = consulta;
	}

	public List<Candidato> getCandidatosFiltrados() {
        return candidatosFiltrados;
    }

	public void setCandidatosFiltrados(List<Candidato> candidatosFiltrados) {
        this.candidatosFiltrados = candidatosFiltrados;
    }

	public Candidato getCandidatoSelecionado() {
        return candidatoSelecionado;
    }

	public void setCandidatoSelecionado(Candidato candidatoSelecionado) {
        this.candidatoSelecionado = candidatoSelecionado;
    }


	public ListDataModel<Candidato> getCandidatosModel() {
        return candidatosModel;
    }

	public void setCandidatosModel(ListDataModel<Candidato> candidatosModel) {
        this.candidatosModel = candidatosModel;
    }

    public Boolean getMostraDadosPessoais() {
        return mostraDadosPessoais;
    }

    public void setMostraDadosPessoais(Boolean mostraDadosPessoais) {
        this.mostraDadosPessoais = mostraDadosPessoais;
    }

    public Boolean getMostraDadosProfissionais() {
        return mostraDadosProfissionais;
    }

    public void setMostraDadosProfissionais(Boolean mostraDadosProfissionais) {
        this.mostraDadosProfissionais = mostraDadosProfissionais;
    }

    public Boolean getMostraFormacaoAcademica() {
        return mostraFormacaoAcademica;
    }

    public void setMostraFormacaoAcademica(Boolean mostraFormacaoAcademica) {
        this.mostraFormacaoAcademica = mostraFormacaoAcademica;
    }


}
