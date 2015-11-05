package entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: claim
 *
 */
@Entity

public class Claim implements Serializable {

	
	private int id;
	private String topic;
	private String rep ;
	private static final long serialVersionUID = 1L;
	private Client cl;
private Categorie clai;


@ManyToOne

public Categorie getClai() {
	return clai;
}
public void setClai(Categorie clai) {
	this.clai = clai;
}
@ManyToOne
	public Client getCl() {
	return cl;
}
public void setCl(Client cl) {
	this.cl = cl;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
	public Claim() {
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
 
	public String getTopic() {
		return this.topic;
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
