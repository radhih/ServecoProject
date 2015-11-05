package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Note implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6295997557999072770L;
	private int Id;
	private int NoteSup;
	private Supplier supplier;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getNoteSup() {
		return NoteSup;
	}
	public void setNoteSup(int noteSup) {
		NoteSup = noteSup;
	}
	@ManyToOne
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
}
