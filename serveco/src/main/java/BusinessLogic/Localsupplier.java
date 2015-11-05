package BusinessLogic;

import java.util.List;





import javax.ejb.Local;

import entities.Supplier;

@Local
public interface Localsupplier {
	

	
 public List<Supplier> afficherSup();

   public List<Supplier> afficher(String service);
   public float affMoyNotes(int id);


	

}
