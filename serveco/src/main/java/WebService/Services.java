package WebService;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Categorie;
import entities.Client;
import entities.ClientAskClient;
import entities.Supplier;


/**
 * Session Bean implementation class ClientCrud
 */
@Singleton
@LocalBean
public class Services {

	@PersistenceContext(unitName="Serveco")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public Services() {
        // TODO Auto-generated constructor stub
    }
    public List<Categorie> afficher() {
		// TODO Auto-generated method stub
		Query query=em.createQuery("select d.name from Categorie d");
		return query.getResultList();

	}

    
	public boolean Auth(String login,String passwd) {
		Client found = null;
		String q = "SELECT u FROM Client u where u.login=:x and u.passwd=:y";
	
		javax.persistence.Query query = em.createQuery(q);
		
		query.setParameter("x",login);
		
		query.setParameter("y",passwd);
	
		try{
		
			found = (Client) query.getSingleResult();

		}catch(Exception e){
		return false;
		}


return true;
	}
	public List<Float> getLong()
	{String q = "SELECT u.longitude FROM Supplier u";
	
	javax.persistence.Query query = em.createQuery(q);
		return query.getResultList();
	}
	public List<Float> getLat()
	{String q = "SELECT u.latitude FROM Supplier u";
	
	javax.persistence.Query query = em.createQuery(q);
		return query.getResultList();
	}
	public List<Supplier> getInfo()
	{String q = "SELECT u.service FROM Supplier u";
	
	javax.persistence.Query query = em.createQuery(q);
		return query.getResultList();
	}
	
	
	public boolean sendMessage(String msg,String client)
	{
		ClientAskClient c=new ClientAskClient();
		c.setMessage(msg);
		int id =  (int) em.createQuery("select u.id from Client u where login=:x").setParameter("x",client).getSingleResult();
		Client t=em.find(Client.class, id);
		c.setClient(t);
		em.persist(c);
		return true;
	}
	public boolean signUp(String first,String last,String mail,String login,String passwd,String phone,int age)
	{
		Client c=new Client();
		c.setAge(age);
		c.setFirstName(first);
		c.setLastName(last);
	c.setLogin(login);
	c.setPasswd(passwd);
	c.setPhoneNumbe(phone);
	c.setMail(mail);
	em.persist(c);
	return true;
	
	}
}
