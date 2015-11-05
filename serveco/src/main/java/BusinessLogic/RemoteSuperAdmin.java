package BusinessLogic;

import javax.ejb.Remote;


import entities.SuperAdmin;

@Remote
public interface RemoteSuperAdmin {

	public SuperAdmin find();
	
	
}
