package BusinessLogic;

import java.util.List;

import javax.ejb.Remote;

import entities.Admin;


@Remote
public interface RemoteAdmin {

	
	public List<Admin> findALl(); 
	public boolean updateService(String service,int id);
}
