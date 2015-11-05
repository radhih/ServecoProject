package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIphoto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIphoto frame = new UIphoto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void actionB(java.awt.event.ActionEvent e)
	{
		this.setVisible(false);
	}
	/**
	 * Create the frame.
	 */
	public UIphoto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGoBack.setBounds(10, 11, 96, 33);
		contentPane.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(39, 55, 354, 195);
		contentPane.add(lblNewLabel);
	}
	public UIphoto(byte[] image)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(10, 11, 96, 33);
		contentPane.add(btnGoBack);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			actionB(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(39, 55, 354, 195);
		Image i=getToolkit().createImage(image);
		  ImageIcon imageicon=new ImageIcon(i);
		lblNewLabel.setIcon(imageicon);
		contentPane.add(lblNewLabel);	
	}
}
