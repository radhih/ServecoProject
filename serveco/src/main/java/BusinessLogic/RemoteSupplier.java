package BusinessLogic;

import java.util.List;

import javax.ejb.Remote;

import entities.Supplier;

@Remote
public interface RemoteSupplier {

	public List<Supplier> afficher(String service);
	public List<Supplier> afficherSup();
	public void removeSup(int Id);
	public void BlameSup(int Id,String Blame);
public Supplier findBy(int id);
	
}
