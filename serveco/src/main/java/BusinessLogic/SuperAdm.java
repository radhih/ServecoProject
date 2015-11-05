package BusinessLogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.SuperAdmin;

@Stateless
public class SuperAdm implements RemoteSuperAdmin{

	@PersistenceContext(unitName="Serveco")
	EntityManager em;
	@Override
	public SuperAdmin find() {
		
		return em.find(SuperAdmin.class,1);
		
	}
	

}
