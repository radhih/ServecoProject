package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class SupplierClaim implements Serializable {

	
	private int id;
	private String topic;
	private String rep ;
	private static final long serialVersionUID = 1L;
	private Supplier sup;
	
	
	@ManyToOne
	public Supplier getSup() {
		return sup;
	}
	public void setSup(Supplier sup) {
		this.sup = sup;
	}
	
	public SupplierClaim() {
		super();
	} 
	
	
	

	public SupplierClaim(String topic, String rep, Supplier sup) {
		super();
		this.topic = topic;
		this.rep = rep;
		this.sup = sup;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getRep() {
		return rep;
	}
	public void setRep(String rep) {
		this.rep = rep;
	}
	
	
	
}
