package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement(name="service")
public class Categorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String name;
	private List<Vehicul> vehiculs;
	private List<Claim> claims;
	
	
	@OneToMany(mappedBy="clai")
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	@OneToMany(mappedBy="categories")
public List<Vehicul> getVehiculs() {
		return vehiculs;
	}
	public void setVehiculs(List<Vehicul> vehiculs) {
		this.vehiculs = vehiculs;
	}
private List<SubscriptionAdmin> subsAdmin;
	@OneToMany(mappedBy="serviceAdmin",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)	
	public List<SubscriptionAdmin> getSubsAdmin() {
	return subsAdmin;
}
public void setSubsAdmin(List<SubscriptionAdmin> subsAdmin) {
	this.subsAdmin = subsAdmin;
}
private List<SubscriptionSupplier> subsProvider;	

@OneToMany(mappedBy="serviceProvider",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
public List<SubscriptionSupplier> getSubsProvider() {
	return subsProvider;
}
public void setSubsProvider(List<SubscriptionSupplier> subsProvider) {
	this.subsProvider = subsProvider;
}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "" + name + "";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie other = (Categorie) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	

}
