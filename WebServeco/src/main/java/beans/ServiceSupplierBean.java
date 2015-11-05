package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import BusinessLogic.SupplierJSFLocal;
import entities.Reservation;
import entities.Supplier;



@ManagedBean
@SessionScoped
public class ServiceSupplierBean  {
	
	private DataModel<Supplier> supplierModel=new ListDataModel<>();
    private List<Supplier> suppliers=new ArrayList<>();
	private Supplier selectService=null;
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;
	
	@EJB
	SupplierJSFLocal serv;
	public String doMail()
	{
		setSelectService(supplierModel.getRowData());

		return "/Pages/supplier/MailW?faces-redirect=true";
	}
	
	public LoginBean getUserBean() {
		return userBean;
	}

	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}

	public DataModel<Supplier> getSupplierModel() {
		supplierModel.setWrappedData(serv.findSupplierByName(userBean.getSupplier().getFirstName()));
		return supplierModel;
	}

	public void setSupplierModel(DataModel<Supplier> supplierModel) {
		this.supplierModel = supplierModel;
	}
public List<Supplier> getSupplier() {
		
		suppliers=serv.findSupplierByName(userBean.getSupplier().getFirstName());
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	
	public Supplier getSelectService() {
		return selectService;
	}

	
	public void setSelectService(Supplier selectService) {
		this.selectService = selectService;
	}
	
	
	
	
	
	
	
	
	
}
