package br.com.juliano.javaee.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.juliano.javaee.model.Candidato;

/**
 * Session Bean que faz o CRUD do Candidato.
 * @author Juliano R. Am�rico
 *
 */
@Stateless
public class CandidatoBean {

	@PersistenceContext
	private EntityManager em;
	
    public CandidatoBean() {
    }
    
    /**
     * Grava os do candidato no banco de dados, fornecido pelo formul�rio do usu�rio.
     * @param candidato Dados do candidato preenchido.
     */
    public void gravar(Candidato candidato) {
    	em.persist(candidato);
    }
}
