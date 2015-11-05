package beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import BusinessLogic.SupplierJSFLocal;
import entities.Vehicul;


@ManagedBean
@SessionScoped
public class AvailableBean implements Serializable{
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;
	
	
	
	private Vehicul car;
	private List<Vehicul> cars;
	@EJB
	SupplierJSFLocal sJsfLocal;
	
	
	public AvailableBean() {
	
	}

public Vehicul doFindCarByName(String n)
{Vehicul c=sJsfLocal.findCarByname(n);	
return c;
}
	public String doTurnOffV()
	{
System.out.println("mmmmmmm:"+car.getAvailable());
	car.setAvailable("NotAvailable");
		sJsfLocal.turnOffCar(car);	
		return "";
		
	}	
	
	public Vehicul getCar() {
		return car;
	}
	public void setCar(Vehicul car) {
		this.car = car;
	}

	public List<Vehicul> getCars() {
		return sJsfLocal.getMyCars(userBean.getSupplier().getFirstName());
	}

	public void setCars(List<Vehicul> cars) {
		this.cars = cars;
	}

	public LoginBean getUserBean() {
		return userBean;
	}

	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}

	
	
}
