package entities;

import java.io.Serializable;




import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity

public class Admin extends users implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private boolean subs;

	private byte[] image;
private String service;

	private SuperAdmin superadmin;
	
	private SubscriptionAdmin sub;
	
	@ManyToOne
	@JoinColumn(name="idSuperAdmin",referencedColumnName="id",insertable=false,updatable=false)
	public SuperAdmin getSuperadmin() {
		return superadmin;
	}

	public void setSuperadmin(SuperAdmin superadmin) {
		this.superadmin = superadmin;
	}

	public Admin(String firstName, String lastName, String mail, String login,
			String passwd, int age, String phoneNumbe) {
		super(firstName, lastName, mail, login, passwd, age, phoneNumbe);
		// TODO Auto-generated constructor stub
	}

	

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isSubs() {
		return subs;
	}

	public void setSubs(boolean subs) {
		this.subs = subs;
	}

	@Lob
	

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToOne(mappedBy="admin")
	public SubscriptionAdmin getSub() {
		return sub;
	}

	public void setSub(SubscriptionAdmin sub) {
		this.sub = sub;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}


	

}
