package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Accident implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1027953163182008214L;

	
	private int id;
	private String topic;
	private Reservation reservation;
	private String service;
	
	

	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getTopic() {
		return topic;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	@OneToOne
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Accident(String topic, Reservation reservation) {
		super();
		this.topic = topic;
		this.reservation = reservation;
	}
	public Accident() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
