package BusinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Categorie;
import entities.SuperAdmin;

@Stateless

public class ServiceCrud implements RemoteService{
	@PersistenceContext(unitName="Serveco")
	EntityManager em;
	
	
	@Override
	public List<Categorie> afficher() {
		// TODO Auto-generated method stub
		Query query=em.createQuery("select d from Categorie d");
		return query.getResultList();

	}


	@Override
	public boolean add(Categorie c) {
		try
		{
			em.persist(c);	
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
		
	}


	@Override
	public boolean delete(Categorie c) {
		try
		{ Categorie cc= em.find(Categorie.class,c.getId());
			em.remove(em.merge(cc));	
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}


	@Override
	public Categorie findByName(String s) {
		// TODO Auto-generated method stub
		Categorie found=null;
		
		String q="select d from Categorie d where d.name=:x";

		javax.persistence.Query query = em.createQuery(q);
		
		query.setParameter("x", s);
	
			found =  (Categorie) query.getSingleResult();
	
	return found;
	}

}
