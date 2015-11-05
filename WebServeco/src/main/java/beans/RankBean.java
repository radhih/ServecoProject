package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import BusinessLogic.RankJSFLocal;
import entities.Note;



@ManagedBean
@SessionScoped
public class RankBean {
	
	private DataModel<Note> noteModel=new ListDataModel<>();
	private List<Note> notes = new ArrayList<>() ;
	
	
	private Note selectNot=null;
	
	
	
	

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;
	
	@EJB
	RankJSFLocal not ;

	public LoginBean getUserBean() {
		return userBean;
	}

	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}

	public DataModel<Note> getNoteModel() {
 		noteModel.setWrappedData(not.findAll());
//userBean.getSupplier().getFirstName()
		return noteModel;
	}

	public void setNoteModel(DataModel<Note> noteModel) {
 		this.noteModel = noteModel;
	}
	
	public List<Note> getNotes() {
		
 		notes=not.findAll();
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note getSelectNot() {
		return selectNot;
	}

	public void setSelectNot(Note selectNot) {
		this.selectNot = selectNot;
	}
	
}
