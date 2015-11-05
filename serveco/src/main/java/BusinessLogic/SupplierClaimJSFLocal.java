package BusinessLogic;

import javax.ejb.Local;

 
import entities.SupplierClaim;



@Local
public interface SupplierClaimJSFLocal {

	
	Boolean AddClaim(SupplierClaim supc);
	
}
