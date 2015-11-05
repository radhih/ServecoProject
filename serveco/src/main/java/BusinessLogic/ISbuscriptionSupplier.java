package BusinessLogic;

import java.util.List;

import javax.ejb.Remote;

import entities.SubscriptionSupplier;


@Remote
public interface ISbuscriptionSupplier  {
	public  List<SubscriptionSupplier> findinscptionsuppbyserviceandstatus (String service, String status);

	public boolean updateSubs(SubscriptionSupplier s);
	

	public boolean DeleteSubs(SubscriptionSupplier s);
	

}
