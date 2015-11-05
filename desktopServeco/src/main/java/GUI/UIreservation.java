package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;









import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import service.BillsPdf;
import entities.Reservation;
import BusinessLogic.RemoteReserv;
import TModel.ReservT;






public class UIreservation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 350718599963779829L;
	/**
	 * 
	 */

	private JPanel contentPane;
	private JTable table;
    private javax.swing.JOptionPane jOptionPane1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIreservation frame = new UIreservation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void  btnSActionPerformed(java.awt.event.ActionEvent e)
	{
		this.setVisible(false);
	 new ServiceManagment().setVisible(true);
		
	}
	public void btnNewtActionPerformed(java.awt.event.ActionEvent e)
	{
	this.setVisible(false);
	new SubscriptionManagment().setVisible(true);
	}
	public void BtnManagmentActionPerformed(java.awt.event.ActionEvent e)
	{
		this.setVisible(false);
		new MangmentAdmins().setVisible(true);
	}
	public void btnHomActionPerformed(java.awt.event.ActionEvent e)
	 {	this.setVisible(false);
		 new SuperM().setVisible(true);
	 }
	public void btnLogOutActionPerformed(java.awt.event.ActionEvent e)
	 {
		 this.setVisible(false);
		 new Authentification().setVisible(true);
	 }
	public UIreservation() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnHomActionPerformed(e);
			}
		});
		btnHome.setBounds(0, 4, 130, 43);
		contentPane.add(btnHome);
		
		JButton btnManagment = new JButton("Managment");
		btnManagment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnManagmentActionPerformed(e);
			}
		});
		btnManagment.setBounds(126, 4, 130, 43);
		contentPane.add(btnManagment);
		
		JButton btnNewButton = new JButton("Subscriptions Managment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnNewtActionPerformed(e);
			}
		});
		btnNewButton.setBounds(253, 4, 195, 43);
		contentPane.add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnLogOutActionPerformed(e);
			}
		});
		btnLogOut.setBounds(612, 4, 112, 43);
		contentPane.add(btnLogOut);
		
		JButton btnServiceManagment = new JButton("Service Managment");
		btnServiceManagment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnSActionPerformed(e);
			}
		});
		btnServiceManagment.setBounds(447, 4, 155, 43);
		contentPane.add(btnServiceManagment);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 532, 243);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new ReservT());
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ReservT ct=(ReservT) table.getModel();	
					RemoteReserv cc;
					Context ctx2;
				int id;
				boolean bool;
				Reservation r=new Reservation();
				try {
					
					ctx2 = new InitialContext();
					cc =  (RemoteReserv) ctx2.lookup("/WebServeco/ReservCrud!BusinessLogic.RemoteReserv");
					id=Integer.parseInt(ct.getValueAt(table.getSelectedRow(),0).toString());
			bool=(boolean) ct.getValueAt(table.getSelectedRow(),3);
					cc.accpet(id);
					r=cc.findById(id);
					// ct.deleteRow(table.getSelectedRow());
				if(bool)
				{
					jOptionPane1.showMessageDialog(null,"This reservation is already accepted !!! ");

				}else
				{new UIBill(r).setVisible(true);}
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(562, 172, 142, 58);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Export Bills as pdf file");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BillsPdf pdf=new BillsPdf();
				jOptionPane1.showMessageDialog(null,"pdf file exported with success under D: !!! ");

			
			}
		});
		btnNewButton_3.setBounds(565, 274, 139, 57);
		contentPane.add(btnNewButton_3);
		
		
		
	}
}
