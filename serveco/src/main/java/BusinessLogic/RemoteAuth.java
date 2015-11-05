package BusinessLogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.SuperAdmin;


@Stateless
public class RemoteAuth implements IAuth{
	@PersistenceContext(unitName="Serveco")
	private EntityManager em;

	@Override
	public SuperAdmin Auth(String login, String passwd) {
		SuperAdmin a = new SuperAdmin();
		a.setLogin("erorr");
		SuperAdmin found = null;
		String q = "SELECT u FROM SuperAdmin u where u.login=:x and u.passwd=:y";
	
		javax.persistence.Query query = em.createQuery(q);
		
		query.setParameter("x", login);
		
		query.setParameter("y", passwd);
	
		try{
		
			found = (SuperAdmin) query.getSingleResult();

		}catch(Exception e){
		return a;
		//	Logger.getLogger(SuperAdmin.class.getName()).log(Level.WARNING,"failed auth for username : " + login);
		}


return found;

	}
	

}
