package beans;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;





import entities.Reservation;
import BusinessLogic.ReservationJSFLocal;

@ManagedBean
@SessionScoped
public class ReservationBean {
	
	private DataModel<Reservation> reservationModel=new ListDataModel<>();
	private List<Reservation> reservations=new ArrayList<>();
	
	private Reservation selectRes=null;

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;
	
	@EJB
	ReservationJSFLocal reser;
	
	
	public String doMail()
	{
		selectRes=reservationModel.getRowData();

		return "/Pages/supplier/Mail?faces-redirect=true";
	}
	

	public LoginBean getUserBean() {
		return userBean;
	}

	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}

	public DataModel<Reservation> getReservationModel() {
		reservationModel.setWrappedData(reser.findreservbySupplierName(userBean.getSupplier().getFirstName()));
		return reservationModel;
	}

	public void setReservationModel(DataModel<Reservation> reservationModel) {
		this.reservationModel = reservationModel;
	}

	public List<Reservation> getReservations() {
		
		reservations=reser.findreservbySupplierName(userBean.getSupplier().getFirstName());
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation getSelectRes() {
		return selectRes;
	}

	public void setSelectRes(Reservation selectRes) {
		this.selectRes = selectRes;
	}
	
	
	
	
	
	
}
