package TModel;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import BusinessLogic.RemoteClaim;
import entities.Claim;

public class ClaimT extends AbstractTableModel{

	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2388674823714912587L;
	public String [] columTab = {"id","Reponse","Topic"};	
	List<Claim> claims =new ArrayList<Claim>();
	RemoteClaim c=null;

	public ClaimT() {
		Context ctx;

		try {
			ctx = new InitialContext();
			c =  (RemoteClaim) ctx.lookup("/WebServeco/ClaimCrud!BusinessLogic.RemoteClaim");
			claims= c.affich() ;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
	
}
	
	@Override
	public int getRowCount() {
		return claims.size();
	}

	@Override
	public int getColumnCount() {
		return columTab.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex){
        case 0:
            return claims.get(rowIndex).getId();
        case 1:
        	 return claims.get(rowIndex).getRep();
        case 2:
        	 return claims.get(rowIndex).getTopic();
        
default:
              return null;
}
	}
	public String getColumnName(int column) {
	       return  columTab[column];
	    }
	
	public void deleteRow(int rowIndex) {
        
        claims.remove(rowIndex);
       
   fireTableDataChanged();
  }
	
	public void addRow(Claim a) {
        claims.add(a);
     fireTableRowsInserted(getRowCount() -1, getRowCount() -1);
    //fireTableDataChanged();
     }

}
