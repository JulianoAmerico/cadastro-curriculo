package br.com.juliano.javaee.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.juliano.javaee.model.Idioma;


@Stateless
public class IdiomaBean {

    @PersistenceContext
    private EntityManager em;

    public List<Idioma> listar(int idCandidato){
        String jpql = "SELECT i FROM idioma i WHERE candidato_id = :id";

        TypedQuery<Idioma> query = em.createQuery(jpql, Idioma.class);
        query.setParameter("id", idCandidato);

        return query.getResultList();
    }

}
