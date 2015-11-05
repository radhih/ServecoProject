package BusinessLogic;

import javax.ejb.Local;

import com.lowagie.text.List;

import entities.Categorie;
import entities.Supplier;
import entities.Vehicul;

@Local
public interface SupplierJSFLocal {
	Supplier auth(String pass,String log);

	Supplier findSupplierForP(int i);
	
	boolean signup(Supplier supplier);
	boolean checkForLogin(String login);
	java.util.List<Categorie> findAllServices();
	Boolean updateSupp(Supplier supplier);
	boolean checkForActivation(Supplier s);
	boolean Subscribe(Supplier supplier);
	java.util.List<Vehicul> getMyCars(String i);
	boolean turnOffCar(Vehicul c);
	Vehicul findCarByname(String n);
	Categorie findServiceByName(String service);
	boolean addCar(Vehicul v);
	java.util.List<Vehicul> getAllCarsForSupplier(String nom);
	
	
	boolean turnOnCar(Vehicul ca);
	java.util.List<Supplier>findSupplierByName(String name);
	java.util.List<Vehicul> getMyCarse(String j);

	
	Supplier getSupplierS(String nom);

	
}
