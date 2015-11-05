package com.rentme.entity;

public class Feedback {
private String nom;
private String body;
private int id;
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Feedback(String nom, String body) {
	super();
	this.nom = nom;
	this.body = body;
}

}
