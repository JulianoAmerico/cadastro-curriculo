package br.com.juliano.javaee.ejb;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class CandidatoBean {

	@PersistenceContext
	private EntityManager em;
	
    public CandidatoBean() {
       
    }
}
