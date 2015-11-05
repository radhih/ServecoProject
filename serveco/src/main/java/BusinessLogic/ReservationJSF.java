package BusinessLogic;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import entities.Reservation;
import entities.Supplier;


@Stateless
@LocalBean
public class ReservationJSF implements ReservationJSFLocal{
	
	@PersistenceContext(name="serveco")
	EntityManager em;

	@Override
	public List<Reservation> findreservbySupplierName(String name) {
		
	return em.createQuery("select r from Reservation r where r.namesupplier=:param",Reservation.class).setParameter("param", name).getResultList();
		
	}
}
