package br.com.juliano.javaee.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.juliano.javaee.model.FormacaoAcademica;

@Stateless
public class FormacaoAcademicaBean {

    @PersistenceContext
    private EntityManager em;

    public List<FormacaoAcademica> listar(int idCandidato){
        String jpql = "SELECT fa FROM FormacaoAcademica fa WHERE candidato_id = :id";

        TypedQuery<FormacaoAcademica> query = em.createQuery(jpql, FormacaoAcademica.class);
        query.setParameter("id", idCandidato);

        return query.getResultList();
    }
}
