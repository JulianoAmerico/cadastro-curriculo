package br.com.juliano.javaee.ejb;

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

    @SuppressWarnings("deprecation")
    public List<Candidato> consultarPorData(Date consulta, Boolean tipoFiltro) {
        if (tipoFiltro) {
            String jpql = "SELECT c FROM Candidato c WHERE c.dataCadastro = :data ORDER BY c.dataCadastro DESC";
            TypedQuery<Candidato> q = em.createQuery(jpql, Candidato.class);
            q.setParameter("data", consulta);

            return q.getResultList();
        } else {
            String jpql = "SELECT c FROM Candidato c WHERE DAY(c.dataCadastro) = :dia AND MONTH(c.dataCadastro) = :mes";
            TypedQuery<Candidato> q = em.createQuery(jpql, Candidato.class);
            q.setParameter("dia", consulta.getDay());
            q.setParameter("mes", consulta.getMonth());

            return q.getResultList();
        }

    }
}
