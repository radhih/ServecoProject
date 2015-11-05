package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: supplier
 *
 */
@Entity

public class Supplier extends users implements Serializable {

	private String image;
	
	private int nbvehicul;
	private static final long serialVersionUID = 1L;
	private String service;
	private String coveredArea;
	private List<Blame> blames;
	private List<Note> Notes;
	private double longitude;
	private double latitude;
	private List<SupplierClaim> claims;

	@OneToMany(mappedBy="sup")
		public List<SupplierClaim> getClaims() {
		return claims;
	}
	public void setClaims(List<SupplierClaim> claims) {
		this.claims = claims;
	}

	
	
	@OneToMany(mappedBy="supplier",cascade=CascadeType.REMOVE)
	public List<Blame> getBlames() {
		return blames;
	}
	public void setBlames(List<Blame> blames) {
		this.blames = blames;
	}
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(String firstName, String lastName, String mail,
			String login, String passwd, int age, String phoneNumbe) {
		super(firstName, lastName, mail, login, passwd, age, phoneNumbe);
		// TODO Auto-generated constructor stub
	}
	public int getNbvehicul() {
		return nbvehicul;
	}
	public void setNbvehicul(int nbvehicul) {
		this.nbvehicul = nbvehicul;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCoveredArea() {
		return coveredArea;
	}
	public void setCoveredArea(String coveredArea) {
		this.coveredArea = coveredArea;
	}
	

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.REMOVE,mappedBy="supplier")
	public List<Note> getNotes() {
		return Notes;
	}
	public void setNotes(List<Note> notes) {
		Notes = notes;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
