package entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: inscripsupplier
 *
 */
@Entity

public class SubscriptionSupplier implements Serializable {

	
	private int id;
	private String name;
	private String login;
	private String status;
	private String typevehicul;
	private String description;
	private static final long serialVersionUID = 1L;
	private Supplier supplier;
	private Categorie serviceProvider;
	
	@ManyToOne
	@JoinColumn(name="id_service",referencedColumnName="id",insertable=false,updatable=false)

	
	public Categorie getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(Categorie serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public SubscriptionSupplier() {
		super();
	}   
	
	@OneToOne(cascade=CascadeType.ALL)
	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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

	public String getTypevehicul() {
		return this.typevehicul;
	}

	public void setTypevehicul(String typevehicul) {
		this.typevehicul = typevehicul;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SubscriptionSupplier(String name, String login, String status,
			String typevehicul, String description) {
		super();
		this.name = name;
		this.login = login;
		this.status = status;
		this.typevehicul = typevehicul;
		this.description = description;
	}
   
}
