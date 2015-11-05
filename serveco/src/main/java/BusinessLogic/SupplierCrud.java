package BusinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Blame;
import entities.Note;
import entities.Supplier;

@Stateless
public class SupplierCrud implements RemoteSupplier,Localsupplier {

	
	@PersistenceContext(unitName="Serveco")
	EntityManager em;


	@Override
	public List<Supplier> afficher(String service) {
		String q="select d from Supplier d where d.service=:x";
javax.persistence.Query query = em.createQuery(q);
		
		query.setParameter("x",service);
	
		return query.getResultList();
	}


	@Override
	public List<Supplier> afficherSup() {
		String q="select d from Supplier d";
		javax.persistence.Query query = em.createQuery(q);
				
			
				return query.getResultList();
	}


	@Override
	public void removeSup(int Id) {
		Supplier p= new Supplier();  
		 p =  em.find(Supplier.class, Id);
		 em.remove(em.merge(p));
		
	}


	@Override
	public void BlameSup(int Id, String Blame) {
		Supplier supp= new Supplier();  
		supp =  em.find(Supplier.class, Id);
	    Blame  Bla= new Blame();
		Bla.setSupplier(supp);
		Bla.setBlames(Blame);
		em.persist(Bla);	
		
	}


	@Override
	public Supplier findBy(int id) {
		// TODO Auto-generated method stub
		return em.find(Supplier.class,id);
	}


	@Override
	public float affMoyNotes(int id) {
String q="select d from Note d where d.supplier.id=:x";
		
		javax.persistence.Query query = em.createQuery(q);
		query.setParameter("x",id);
			
				List<Note> notes =query.getResultList();
				int n = 0,t=0;
				for (Note note : notes) {
					t+=note.getNoteSup();
					n++;
				}
				
		return t/n;

	}
	





}
