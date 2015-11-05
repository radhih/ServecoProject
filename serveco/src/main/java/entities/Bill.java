package entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: bill
 *
 */
@Entity

public class Bill implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8503173319041788487L;
	private int id;
	private String price;
	private String nameclient;
	private String namesupplier;
	private String typevehicul;

	private Reservation reservation;
	
	@OneToOne
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Bill() {
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
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}   
	public String getNameclient() {
		return this.nameclient;
	}

	public void setNameclient(String nameclient) {
		this.nameclient = nameclient;
	}   
	public String getNamesupplier() {
		return this.namesupplier;
	}

	public void setNamesupplier(String namesupplier) {
		this.namesupplier = namesupplier;
	}   
	public String getTypevehicul() {
		return this.typevehicul;
	}

	public void setTypevehicul(String typevehicul) {
		this.typevehicul = typevehicul;
	}
   
}
