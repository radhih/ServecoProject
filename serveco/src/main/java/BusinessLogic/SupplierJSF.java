package BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Categorie;
import entities.SubscriptionSupplier;
import entities.Supplier;
import entities.Vehicul;

/**
 * Session Bean implementation class SupplierJSF
 */
@Stateless
@LocalBean
public class SupplierJSF implements SupplierJSFLocal {
	@PersistenceContext(unitName="Serveco")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public SupplierJSF() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Supplier auth(String pass, String log) {
		Supplier s=null;
		try{
		s= (Supplier) em.createQuery("select d from Supplier d where d.login=:x and d.passwd=:y").setParameter("x", log).setParameter("y",pass).getSingleResult();
		}
		catch(Exception e)
		{
		return null;	
		}
		return s;
	}

	@Override
	public Supplier findSupplierForP(int i) {
		// TODO Auto-generated method stub
		return (Supplier) em.createQuery("select d from Supplier d where d.id=:x ").setParameter("x", i).getSingleResult();
	}

	@Override
	public boolean signup(Supplier supplier) {
		
		try{
	em.persist(supplier);
	
		}
		catch(Exception e)
		{
			return false;
		}
	return true;
	}

	@Override
	public boolean checkForLogin(String login) {
		
		Supplier s=null;
		try{
			s= (Supplier) em.createQuery("select d from Supplier d where d.login=:x ").setParameter("x", login).getSingleResult();
		}
		catch(Exception e)
		{
			return false;
		}
	if(s==null)
	{
		return false;
	}
		return true;
	
			
	}

	@Override
	public List<Categorie> findAllServices() {
		// TODO Auto-generated method stub
		return  em.createQuery("select d from Categorie d ").getResultList();

	}
	
	
	@Override
	public Boolean updateSupp(Supplier supplier) {
		
		try {
			em.merge(supplier);
			return true;

		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean checkForActivation(Supplier s) {
		
		SubscriptionSupplier k = null;
		try{
		 k= (SubscriptionSupplier) em.createQuery("select d from SubscriptionSupplier d where d.supplier.id=:x").setParameter("x",s.getId()).getSingleResult();
		System.out.println(k.getStatus());
		}
		catch(Exception e)
		{

			return false;

		}
		
		if(k.getStatus().equals("validated"))
		{

			return true;
		}else{
		return false;
	}
		}

	@Override
	public boolean Subscribe(Supplier supplier) {
SubscriptionSupplier subscriptionSupplier=new SubscriptionSupplier();
subscriptionSupplier.setDescription(supplier.getService());
subscriptionSupplier.setLogin(supplier.getLogin());
subscriptionSupplier.setName(supplier.getFirstName());
subscriptionSupplier.setStatus("NotValidated");
subscriptionSupplier.setSupplier(supplier);
Categorie categorie=(Categorie) em.createQuery("select d from Categorie d where d.name=:x").setParameter("x",supplier.getService()).getSingleResult();
subscriptionSupplier.setServiceProvider(categorie);
System.out.println(categorie.getName());
try{
	em.persist(subscriptionSupplier);
	
		}
		catch(Exception e)
		{
			return false;
		}
	return true;
	}

	@Override
	public List<Vehicul> getMyCars(String i) {
	
		
		return em.createQuery("select d from Vehicul d where d.nomsupplier =:x and d.available=:y").setParameter("x", i).setParameter("y","Available").getResultList();

		
	}

	@Override
	public boolean turnOffCar(Vehicul c) {

		
		try{em.merge(c);
		
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	@Override
	public Vehicul findCarByname(String n) {
		// TODO Auto-generated method stub
		return (Vehicul) em.createQuery("select d from Vehicul d where d.type=:x").setParameter("x",n).getSingleResult();
	}

	@Override
	public Categorie findServiceByName(String service) {
		// TODO Auto-generated method stub
		return (Categorie) em.createQuery("select x from Categorie x where x.name =:k").setParameter("k",service).getSingleResult();
	}

	@Override
	public boolean addCar(Vehicul v) {
try{
	em.persist(v);
		
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	@Override
	public List<Vehicul> getAllCarsForSupplier(String nom) {
		
		return em.createQuery("Select p from Vehicul p where p.nomsupplier=:x").setParameter("x",nom).getResultList();

	}

	@Override
	public boolean turnOnCar(Vehicul ca) {
try{em.merge(ca);
		
		}
		catch(Exception e)
		{
			return false;
		}
		return true;

	}

	@Override
	public List<Supplier> findSupplierByName(String name) {
		return em.createQuery("select r from Supplier r where r.firstName=:param",Supplier.class).setParameter("param", name).getResultList();

	}

	@Override
	public List<Vehicul> getMyCarse(String j) {
		return em.createQuery("select d from Vehicul d where d.nomsupplier =:z and d.available=:v").setParameter("z", j).setParameter("v","NotAvailable").getResultList();
		
	}

	@Override
	public Supplier getSupplierS(String nom) {
		// TODO Auto-generated method stub
		return (Supplier) em.createQuery("select p from Supplier p where p.firstName=:x").setParameter("x",nom).getSingleResult();
	}

}
