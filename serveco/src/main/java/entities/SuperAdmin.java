package entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;

import javax.persistence.OneToMany;

@Entity
public class SuperAdmin extends users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Admin> admins;
	private List<Advertisement> advertisements;
	
	
	
	@OneToMany(mappedBy="sup")
	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	@OneToMany(mappedBy="superadmin")
	public List<Admin> getAdmins() {
	return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public SuperAdmin() {
		super();

	}
	public SuperAdmin(String firstName, String lastName, String mail, String login,
			String passwd, int age, String phoneNumbe) {
		super(firstName, lastName, mail, login, passwd, age, phoneNumbe);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
