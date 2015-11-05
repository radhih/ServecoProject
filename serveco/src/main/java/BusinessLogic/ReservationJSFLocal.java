package BusinessLogic;

import java.util.List;

import javax.ejb.Local;

import entities.Reservation;


@Local
public interface ReservationJSFLocal {

	

	public List<Reservation> findreservbySupplierName(String name);

}
