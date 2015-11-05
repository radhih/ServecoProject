package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import BusinessLogic.SupplierJSFLocal;
import entities.Supplier;

@ManagedBean
@SessionScoped
public class supplierProfBean {

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;
	
	
	public LoginBean getUserBean() {
		return userBean;
	}

	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}

	Supplier sup=new Supplier();
@EJB
	SupplierJSFLocal s;
	
	public Supplier getSup() {
		
		System.out.println(userBean.getSupplier().getId());
		sup=s.findSupplierForP(userBean.getSupplier().getId());
		
		return sup;
	}

	public void setSup(Supplier sup) {
		this.sup = sup;
	}
	
	
	

}
