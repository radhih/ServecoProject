package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: reservation
 *
 */
@Entity
@XmlRootElement(name="r")
public class Reservation implements Serializable{

	
	private int id;
	private String date;
	private String namesupplier;
	private boolean status;
	private Vehicul vehicul;
	private Client client;
	

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idVehicul",referencedColumnName="id",insertable=false,updatable=true)
	public Vehicul getVehicul() {
		return vehicul;
	}
	
	public void setVehicul(Vehicul vehicul) {
		this.vehicul = vehicul;
	}
	
	@ManyToOne
	@JoinColumn(name="idClient",referencedColumnName="id",insertable=false,updatable=false)
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Reservation() {
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
  
	public String getNamesupplier() {
		return this.namesupplier;
	}

	public void setNamesupplier(String namesupplier) {
		this.namesupplier = namesupplier;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}   
}
