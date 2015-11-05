package com.rentme.entity;
public class Vehicule  {

	
	private int id;
	


	private String type;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getNomsupplier() {
		return nomsupplier;
	}


	public void setNomsupplier(String nomsupplier) {
		this.nomsupplier = nomsupplier;
	}


	public String getCategories() {
		return categories;
	}


	public void setCategories(String categories) {
		this.categories = categories;
	}


	public Vehicule(String type, String nomsupplier, String categories) {
		super();
		this.type = type;
		this.nomsupplier = nomsupplier;
		this.categories = categories;
	}


	public Vehicule() {
		// TODO Auto-generated constructor stub
	}


	private String nomsupplier;
 
 
private String categories;

 
 
	
	
}
