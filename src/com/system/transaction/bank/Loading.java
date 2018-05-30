package com.system.transaction.bank;

import java.sql.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.metal.MetalBorders.PaletteBorder;

public class Loading extends JFrame implements Runnable{

	private Container c;
	private ImageIcon img, img1;
	private JLabel imgLabel, imgLabel1, textLabel, textLabel2, textlabel3;
	private Font f;
	private JProgressBar pBar;
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	int a = 0;
	Thread th;
	private int s;

	public Loading() {

		super("Loading");
		initComponents();
		//conn = JavaConnect.ConnecrDb();
		th = new Thread((Runnable)this);

	}
	
	public void initComponents() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 150, 400, 500);
		this.setTitle("Loading Page");

		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);

		f = new Font("Arial", Font.BOLD, 14);

		img = new ImageIcon(getClass().getResource("images.png"));
		imgLabel = new JLabel(img);
		imgLabel.setBounds(10, 20, img.getIconWidth(), img.getIconHeight());
		c.add(imgLabel);

		pBar = new JProgressBar();
		pBar.setValue(25);
		pBar.setStringPainted(true);
		pBar.setBounds(90, 150, 200, 40);
		c.add(pBar);

		img1 = new ImageIcon(getClass().getResource("download.png"));
		imgLabel1 = new JLabel(img1);
		imgLabel1.setBounds(30, 180, img1.getIconWidth(), img1.getIconHeight());
		c.add(imgLabel1);

		textLabel = new JLabel("The software is version as a secure and trusted site.");
		textLabel.setBounds(50, 310, 300, 100);
		c.add(textLabel);

		textLabel2 = new JLabel("All information sent or received");
		textLabel2.setBounds(100, 330, 300, 100);
		c.add(textLabel2);

		textlabel3 = new JLabel("in encrypted using 256-bit encryption.");
		textlabel3.setBounds(80, 350, 300, 100);
		c.add(textlabel3);
	}

	public static void main(String[] args) {

		Loading frame = new Loading();
		frame.setVisible(true);
	}

	public void setUpLoading() {
		
		setVisible(false);
		th.start();
		
	}
	
	public void run() {
		
		try {
			
			for (int i = 0; i <= 200; i++) {
				
				 s = s+1;
				 int m = pBar.getMaximum();
				 int v = pBar.getValue();
				 
				 if(v<m){
					 
					 pBar.setValue(pBar.getValue()+1);
					 
				 }
				 
				 else {
					
					 i = 201;
					 setVisible(false);
					 MyPage ob = new MyPage();
					 ob.setVisible(true);
				}
				 
				 Thread.sleep(50);
			}
			
		} catch (Exception e) {
			
			
		}
	}

}
