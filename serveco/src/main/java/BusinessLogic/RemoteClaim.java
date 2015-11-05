package BusinessLogic;

import java.util.List;

import javax.ejb.Remote;

import entities.Claim;


@Remote
public interface RemoteClaim {

public Claim find(Claim c);
	public List<Claim> affich();
	public boolean add(Claim c);
	public boolean update(Claim c);
	public boolean delete(Claim c);
	public Claim findByName(String s);
	
}
