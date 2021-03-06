package br.com.juliano.javaee.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
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
import br.com.juliano.javaee.model.Idioma.Idiomas;
import br.com.juliano.javaee.model.Idioma.Niveis;

/**
 * JSF Bean que interagi com as p�ginas jsf de cadastro de curr�culo.
 *
 * @author Juliano R. Am�rico
 *
 */
@Named("formulario")
@ConversationScoped
public class FormularioBean implements Serializable {

    @EJB
    private CandidatoBean candidatoBean;

    @Inject
    private Conversation conversation;

    private Candidato candidato = new Candidato();

    private Sexo[] sexoValues = Candidato.Sexo.values();

    private EstadoCivil[] estadoCivilValues = Candidato.EstadoCivil.values();

    private NivelFormacao[] nivelFormacaoValues = FormacaoAcademica.NivelFormacao.values();

    private Idiomas[] idiomasValues = Idioma.Idiomas.values();

    private Niveis[] niveisValues = Idioma.Niveis.values();

    private Collection<String> estados;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date minDate;
    private Date maxDate;

    /**
     * Cria os objetos necess�rios para guardar as informa��es do candidato.
     */
    public FormularioBean() {
        candidato.setEndereco(new Endereco());
        candidato.setExpProfissional(new ArrayList<>());
        candidato.setIdiomas(new ArrayList<>());
        candidato.setCursosComplementares(new ArrayList<>());
        candidato.setFormacaoAcademica(new ArrayList<>());
        candidato.setSexo(Candidato.Sexo.FEMININO);
    }

    @PostConstruct
    public void init() {
        conversation.begin();
        estados = EstadosProvider.getEstadosCollection();

        /* Limitando data de anivers�rio */
        maxDate = new Date();
    }

    public String processar() {
        String now = sdf.format(new Date());

        try {
            candidato.setDataCadastro(sdf.parse(now));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        candidatoBean.gravar(candidato, candidato.getExpProfissional(), candidato.getFormacaoAcademica(),
                candidato.getCursosComplementares(), candidato.getIdiomas());

        conversation.end();
        return "sucesso?faces-redirect=true";
    }

    public String inserirExpProfissional() {
        ExperienciaProfissional exp = new ExperienciaProfissional();
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

    public String salvarFormacaoAcademica(FormacaoAcademica fa) {
        fa.setEdicao(false);
        return null;
    }

    public String editarFormacaoAcademica(FormacaoAcademica fa) {
        fa.setEdicao(true);
        return null;
    }

    public String excluirFormacaoAcademica(FormacaoAcademica fa) {
        candidato.getFormacaoAcademica().remove(fa);
        return null;
    }

    public String inserirCursosComplementares() {
        CursosComplementares cursoComplementar = new CursosComplementares();
        cursoComplementar.setEdicao(true);
        candidato.getCursosComplementares().add(cursoComplementar);
        return null;
    }

    public String salvarCursosComplementares(CursosComplementares cursosComplementares) {
        cursosComplementares.setEdicao(false);
        return null;
    }

    public String editarCursosComplementares(CursosComplementares cursosComplementares) {
        cursosComplementares.setEdicao(true);
        return null;
    }

    public String excluirCursosComplementares(CursosComplementares cursosComplementares) {
        candidato.getCursosComplementares().remove(cursosComplementares);
        return null;
    }

    public String inserirIdioma() {
        Idioma idioma = new Idioma();
        idioma.setEdicao(true);
        candidato.getIdiomas().add(idioma);
        idioma.setCandidato(candidato);
        return null;
    }

    public String salvarIdiomas(Idioma idioma) {
        idioma.setEdicao(false);
        return null;
    }

    public String editarIdiomas(Idioma idioma) {
        idioma.setEdicao(true);
        return null;
    }

    public String excluirIdiomas(Idioma idioma) {
        candidato.getIdiomas().remove(idioma);
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

    public Idiomas[] getIdiomasValues() {
        return idiomasValues;
    }

    public Niveis[] getNiveisValues() {
        return niveisValues;
    }

    public Collection<String> getEstados() {
        return estados;
    }

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }
}
