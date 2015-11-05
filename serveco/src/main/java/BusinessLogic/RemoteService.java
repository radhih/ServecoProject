package BusinessLogic;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebService;

import entities.Categorie;


@Remote

public interface RemoteService {

	public List<Categorie> afficher();
	
public boolean add(Categorie c);

public boolean delete(Categorie c);

public Categorie findByName(String s);
	
}
