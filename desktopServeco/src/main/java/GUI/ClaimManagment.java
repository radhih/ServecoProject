package GUI;


import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import BusinessLogic.RemoteClaim;
import BusinessLogic.RemoteService;









import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JLabel;

import TModel.ClaimT;
import TModel.ServiceT;
import entities.Categorie;
import entities.Claim;



public class ClaimManagment extends JFrame {


	
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
					ClaimManagment frame = new ClaimManagment();
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
	
	public void actionn(java.awt.event.ActionEvent e){
		this.setVisible(false);
	}
	public void Action(java.awt.event.ActionEvent e)
	{this.setVisible(false);
		new ClaimManagment().setVisible(true);
	}
	public ClaimManagment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(178, 84, 471, 267);
		contentPane.add(scrollPane);
		
	
		
		
		table = new JTable();
		table.setModel(new ClaimT());
		scrollPane.setViewportView(table);
		
		JButton btnDelete = new JButton("Delete Claim");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		        ClaimT ct=(ClaimT) table.getModel();
				Claim c=new Claim();
				
				Context ctx2;
				RemoteClaim s;
				c.setRep(textField.getText());
				try {
					ctx2 = new InitialContext();
					s =  (RemoteClaim) ctx2.lookup("/WebServeco/ClaimCrud!BusinessLogic.RemoteClaim");
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
		btnDelete.setBounds(24, 226, 130, 23);
		contentPane.add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(24, 116, 130, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Answer:");
		lblName.setBounds(24, 91, 46, 14);
		contentPane.add(lblName);
		
		JButton btnAnswer = new JButton("Answer");
		btnAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Claim c=new Claim();
				ClaimT ct=(ClaimT) table.getModel();
				Context ctx;
				RemoteClaim s;
			
				try {
					ctx = new InitialContext();
					s =  (RemoteClaim) ctx.lookup("/WebServeco/ClaimCrud!BusinessLogic.RemoteClaim");
					 c.setId(Integer.parseInt(ct.getValueAt(table.getSelectedRow(),0).toString()));
				System.out.println(ct.getValueAt(table.getSelectedRow(),0).toString());
				Claim claim=s.find(c);
				claim.setRep(textField.getText());
				s.add(claim);
				Action(e);
					
					//c.setId(table.getRowCount()+1);
					 //       ct.addRow(c);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnAnswer.setBounds(24, 173, 113, 23);
		contentPane.add(btnAnswer);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			actionn(e);
			}
		});
		btnGoBack.setBounds(0, 11, 113, 46);
		contentPane.add(btnGoBack);


		
	}
}
