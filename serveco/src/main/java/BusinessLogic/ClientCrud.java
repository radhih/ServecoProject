package BusinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Client;


/**
 * Session Bean implementation class ClientCrud
 */
@Stateless

public class ClientCrud implements ClientCrudRemote {

	@PersistenceContext(unitName="Serveco")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ClientCrud() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean Auth(String login,String passwd) {
		Client found = null;
		String q = "SELECT u FROM Client u where u.login=:x and u.passwd=:y";
	
		javax.persistence.Query query = em.createQuery(q);
		
		query.setParameter("x",login);
		
		query.setParameter("y",passwd);
	
		try{
		
			found = (Client) query.getSingleResult();

		}catch(Exception e){
		return false;
		}


return true;
	}

	@Override
	public boolean subscriptionClient(Client c) {
		em.persist(c);
		return true;
	}

	

}
