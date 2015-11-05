package BusinessLogic;

import java.util.List;

import javax.ejb.Local;

import entities.Client;

 @Local
public interface LocalClient {
	 public boolean subscriptionClient(Client c);
	
	public List<Client> afficherallclients();
}
