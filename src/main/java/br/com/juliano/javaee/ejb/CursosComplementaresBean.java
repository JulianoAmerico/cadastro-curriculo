package br.com.juliano.javaee.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.juliano.javaee.model.CursosComplementares;

@Stateless
public class CursosComplementaresBean {

    @PersistenceContext
    private EntityManager em;

    public List<CursosComplementares> listar(int idCandidato){
        String jpql = "SELECT curso FROM cursos_complementares curso WHERE candidato_id = :id";

        TypedQuery<CursosComplementares> query = em.createQuery(jpql, CursosComplementares.class);
        query.setParameter("id", idCandidato);

        return query.getResultList();
    }
}
