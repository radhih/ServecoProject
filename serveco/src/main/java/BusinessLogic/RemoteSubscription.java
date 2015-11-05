package BusinessLogic;

import java.util.List;

import javax.ejb.Remote;
import javax.enterprise.inject.AmbiguousResolutionException;

import entities.Admin;
import entities.SubscriptionAdmin;


@Remote
public interface RemoteSubscription {

	public boolean subscribe(SubscriptionAdmin a);
	public List<SubscriptionAdmin> findAll();
	public boolean remove(SubscriptionAdmin a);
	public boolean accept(SubscriptionAdmin a);


}
