package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLogic.RemoteSubscription;
import TModel.ServiceT;
import TModel.SubscriptionT;

import javax.swing.JTable;

import entities.SubscriptionAdmin;
import javax.swing.JScrollPane;

public class SubscriptionManagment extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JTable jTable1;
	private javax.swing.JScrollPane jScrollPane2;

	private JPanel contentPane;
	private JTable table;
    private JOptionPane jOptionPane1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubscriptionManagment frame = new SubscriptionManagment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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

	public SubscriptionManagment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

   
        JButton btnHome = new JButton("Home");
        btnHome.setBounds(0, 4, 130, 43);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 btnHomActionPerformed(e);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnHome);
		
		JButton btnManagment = new JButton("Managment");
		btnManagment.setBounds(126, 4, 130, 43);
		btnManagment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnManagmentActionPerformed(e);
			}
		});
		contentPane.add(btnManagment);
		
		JButton btnNewButton = new JButton("Subscriptions Managment");
		btnNewButton.setBounds(253, 4, 195, 43);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnNewtActionPerformed(e);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(612, 4, 112, 43);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnLogOutActionPerformed(e);
			}
		});
		contentPane.add(btnLogOut);
		
		JButton btnServiceManagment = new JButton("Service Managment");
		btnServiceManagment.setBounds(447, 4, 155, 43);
		btnServiceManagment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnSActionPerformed(e);
			}
		});
		contentPane.add(btnServiceManagment);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 535, 257);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new SubscriptionT());
		
		JButton btnNewButton_1 = new JButton("Accept");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  SubscriptionT ct=(SubscriptionT) table.getModel();
					SubscriptionAdmin c=new SubscriptionAdmin();
					 String MailR=ct.getValueAt(table.getSelectedRow(),7).toString();
					 String service=ct.getValueAt(table.getSelectedRow(),1).toString();

					Context ctx2;
					RemoteSubscription s;
				
					try {
						ctx2 = new InitialContext();
						s =  (RemoteSubscription) ctx2.lookup("/WebServeco/subsCrud!BusinessLogic.RemoteSubscription");
						 c.setId(Integer.parseInt(ct.getValueAt(table.getSelectedRow(),0).toString()));
					System.out.println(c.getId());
						 s.accept(c);
				            jOptionPane1.showMessageDialog(null,"Subscription has been accepted");

						   ct.fireTableDataChanged();
					
						   System.out.println(MailR); 
					new UIMail(MailR).setVisible(true);
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(592, 154, 112, 53);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Refuse");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

		        SubscriptionT ct=(SubscriptionT) table.getModel();
				SubscriptionAdmin c=new SubscriptionAdmin();
				 String MailR=ct.getValueAt(table.getSelectedRow(),7).toString();

				Context ctx2;
				RemoteSubscription s;
			
				try {
					ctx2 = new InitialContext();
					s =  (RemoteSubscription) ctx2.lookup("/WebServeco/subsCrud!BusinessLogic.RemoteSubscription");
					 c.setId(Integer.parseInt(ct.getValueAt(table.getSelectedRow(),0).toString()));
				System.out.println(c.getId());
					 s.remove(c);
			            jOptionPane1.showMessageDialog(null,"Subscription has been rejected");

					   ct.deleteRow(table.getSelectedRow());
				//String MailR="radhi.houli@esprit.tn";
					   System.out.println(MailR); 
				new UIMail(MailR).setVisible(true);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
				
			}
		});
		btnNewButton_2.setBounds(592, 281, 112, 69);
		contentPane.add(btnNewButton_2);
		

	
		
	}
}
