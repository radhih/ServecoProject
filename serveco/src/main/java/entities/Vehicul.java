package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: vehicul
 *
 */
@Entity

public class Vehicul implements Serializable {

	
	private int id;
	private String type;
	private String available;
	private String nomsupplier;
	private static final long serialVersionUID = 1L;
	private String image;
public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
private List<Reservation> reservations;
private Categorie categories;

@ManyToOne
//@JoinColumn(name="idService",referencedColumnName="id",insertable=false,updatable=false)
public Categorie getCategories() {
	return categories;
}
public void setCategories(Categorie categories) {
	this.categories = categories;
}
@OneToMany(mappedBy="vehicul",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<Reservation> getReservations() {
	return reservations;
}
public void setReservations(List<Reservation> reservations) {
	this.reservations = reservations;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
	public Vehicul() {
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
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public String getNomsupplier() {
		return this.nomsupplier;
	}

	public void setNomsupplier(String nomsupplier) {
		this.nomsupplier = nomsupplier;
	}
	public Vehicul(String type, String nomsupplier) {
		super();
		this.type = type;
		this.nomsupplier = nomsupplier;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Vehicul other = (Vehicul) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "" + type + "";
	}
	
}
