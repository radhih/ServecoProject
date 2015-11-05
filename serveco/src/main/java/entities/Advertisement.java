package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Advertisement implements Serializable {
	
	private int id;
	private String topic;
	private static final long serialVersionUID = 1L;
	private SuperAdmin sup;
	
	

	@ManyToOne
	public SuperAdmin getSup() {
	return sup;
	}
	public void setSup(SuperAdmin sup) {
		this.sup = sup;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Advertisement() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
}
