package WebService;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Categorie;
import entities.Supplier;



/**
 * Session Bean implementation class Authentication
 */
@Stateless
@WebService(portName="ServecoPort",serviceName="ServecoService",
endpointInterface="WebService.AuthenticationRemote")
public class Authentication implements AuthenticationRemote {

    /**
     * Default constructor. 
     */

	@PersistenceContext(unitName="Serveco")
	EntityManager em;
	@EJB
	   Services cr;
	public Authentication() {
        // TODO Auto-generated constructor stub
    }
 
    
	@Override
	public boolean Auth(String login, String passwd) {
		// TODO Auto-generated method stub
		return cr.Auth(login, passwd);
	}


	@Override
	public List<Categorie> afficher() {
		// TODO Auto-generated method stub
		return cr.afficher();
	}


	@Override
	public List<Float> getLong() {
		// TODO Auto-generated method stub
		return cr.getLong();
	}


	@Override
	public List<Float> getLat() {
		// TODO Auto-generated method stub
		return cr.getLat();
	}


	@Override
	public List<Supplier> getInfo() {
		// TODO Auto-generated method stub
		return cr.getInfo();
	}


	@Override
	public boolean sendMessage(String msg, String client) {
		// TODO Auto-generated method stub
		return cr.sendMessage(msg, client);
	}


	@Override
	public boolean signUp(String first, String last, String mail, String login,
			String passwd, String phone, int age) {
		// TODO Auto-generated method stub
		return cr.signUp(first, last, mail, login, passwd, phone, age);
	}

}
