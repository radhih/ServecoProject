package BusinessLogic;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Bill;
import entities.Client;
import entities.Reservation;
import entities.Vehicul;

@Stateless
public class ReservCrud implements RemoteReserv{

	@PersistenceContext(unitName="Serveco")
	EntityManager em;

	@Override
	public List<Reservation> findreserv() {

		String q="select d from Reservation d";

		javax.persistence.Query query = em.createQuery(q);
		//query.setParameter("x",false);
		
		return query.getResultList();
	}

	@Override
	public boolean cancel(int id) {

try
{Reservation r=em.find(Reservation.class, id);

	em.remove(r);
}catch(Exception e)
{
	return false;
}
		return true;
	}

	@Override
	public boolean accpet(int id) {
		try
		{Reservation r=em.find(Reservation.class, id);
r.setStatus(true);
			em.merge(r);
		}catch(Exception e)
		{
			return false;
		}
				return true;
		
	}

	@Override
	public Reservation findById(int id) {
		// TODO Auto-generated method stub
		return em.find(Reservation.class,id);
	}

	@Override
	public boolean addbill(Bill b) {
	try{
	
	em.persist(b);
	}catch(Exception e)
	{return false;

	}
	return true;
	}

	@Override
	public void update(Reservation r) {
	

r.setStatus(true);

em.persist(r);
	}

}
