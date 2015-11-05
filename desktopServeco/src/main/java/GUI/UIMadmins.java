package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import TModel.AdminsT;
import javax.swing.JScrollPane;

public class UIMadmins extends JFrame {
	private JPanel contentPane;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIMadmins frame = new UIMadmins();
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
	public UIMadmins() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 64, 453, 286);
		contentPane.add(scrollPane);
		table = new JTable();
		
		table.setModel(new AdminsT());
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
			btnServiceManagment.setBounds(448, 4, 167, 43);
			contentPane.add(btnServiceManagment);
	}

}
