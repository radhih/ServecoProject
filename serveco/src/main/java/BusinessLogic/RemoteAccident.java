package BusinessLogic;

import java.util.List;

import javax.ejb.Remote;

import entities.Accident;

@Remote
public interface RemoteAccident {

	
	public List<Accident> getAllAccident(String service);
	
}
