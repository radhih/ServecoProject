package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import BusinessLogic.RemoteService;



import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import TModel.ServiceT;
import entities.Categorie;



public class ServiceManagment extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4304732471058599857L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceManagment frame = new ServiceManagment();
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
	/**
	 * Create the frame.
	 */
	public ServiceManagment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(302, 84, 405, 238);
		contentPane.add(scrollPane);
		
	
		
		
		table = new JTable();
		table.setModel(new ServiceT());
		scrollPane.setViewportView(table);
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
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		        ServiceT ct=(ServiceT) table.getModel();
				Categorie c=new Categorie();
				
				Context ctx2;
				RemoteService s;
				c.setName(textField.getText());
				try {
					ctx2 = new InitialContext();
					s =  (RemoteService) ctx2.lookup("/WebServeco/ServiceCrud!BusinessLogic.RemoteService");
					 c.setId(Integer.parseInt(ct.getValueAt(table.getSelectedRow(),0).toString()));
				System.out.println(c.getId());
					 s.delete(c);
					
					        ct.deleteRow(table.getSelectedRow());
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDelete.setBounds(327, 333, 165, 23);
		contentPane.add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(113, 144, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAddNewService = new JButton("Add new Service");
		btnAddNewService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Categorie c=new Categorie();
			
				Context ctx;
				RemoteService s;
				c.setName(textField.getText());
				try {
					ctx = new InitialContext();
					s =  (RemoteService) ctx.lookup("/WebServeco/ServiceCrud!BusinessLogic.RemoteService");
					s.add(c);
					ServiceT ct=(ServiceT) table.getModel();
					c.setId(table.getRowCount()+1);
					        ct.addRow(c);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
	
		btnAddNewService.setBounds(99, 224, 113, 29);
		contentPane.add(btnAddNewService);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(26, 147, 46, 14);
		contentPane.add(lblName);
		
	}
}
