package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import TModel.AdminsT;

import javax.swing.JScrollPane;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MangmentAdmins extends JFrame {

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
					MangmentAdmins frame = new MangmentAdmins();
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
	public MangmentAdmins() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 551, 286);
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
		btnServiceManagment.setBounds(447, 4, 155, 43);
		contentPane.add(btnServiceManagment);
	
		JButton btnNewButton_1 = new JButton("Show profil photo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 AdminsT ct= (AdminsT) table.getModel();			
				
				byte[]image=(byte[]) ct.getValueAt(table.getSelectedRow(),5);
				new UIphoto(image).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(571, 95, 126, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Change service");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 AdminsT ct= (AdminsT) table.getModel();			
					
					int id= (int) ct.getValueAt(table.getSelectedRow(),0);
		new UIchangeS(id).setVisible(true);
			}
		});
		btnNewButton_2.setBounds(571, 190, 129, 59);
		contentPane.add(btnNewButton_2);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
