package BusinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





import entities.Categorie;
import entities.Vehicul;

@Stateless
public class VehiculCrud implements RemoteVehicul{
	@PersistenceContext(unitName="Serveco")
	EntityManager em;

	

	@Override
	public boolean add(Vehicul c) {
		// TODO Auto-generated method stub
		try
		{
			em.persist(c);	
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}

	@Override
	public boolean delete(Vehicul c) {
		// TODO Auto-generated method stub
		try
		{ Vehicul cc= em.find(Vehicul.class,c.getId());
		System.out.println(cc.getId());	
		em.remove(cc);	
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	@Override
	public Vehicul findByName(String s) {
		// TODO Auto-generated method stub
Vehicul found=null;
		
		String q="select d from Vehicul d where d.type=:x";

		javax.persistence.Query query = em.createQuery(q);
		
		query.setParameter("x", s);
	
			found =  (Vehicul) query.getSingleResult();
	
	return found;
	}

	@Override
	public boolean updatevehicul(Vehicul vehicul) {
		// TODO Auto-generated method stub
		try{
			em.merge(vehicul);
			return true;
			
		}catch(Exception e){
		
			return false;
		}
	}

	@Override
	public List<Vehicul> afficherSupVehiculs(String Supname) {

		
		String q="select d from Vehicul d where d.nomsupplier=:x";

		javax.persistence.Query query = em.createQuery(q);
		
		query.setParameter("x", Supname);
	
	return query.getResultList();
	
	
	}

	@Override
	public Vehicul findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Vehicul.class, id);
	}

	@Override
	public List<Vehicul> afficherOus(String id) {
		// TODO Auto-generated method stub
		Query query=em.createQuery("select NEW entities.Vehicul(v.type,v.nomsupplier)  from Vehicul v where v.categories.name=:x").setParameter("x",id);
		return query.getResultList();
	}

	@Override
	public List<Vehicul> afficher() {
		// TODO Auto-generated method stub
		Query query=em.createQuery("select v from Vehicul v ");
		return query.getResultList();
	}

	
}


