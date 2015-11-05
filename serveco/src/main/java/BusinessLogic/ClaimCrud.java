package BusinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Categorie;
import entities.Claim;

@Stateless
public class ClaimCrud implements RemoteClaim {
	@PersistenceContext(unitName="Serveco")
	EntityManager em;
	
	
	@Override
	public List<Claim> affich() {
		Query query=em.createQuery("select d from Claim d");
		return query.getResultList();
		
	}

	@Override
	public boolean add(Claim c) {
		try
		{
		
			em.merge(c);	
			
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Claim c) {
		try
		{ Claim cc= em.find(Claim.class, c.getId());
			em.remove(em.merge(cc));	
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	@Override
	public Claim findByName(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Claim c) {
		try
		{
			em.merge(c);	
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Claim find(Claim c) {
		Claim found=null;
			found=em.find(Claim.class, c.getId());	
			return found;
	
	}


}
