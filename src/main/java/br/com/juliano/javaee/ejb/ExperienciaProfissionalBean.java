package br.com.juliano.javaee.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.juliano.javaee.model.ExperienciaProfissional;

@Stateless
public class ExperienciaProfissionalBean {

    @PersistenceContext
    private EntityManager em;

    public List<ExperienciaProfissional> listar(int idCandidato){
        String jpql = "SELECT exp FROM ExperienciaProfissional exp WHERE candidato_id = :id";

        TypedQuery<ExperienciaProfissional> query = em.createQuery(jpql, ExperienciaProfissional.class);
        query.setParameter("id", idCandidato);

        return query.getResultList();
    }


}
