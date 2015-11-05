package entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;


@Entity

public class SubscriptionAdmin implements Serializable {

	
	private int id;
	private String name;
	private String login;
	private String status;
	private String mail;

	private String description;
	private static final long serialVersionUID = 1L;
	private Categorie serviceAdmin;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_service",referencedColumnName="id")
	public Categorie getServiceAdmin() {
		return serviceAdmin;
	}
	public void setServiceAdmin(Categorie serviceAdmin) {
		this.serviceAdmin = serviceAdmin;
	}
	private Admin admin;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		
		this.admin = admin;
	}
	public SubscriptionAdmin() {
		super();
	} 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   

	 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public SubscriptionAdmin(String name, String login, String status,
			String age, String description) {
		super();
		this.name = name;
		this.login = login;
		this.status = status;
		this.description = description;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
