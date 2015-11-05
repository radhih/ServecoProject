package BusinessLogic;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import entities.Client;



@Remote
public interface ClientCrudRemote {
	public boolean Auth(String login,String passwd);
	public boolean subscriptionClient(Client c) ;
	
}
