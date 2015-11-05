package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Admin;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import TModel.AccidentT;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIaccident extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIaccident frame = new UIaccident();
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
	public void actionBack(java.awt.event.ActionEvent e)
	{
		this.setVisible(false);
	}
	public UIaccident() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 61, 501, 272);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Handle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(586, 179, 124, 75);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
	}
	public UIaccident(final Admin a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 61, 501, 272);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new AccidentT(a));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Handle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 AccidentT ct=(AccidentT) table.getModel();
			int id =(int) ct.getValueAt(table.getSelectedRow(),2);
			new UIhandle(id,a).setVisible(true);
			}
		});
		btnNewButton.setBounds(586, 179, 124, 75);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionBack(e);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
	}
}
