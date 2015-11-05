package BusinessLogic;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Categorie;
import entities.SubscriptionSupplier;


@Stateless

public class SubscriptionSupplierCrud implements ISbuscriptionSupplier{
	
	@PersistenceContext(unitName="Serveco")
	EntityManager em;
	
	@Override
	public  List<SubscriptionSupplier> findinscptionsuppbyserviceandstatus (String service, String status)


	
	{
		
	
		String q="select d from SubscriptionSupplier d where d.description=:x and d.status=:y" ;
		javax.persistence.Query query = em.createQuery(q);
				
				query.setParameter("x",service);
				query.setParameter("y",status);
			
				return query.getResultList();
			}

	@Override
	public boolean updateSubs(SubscriptionSupplier s) {
		// TODO Auto-generated method stub
		try{
			SubscriptionSupplier ss=em.find(SubscriptionSupplier.class, s.getId());
		ss.setStatus("validated");
			em.merge(ss);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
		}

	@Override
	public boolean DeleteSubs(SubscriptionSupplier s) {
		try{
			em.remove(em.find(SubscriptionSupplier.class,s.getId()));
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
		}
	}		
		
	
	
