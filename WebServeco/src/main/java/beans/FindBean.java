package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import BusinessLogic.SupplierJSFLocal;
import entities.Supplier;


@ManagedBean
 @SessionScoped
public class FindBean {

	
	private Supplier supplier;
	@ManagedProperty(value = "#{searchBean}")
	SearchBean searchBean;
	
	
	
	@EJB
	SupplierJSFLocal jsfLocal;
	
	
	public String doM()
	{
		return "/Pages/supplier/MailW?faces-redirect=true";
	}
	public Supplier getSupplier() {
		System.out.println("searching for...."+searchBean.getNom());
		return jsfLocal.getSupplierS(searchBean.getNom());
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public FindBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchBean getSearchBean() {
		return searchBean;
	}
	public void setSearchBean(SearchBean searchBean) {
		this.searchBean = searchBean;
	}
	
	
	
	
}
