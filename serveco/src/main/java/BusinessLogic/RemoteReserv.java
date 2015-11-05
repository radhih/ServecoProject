package BusinessLogic;

import java.util.List;

import javax.ejb.NoMoreTimeoutsException;
import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.Bill;
import entities.Reservation;

@Remote
@Path("reservation")
	
public interface RemoteReserv {

	public List<Reservation> findreserv(); 
	public boolean cancel(int id);
	public boolean accpet(int id);
	@GET
	@Path("find/{id}")
	@Produces(MediaType.APPLICATION_JSON)

	public Reservation findById(@PathParam(value = "id") int id);
	public boolean addbill(Bill b);
	@PUT
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)

	public void update (Reservation r);
	
}
