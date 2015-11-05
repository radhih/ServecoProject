package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReservationPk {
private int idClient;
private int idVehicul;


@Column(name="idClient")
public int getIdClient() {
	return idClient;
}
public void setIdClient(int idClient) {
	this.idClient = idClient;
}

@Column(name="idVehicul")
public int getIdVehicul() {
	return idVehicul;
}
public void setIdVehicul(int idVehicul) {
	this.idVehicul = idVehicul;
}
	
	
}
