package BusinessLogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Note;
 
@Stateless
public class RankJSF implements RankJSFLocal {
	
	@PersistenceContext(unitName="Serveco")
	EntityManager em;
	
	
	@Override
	public Note Ranksup(int i) {
		return (Note) em.createQuery("select d from Note d where d.id=:x ").setParameter("x", i).getSingleResult();
	}


	@Override
	public Note findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Note.class,id);
	}


	@Override
	public List<Note> findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT u FROM Note u");
		return query.getResultList();
	}
	

}
