package TModel;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import BusinessLogic.RemoteAdmin;
import BusinessLogic.RemoteSubscription;
import entities.Categorie;
import entities.SubscriptionAdmin;

public class SubscriptionT extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6172996484316046790L;
	public String [] columTab = {"id","description","login","name","status","service","admin","mail"};	
	List<SubscriptionAdmin> SubAdmins =new ArrayList<SubscriptionAdmin>();
	RemoteSubscription c=null;
	public SubscriptionT() {
			Context ctx;
		try {
			ctx = new InitialContext();
			c = (RemoteSubscription) ctx.lookup("/WebServeco/subsCrud!BusinessLogic.RemoteSubscription");
		SubAdmins=c.findAll();
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return SubAdmins.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columTab.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex){
        case 0:
            return SubAdmins.get(rowIndex).getId();
        case 1:
        	 return SubAdmins.get(rowIndex).getDescription();
        case 2:
       	 return SubAdmins.get(rowIndex).getLogin();
        case 3:
       	 return SubAdmins.get(rowIndex).getName();
        case 4:
       	 return SubAdmins.get(rowIndex).getStatus();
        case 5:
          	 return SubAdmins.get(rowIndex).getServiceAdmin().getName();
        case 6:
          	 return SubAdmins.get(rowIndex).getAdmin().getFirstName();
        case 7:
         	 return SubAdmins.get(rowIndex).getMail();    	 

        default:
              return null;
		}
	}
@Override
	 public String getColumnName(int column) {
	       return  columTab[column];
	    }

	public void addRow(SubscriptionAdmin a) {
        SubAdmins.add(a);
     fireTableRowsInserted(getRowCount() -1, getRowCount() -1);
    //fireTableDataChanged();
     }
       public void deleteRow(int rowIndex) {
         
         SubAdmins.remove(rowIndex);
         
     fireTableDataChanged();
    }

}
