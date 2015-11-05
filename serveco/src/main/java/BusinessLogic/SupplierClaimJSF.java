package BusinessLogic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.SupplierClaim;


@Stateless
@LocalBean
public class SupplierClaimJSF implements SupplierClaimJSFLocal {
	
	@PersistenceContext(unitName="Serveco")
	EntityManager em;
	
	 public SupplierClaimJSF() {
 	    }

	@Override
	public Boolean AddClaim(SupplierClaim supc) {
		try{
			em.persist(supc);
			return true;
				}
				catch(Exception e)
				{
					return false;
				}
			
	}

}
