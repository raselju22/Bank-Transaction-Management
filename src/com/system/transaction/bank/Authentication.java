package com.system.transaction.bank;

import java.sql.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.security.auth.login.LoginContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Authentication extends JFrame {

	private JLabel accountNum, pin, authn, imgLabel;
	private JTextField jtf;
	private JPasswordField pf;
	private JButton login, newAccount;
	private Container c;
	private ImageIcon img;
	private Font f;
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	public Authentication() {

		super("Login");
		initComponents();
		conn = JavaConnect.ConnecrDb();
	}

	public void initComponents() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 150, 600, 400);
		this.setTitle("Authentication Frame");

		f = new Font("Arial", Font.BOLD, 18);

		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);

		img = new ImageIcon(getClass().getResource("images.png"));

		imgLabel = new JLabel(img);
		imgLabel.setBounds(10, 30, img.getIconWidth(), img.getIconHeight());
		c.add(imgLabel);

		accountNum = new JLabel("Enter Account No. ");
		accountNum.setBounds(50, 200, 180, 50);
		accountNum.setFont(f);
		c.add(accountNum);

		jtf = new JTextField();
		jtf.setFont(f);
		jtf.setBounds(240, 210, 200, 30);
		c.add(jtf);

		pin = new JLabel("Pin");
		pin.setBounds(90, 250, 180, 50);
		pin.setFont(f);
		c.add(pin);

		pf = new JPasswordField();
		pf.setBounds(240, 260, 200, 30);
		pf.setFont(f);
		c.add(pf);

		login = new JButton("Login");
		login.setBounds(240, 310, 70, 30);
		c.add(login);

		newAccount = new JButton("New Account");
		newAccount.setBounds(320, 310, 120, 30);
		c.add(newAccount);

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from Account where Acc = ? and Pin = ?";
				try {

					pst = conn.prepareStatement(sql);
					pst.setString(1, jtf.getText());
					pst.setString(2, pf.getText());
					rs = pst.executeQuery();

					if (rs.next()) {

						setVisible(false);
						Loading ob = new Loading();
						ob.setUpLoading();
						ob.setVisible(true);
						rs.close();
						pst.close();
					}

					else {

						JOptionPane.showMessageDialog(null, "Incorrect Credential");
					}

				} catch (Exception event) {

					JOptionPane.showMessageDialog(null, event);
				}

				finally {

					try {

						rs.close();
						pst.close();
					}

					catch (Exception event) {

					}
				}

			}
		});
		
		newAccount.addActionListener((e1)->{
			Account account=new Account();
			this.setVisible(false);
			account.setVisible(true);
		});
		
		
	}

	public static void main(String[] args) {

		Authentication frame = new Authentication();
		frame.setVisible(true);

	}

}
