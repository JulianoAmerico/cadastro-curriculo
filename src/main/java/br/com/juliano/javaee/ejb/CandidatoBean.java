package br.com.juliano.javaee.ejb;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.juliano.javaee.model.Candidato;
import br.com.juliano.javaee.model.CursosComplementares;
import br.com.juliano.javaee.model.ExperienciaProfissional;
import br.com.juliano.javaee.model.FormacaoAcademica;
import br.com.juliano.javaee.model.Idioma;

/**
 * Session Bean que faz o CRUD do Candidato.
 *
 * @author Juliano R. Américo
 *
 */
@Stateless
public class CandidatoBean {

    @PersistenceContext
    private EntityManager em;

    public CandidatoBean() {
    }

    /**
     * Grava os do candidato no banco de dados, fornecido pelo formulário do usuário.
     *
     * @param candidato Dados do candidato preenchido.
     */
    public void gravar(Candidato candidato, List<ExperienciaProfissional> expProfissional,
            List<FormacaoAcademica> formacaoAcademica, List<CursosComplementares> cursosComplementares, List<Idioma> idiomas) {

        em.persist(candidato);

        expProfissional.forEach(e -> {
            e.setCandidato(candidato);
            em.persist(e);
        });

        formacaoAcademica.forEach(e -> {
            e.setCandidato(candidato);
            em.persist(e);
        });

        cursosComplementares.forEach(e -> {
            e.setCandidato(candidato);
            em.persist(e);
        });

        idiomas.forEach(e -> {
            e.setCandidato(candidato);
            em.persist(e);
        });
    }

    public List<Candidato> consultarPorData(LocalDate localDate) {
        /*
         * As colunas que tem data é do tipo java.util.Date então, é necessário converter LocalDate para Date.
         */
        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        int year = localDate.getYear();

        //Ano igual 0 significa que foi passado somente dia/mês na data.
        if (year != 0) {
            String jpql = "SELECT c FROM Candidato c WHERE c.dataCadastro = :data ORDER BY c.dataCadastro DESC";
            TypedQuery<Candidato> q = em.createQuery(jpql, Candidato.class);
            q.setParameter("data", date);

            return q.getResultList();
        } else {
            String jpql = "SELECT c FROM Candidato c WHERE DAY(c.dataCadastro) = :dia AND MONTH(c.dataCadastro) = :mes";
            TypedQuery<Candidato> q = em.createQuery(jpql, Candidato.class);
            q.setParameter("dia", localDate.getDayOfMonth());
            q.setParameter("mes", localDate.getMonthValue());

            return q.getResultList();
        }

    }
}
