package BusinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Accident;



@Stateless
public class AccidentCrud implements RemoteAccident{
@PersistenceContext(unitName="Serveco")
	EntityManager em;

@Override
public List<Accident> getAllAccident(String service) {
	
	String q="select d from Accident d where d.service=:x";
	javax.persistence.Query query = em.createQuery(q);
			
			query.setParameter("x",service);
		
			return query.getResultList();
		}

	
}
	


