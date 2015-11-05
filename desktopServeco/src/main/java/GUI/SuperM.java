package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JTextField;

import org.jfree.ui.RefineryUtilities;

import service.BarChart3DDemo3;
import entities.SuperAdmin;
import BusinessLogic.RemoteSuperAdmin;

public class SuperM extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperM frame = new SuperM();
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
	public void actionR(java.awt.event.ActionEvent e)
	{
		this.setVisible(false);
		new UIreservation().setVisible(true);
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
	public SuperM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 795, 402);
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
		btnHome.setBounds(0, 4, 91, 43);
		contentPane.add(btnHome);
		
		JButton btnManagment = new JButton("Managment");
		btnManagment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnManagmentActionPerformed(e);
			}
		});
		btnManagment.setBounds(95, 4, 112, 43);
		contentPane.add(btnManagment);
		
		JButton btnNewButton = new JButton("Subscriptions Managment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnNewtActionPerformed(e);
			}
		});
		btnNewButton.setBounds(207, 4, 155, 43);
		contentPane.add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnLogOutActionPerformed(e);
			}
		});
		btnLogOut.setBounds(667, 4, 112, 43);
		contentPane.add(btnLogOut);
		
		JButton btnServiceManagment = new JButton("Service");
		btnServiceManagment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnSActionPerformed(e);
			}
		});
		btnServiceManagment.setBounds(445, 4, 98, 43);
		contentPane.add(btnServiceManagment);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 44, 464, 317);
		label.setIcon(new javax.swing.ImageIcon("C:\\a.png"));
		
		
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(478, 44, 291, 317);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personal Details");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 17));
		lblNewLabel.setBounds(49, 5, 197, 86);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(49, 117, 104, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(49, 167, 104, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(49, 221, 104, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(49, 277, 104, 29);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField.setEditable(false);
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		
		SuperAdmin a=new SuperAdmin();
		RemoteSuperAdmin r;
		Context ctx;
		try {
			ctx = new InitialContext();
			r = (RemoteSuperAdmin) ctx.lookup("/WebServeco/SuperAdm!BusinessLogic.RemoteSuperAdmin");
			
		
			a=r.find();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		textField.setText(a.getFirstName());
		textField_1.setText(a.getLastName());;
		textField_2.setText(a.getMail());;
		textField_3.setText(a.getPhoneNumbe());
		
		JButton btnNewButton_1 = new JButton("STATS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			        BarChart3DDemo3 demo = null;
					try {
						demo = new BarChart3DDemo3("Test de la couverture ");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        demo.pack();
			        RefineryUtilities.centerFrameOnScreen(demo);
			        demo.setVisible(true);
			 

		     
			
			}
		});
		btnNewButton_1.setBounds(192, 39, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnVehiculs = new JButton("Vehiculs");
		btnVehiculs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Vehication().setVisible(true);
			}
		});
		btnVehiculs.setBounds(362, 4, 84, 43);
		contentPane.add(btnVehiculs);
		
		JButton btnReservations = new JButton("Reservations");
		btnReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionR(e);
			}
		});
		btnReservations.setBounds(545, 4, 122, 43);
		contentPane.add(btnReservations);;
		
		
	}
}
