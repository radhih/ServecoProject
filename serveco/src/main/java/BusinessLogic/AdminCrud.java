package BusinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Admin;

@Stateless
public class AdminCrud implements RemoteAdmin{
	@PersistenceContext(name="Serveco")
	EntityManager em;

	@Override
	public List<Admin> findALl() {
		Query query=em.createQuery("select d from Admin d");
		return query.getResultList();
	}

	@Override
	public boolean updateService(String service,int id) {
		try
		{Admin a=new Admin();
		a=em.find(Admin.class, id);
		a.setService(service);
		em.merge(a);
		
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

}
