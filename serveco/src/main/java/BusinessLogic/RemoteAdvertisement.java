package BusinessLogic;



import java.util.List;

import entities.Advertisement;

public interface RemoteAdvertisement {
	
	
	public Advertisement find(Advertisement c);
	public List<Advertisement> affiche();
	public boolean add(Advertisement c);
	public boolean update(Advertisement c);
	public boolean delete(Advertisement c);
	public Advertisement findByName(String s);

}
