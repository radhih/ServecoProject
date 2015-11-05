package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SearchBean implements Serializable{

	private String nom;

	
	public String DoGo()
	{
		return "Search.jsf";
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public SearchBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
