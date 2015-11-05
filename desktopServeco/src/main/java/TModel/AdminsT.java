package TModel;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import BusinessLogic.RemoteAdmin;
import BusinessLogic.RemoteService;
import entities.Admin;
import entities.Categorie;

public class AdminsT extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String [] columTab = {"id","age","firstName","lastName","login","photo","service","Subscribed"};	
	List<Admin> admins =new ArrayList<Admin>();
	RemoteAdmin c=null;
	public AdminsT() {
			Context ctx;
		try {
			ctx = new InitialContext();
			c =  (RemoteAdmin) ctx.lookup("/WebServeco/AdminCrud!BusinessLogic.RemoteAdmin");
		admins=c.findALl();
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return admins.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columTab.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex){
        case 0:
            return admins.get(rowIndex).getId();
        case 1:
        	 return admins.get(rowIndex).getAge();
        case 2:
       	 return admins.get(rowIndex).getFirstName();
        case 3:
       	 return admins.get(rowIndex).getLastName();
        case 4:
       	 return admins.get(rowIndex).getLogin();
        case 5:
          	 return admins.get(rowIndex).getImage();
        case 6:
          	 return admins.get(rowIndex).getService();
        case 7:
          	 return admins.get(rowIndex).isSubs();
           
        default:
              return null;
}

	}
	@Override
	 public String getColumnName(int column) {
	       return  columTab[column];
	    }

	}


