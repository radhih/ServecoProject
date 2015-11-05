package BusinessLogic;

import javax.ejb.Remote;

import entities.Admin;


@Remote
public interface RemoteSignUp {

	boolean signup(Admin a);
	public Admin Auth(String login,String passwd);
	public boolean update(Admin a);
	public boolean verifyLogin(String login);
	
}
