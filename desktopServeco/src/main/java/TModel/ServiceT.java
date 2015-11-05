package TModel;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import BusinessLogic.IAuth;
import BusinessLogic.RemoteService;
import entities.Categorie;

public class ServiceT extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1038617686501954092L;
	public String [] columTab = {"id","name"};	
	List<Categorie> categories =new ArrayList<Categorie>();
	RemoteService c=null;
	public ServiceT() {
			Context ctx;
		try {
			ctx = new InitialContext();
			c =  (RemoteService) ctx.lookup("/WebServeco/ServiceCrud!BusinessLogic.RemoteService");
		categories=c.afficher();
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return categories.size();
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
            return categories.get(rowIndex).getId();
        case 1:
        	 return categories.get(rowIndex).getName();
default:
              return null;
}

	}
	
	 public String getColumnName(int column) {
	       return  columTab[column];
	    }

	public void addRow(Categorie a) {
        categories.add(a);
     fireTableRowsInserted(getRowCount() -1, getRowCount() -1);
    //fireTableDataChanged();
     }
       public void deleteRow(int rowIndex) {
         
          categories.remove(rowIndex);
         
     fireTableDataChanged();
    }

	
}
