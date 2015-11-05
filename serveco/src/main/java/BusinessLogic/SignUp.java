package BusinessLogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Admin;

@Stateless
public class SignUp implements RemoteSignUp {
	@PersistenceContext(unitName="Serveco")
	EntityManager em ;
	@Override
	public boolean signup(Admin a) {
		
		try{
			
		em.persist(a);
		
		}catch(Exception e)
		{
			return false;
		}
	return true;
	}
	@Override
	public Admin Auth(String login, String passwd) {
		Admin a = new Admin();
		a.setLogin("erorr");
		Admin found = null;
		String q = "SELECT u FROM Admin u where u.login=:x and u.passwd=:y";
	
		javax.persistence.Query query = em.createQuery(q);
		
		query.setParameter("x", login);
		
		query.setParameter("y", passwd);
	
		try{
		
			found = (Admin) query.getSingleResult();

		}catch(Exception e){
		return a;
		//	Logger.getLogger(SuperAdmin.class.getName()).log(Level.WARNING,"failed auth for username : " + login);
		}


return found;

	}
	@Override
	public boolean update(Admin a) {
		//em.find(Admin.class, a.getId());
		em.merge(a);
		return false;
	}
	@Override
	public boolean verifyLogin(String login) {
		Admin a = new Admin();
		
		Admin found = null;
		String q = "SELECT u FROM Admin u where u.login=:x";
	
		javax.persistence.Query query = em.createQuery(q);
		
		query.setParameter("x", login);
		
		try{
			found = (Admin) query.getSingleResult();
		}
		catch(Exception e)
		{
		return false;
	}
return true;
	}

}
