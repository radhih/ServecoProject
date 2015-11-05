package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Maps {
    JFrame frame = new JFrame();
    JPanel panel;
    JButton btnGoBack;
    BufferedImage image;
    
    public void show(String gps,String a) {
           panel = new JPanel();
           try {
        	 //  String a="Tunis,+Tunisie";
                  image = ImageIO.read(new URL("https://maps.googleapis.com/maps/api/staticmap?size=512x512&maptype=roadmap/&markers=size:mid%7Ccolor:red%CA%7C"+a+",Tunis"));
                  JLabel label = new JLabel(new ImageIcon(image));
                  panel.add(label);
                  frame.add(panel);
                  JButton btnGoBack = new JButton("Go Back");
          		btnGoBack.setBounds(10, 11, 96, 33);
          		panel.add(btnGoBack);
          		btnGoBack.addActionListener(new ActionListener() {
          			public void actionPerformed(ActionEvent e) {
          		frame.setVisible(false);
          			}
          		});
                  frame.pack();
                  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  frame.setLocationRelativeTo(null);
                  frame.setVisible(true);
           } catch (MalformedURLException e) {
                  e.printStackTrace();
           } catch (Exception e) {
                 e.printStackTrace();
           }
    }
    public Maps(String gps,String a){
           // show("6.423601,79.996755","Tunis,+Tunisie");
    	show(gps,a);
    }
public Maps()
{
	
}
    public static void main(String[] args){
          new Maps();
    }}