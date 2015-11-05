package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import entities.Supplier;
import BusinessLogic.SupplierJSFLocal;


@ManagedBean
@SessionScoped
public class updateProfilBean {
	@EJB SupplierJSFLocal s;
	@ManagedProperty ("#{supplierProfBean.sup}")
	Supplier sup=new Supplier();
	public Supplier getSup() {
		return sup;
	}
	public void setSup(Supplier sup) {
		this.sup = sup;
	}
	public String DoUpdate(){
		s.updateSupp(sup);
		return "profile?faces-redirect=true";
	}
	}


