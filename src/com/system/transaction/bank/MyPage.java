package com.system.transaction.bank;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyPage extends JFrame {

	private JLabel user, date, imgLabel;
	private JTextField jtf1, jtf2;
	private Container c;
	private ImageIcon img;
	private Font f;
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	public MyPage() {

		super("Home");
		initComponents();
		conn = JavaConnect.ConnecrDb();
		
	}
	
	public void initComponents() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 50, 600, 500);
		this.setTitle("MyPage");
		
		f = new Font("Arial", Font.BOLD, 18);

		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);
		
		img = new ImageIcon(getClass().getResource("images.png"));

		imgLabel = new JLabel(img);
		imgLabel.setBounds(10, 30, img.getIconWidth(), img.getIconHeight());
		c.add(imgLabel);
	}

	public static void main(String[] args) {

		MyPage frame = new MyPage();
		frame.setVisible(true);

	}

}
