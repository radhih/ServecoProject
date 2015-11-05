package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import BusinessLogic.SupplierJSFLocal;
import entities.Vehicul;

@ManagedBean
@ViewScoped
public class CarsBean {

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;
	@EJB
	SupplierJSFLocal jsfLocal;
	
	private List<Vehicul> vehiculs;

	public List<Vehicul> getVehiculs() {
		System.out.println(userBean.getSupplier().getFirstName());
		return jsfLocal.getAllCarsForSupplier(userBean.getSupplier().getFirstName());
	}

	public void setVehiculs(List<Vehicul> vehiculs) {
		this.vehiculs = vehiculs;
	}

	public LoginBean getUserBean() {
		return userBean;
	}

	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}
	
}
