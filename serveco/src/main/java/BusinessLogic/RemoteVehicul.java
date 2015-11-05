package BusinessLogic;

import java.util.List;









import javax.ejb.Remote;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.Categorie;
import entities.Vehicul;
@Remote
@Path("/vehicule")

public interface RemoteVehicul {
	@GET
	@Path("/list/{id}")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Vehicul> afficherOus(@PathParam(value="id")String id);
	public List<Vehicul> afficher();
	public boolean add(Vehicul c);
	public boolean delete(Vehicul c);
	public Vehicul findByName(String s);
	public boolean updatevehicul(Vehicul vehicul);
	public List<Vehicul> afficherSupVehiculs(String Supname);
	@GET
    @Path("/find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vehicul findById(@PathParam (value="id") int id);


}
