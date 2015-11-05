package BusinessLogic;

import javax.ejb.Remote;

import entities.SuperAdmin;


@Remote
public interface IAuth {
	public SuperAdmin Auth(String login,String passwd);
	
	
}
