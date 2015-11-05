package BusinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Admin;
import entities.Categorie;
import entities.SubscriptionAdmin;
import entities.SuperAdmin;

@Stateless
public class subsCrud implements RemoteSubscription{

	@PersistenceContext(unitName="Serveco")
	EntityManager em;

	@Override
	public boolean subscribe(SubscriptionAdmin a) {
		System.out.println("\n\n subs : "+a.getDescription());
		System.out.println("\n\n "+a.getAdmin());
		
			em.find(Admin.class, a.getAdmin().getId());
			em.merge(a);

		
		return true;
			}

	@Override
	public List<SubscriptionAdmin> findAll() {
		Query query=em.createQuery("select d from SubscriptionAdmin d");
		return query.getResultList();
	}

	@Override
	public boolean remove(SubscriptionAdmin a) {
		try
		{ SubscriptionAdmin cc= em.find(SubscriptionAdmin.class,a.getId());
	cc.setStatus("Refused");
		em.merge(cc);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean accept(SubscriptionAdmin a) {
		try{ SubscriptionAdmin cc= em.find(SubscriptionAdmin.class,a.getId());
		cc.setStatus("Accepted");
			em.merge(cc);
			Admin admin=new Admin();
		admin=cc.getAdmin();
		admin.setService(cc.getServiceAdmin().getName());
		admin.setSubs(true);
		SuperAdmin sa=em.find(SuperAdmin.class,1);
		admin.setSuperadmin(sa);
		em.merge(admin);	
		
		}
			catch(Exception ee)
			{
				return false;
			}
			return true;
		
	}
	

	
	
	
}
