package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: client
 *
 */
@Entity

public class Client extends users implements Serializable {

	

	private int nbreservation;
private List< Reservation> reservations;
private List<Claim> claims;

private List<ClientAskClient> AskClient;
@OneToMany(mappedBy= "client")
public List<ClientAskClient> getAskClient() {
	return AskClient;
}
public void setAskClient(List<ClientAskClient> askClient) {
	AskClient = askClient;
}


@OneToMany(mappedBy="cl")
	public List<Claim> getClaims() {
	return claims;
}
public void setClaims(List<Claim> claims) {
	this.claims = claims;
}
	@OneToMany(mappedBy="client")
	public List<Reservation> getReservations() {
	return reservations;
}
public void setReservations(List<Reservation> reservations) {
	this.reservations = reservations;
}

	private static final long serialVersionUID = 1L;
	public int getNbreservation() {
		return nbreservation;
	}
	public void setNbreservation(int nbreservation) {
		this.nbreservation = nbreservation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String firstName, String lastName, String mail, String login,
			String passwd, int age, String phoneNumbe) {
		super(firstName, lastName, mail, login, passwd, age, phoneNumbe);
		// TODO Auto-generated constructor stub
	}

   
}
