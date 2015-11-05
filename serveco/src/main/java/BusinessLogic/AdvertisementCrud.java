package BusinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Advertisement;
import entities.Claim;
@Stateless
public class AdvertisementCrud implements RemoteAdvertisement {
	@PersistenceContext(unitName="Serveco")
	EntityManager em;
	
	@Override
	public Advertisement find(Advertisement a) {
		Advertisement found=null;
		found=em.find(Advertisement.class, a.getId());	
		return found;
	}

	@Override
	public List<Advertisement> affiche() {
		Query query=em.createQuery("select d from Advertisement d");
		return query.getResultList();
	}

	@Override
	public boolean add(Advertisement a) {
		try
		{
		
			em.merge(a);	
			
		}
		catch(Exception e)
		{
			return false;
		}
		return true;

	}

	@Override
	public boolean update(Advertisement a) {
		try
		{
			em.merge(a);	
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean delete(Advertisement a) {
		try
		{ Claim aa= em.find(Claim.class, a.getId());
			em.remove(em.merge(aa));	
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	@Override
	public Advertisement findByName(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
