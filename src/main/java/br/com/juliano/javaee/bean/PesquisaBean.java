package br.com.juliano.javaee.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import br.com.juliano.javaee.ejb.CandidatoBean;
import br.com.juliano.javaee.model.Candidato;

@Named("pesquisa")
@RequestScoped
public class PesquisaBean implements Serializable {

	private LocalDate consulta;
	private List<Candidato> candidatosFiltrados;
	private Boolean tipoFiltro = true;

	@EJB
	CandidatoBean candidatoBean;

	public String processarPesquisa() {
//	    candidatosFiltrados = candidatoBean.consultarPorData(consulta, tipoFiltro);
	    System.out.println("LocalDate: " + consulta);
	    return null;
	}

	public void atualizaFiltro(ValueChangeEvent event) {
	    tipoFiltro = (Boolean) event.getNewValue();
	}

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

	public Boolean getTipoFiltro() {
        return tipoFiltro;
    }

	public void setTipoFiltro(Boolean tipoFiltro) {
        this.tipoFiltro = tipoFiltro;
    }
}
