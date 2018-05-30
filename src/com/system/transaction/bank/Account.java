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
import java.util.Date;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Account extends JFrame {

	private JLabel accountNum, micrNo, pin, accountType, gender, address;
	private JLabel answer, name, birthDate, nationality, castle;
	private JLabel mobileNo, sequrity, account;
	private JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8, jtf9, jtf10, jtf11;
	private JButton clear, create, back;
	private JPasswordField pf;
	private Container c;
	private ImageIcon img;
	private JLabel imgLabel;
	private Font f;
	private JComboBox cb, cb1, cb2;
	private JRadioButton male, female;
	private ButtonGroup group;
	private String[] question = {"What is your nick name?","What is your middle maiden name?"};
	private String[] typeOfAcc = {"Select","Saving","Current"};
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	public Account() {

		super("Create Account");
		initComponents();
		conn = JavaConnect.ConnecrDb();

	}

	public void RandomAcc() {

		Random ra = new Random();
		jtf1.setText("" + ra.nextInt(10000 + 1));

	}

	public void RandomMICR() {

		Random ra = new Random();
		jtf2.setText("" + ra.nextInt(10000 + 1));

	}

	public void RandomPIN() {

		Random ra = new Random();
		jtf3.setText("" + ra.nextInt(10000 + 1));

	}

	public void Bal() {

		String sql = "insert into Balance(Name, Acc, MICR_No, Balance)Values(?,?,?,?)";
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, jtf5.getText());
			pst.setString(2, jtf1.getText());
			pst.setString(3, jtf2.getText());
			pst.setString(4, jtf11.getText());
			pst.execute();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void initComponents() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 50, 800, 600);
		this.setTitle("Account");

		f = new Font("Arial", Font.BOLD, 18);

		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);

		img = new ImageIcon(getClass().getResource("images.png"));
		imgLabel = new JLabel(img);
		imgLabel.setBounds(10, 20, img.getIconWidth(), img.getIconHeight());
		c.add(imgLabel);

		accountNum = new JLabel("Account No.");
		accountNum.setBounds(20, 120, 180, 50);
		accountNum.setFont(f);
		c.add(accountNum);

		jtf1 = new JTextField();
		jtf1.setFont(f);
		jtf1.setBounds(150, 130, 200, 30);
		c.add(jtf1);

		micrNo = new JLabel("MICR No.");
		micrNo.setBounds(20, 160, 180, 50);
		micrNo.setFont(f);
		c.add(micrNo);

		jtf2 = new JTextField();
		jtf2.setFont(f);
		jtf2.setBounds(150, 170, 200, 30);
		c.add(jtf2);

		pin = new JLabel("Pin");
		pin.setBounds(20, 200, 180, 50);
		pin.setFont(f);
		c.add(pin);

		jtf3 = new JTextField();
		jtf3.setFont(f);
		jtf3.setBounds(150, 210, 200, 30);
		c.add(jtf3);

		accountType = new JLabel("Account Type");
		accountType.setBounds(20, 240, 180, 50);
		accountType.setFont(f);
		c.add(accountType);

		cb = new JComboBox(typeOfAcc);
		cb.setFont(f);
		cb.setBounds(150, 250, 200, 30);
		cb.setEditable(true);
		c.add(cb);

		gender = new JLabel("Gender");
		gender.setBounds(20, 280, 180, 50);
		gender.setFont(f);
		c.add(gender);

		group = new ButtonGroup();

		male = new JRadioButton("Male");
		male.setBounds(150, 290, 70, 30);
		c.add(male);

		female = new JRadioButton("Female");
		female.setBounds(240, 290, 70, 30);
		c.add(female);

		group.add(male);
		group.add(female);

		address = new JLabel("Address");
		address.setBounds(20, 330, 180, 50);
		address.setFont(f);
		c.add(address);

		jtf4 = new JTextField();
		jtf4.setFont(f);
		jtf4.setBounds(150, 340, 200, 30);
		c.add(jtf4);

		account = new JLabel("Account");
		account.setBounds(20, 370, 180, 50);
		account.setFont(f);
		c.add(account);

		jtf11 = new JTextField();
		jtf11.setFont(f);
		jtf11.setBounds(150, 380, 200, 30);
		c.add(jtf11);

		name = new JLabel("Name");
		name.setBounds(440, 120, 180, 50);
		name.setFont(f);
		c.add(name);

		jtf5 = new JTextField();
		jtf5.setFont(f);
		jtf5.setBounds(560, 130, 200, 30);
		c.add(jtf5);

		birthDate = new JLabel("Date of Birth");
		birthDate.setBounds(440, 160, 180, 50);
		birthDate.setFont(f);
		c.add(birthDate);

		jtf6 = new JTextField();
		jtf6.setFont(f);
		jtf6.setBounds(560, 170, 200, 30);
		c.add(jtf6);

		nationality = new JLabel("Nationality");
		nationality.setBounds(440, 200, 180, 50);
		nationality.setFont(f);
		c.add(nationality);

		cb1 = new JComboBox();
		cb1.setFont(f);
		cb1.setBounds(560, 210, 200, 30);
		cb1.setEditable(true);
		c.add(cb1);

		castle = new JLabel("Castle");
		castle.setBounds(440, 240, 180, 50);
		castle.setFont(f);
		c.add(castle);

		jtf7 = new JTextField();
		jtf7.setFont(f);
		jtf7.setBounds(560, 250, 200, 30);
		c.add(jtf7);

		mobileNo = new JLabel("Mobile");
		mobileNo.setBounds(440, 280, 180, 50);
		mobileNo.setFont(f);
		c.add(mobileNo);

		jtf8 = new JTextField();
		jtf8.setFont(f);
		jtf8.setBounds(560, 290, 200, 30);
		c.add(jtf8);

		sequrity = new JLabel("Sequrity Q.");
		sequrity.setBounds(440, 320, 180, 50);
		sequrity.setFont(f);
		c.add(sequrity);

		cb2 = new JComboBox(question);
		cb2.setBounds(560, 330, 200, 30);
		c.add(cb2);

		answer = new JLabel("Answer");
		answer.setBounds(440, 360, 180, 50);
		answer.setFont(f);
		c.add(answer);

		jtf10 = new JTextField();
		jtf10.setBounds(560, 370, 200, 30);
		jtf10.setFont(f);
		c.add(jtf10);

		create = new JButton("Create");
		create.setBounds(160, 470, 100, 30);
		create.setFont(f);
		c.add(create);

		back = new JButton("Back");
		back.setBounds(320, 470, 100, 30);
		back.setFont(f);
		c.add(back);

	    clear = new JButton("Clear");
		clear.setBounds(480, 470, 100, 30);
		clear.setFont(f);
		c.add(clear);

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jtf5.setText("");
				jtf6.setText("");
				jtf7.setText("");
				jtf8.setText("");
				jtf9.setText("");
				jtf10.setText("");
				jtf11.setText("");

			}
		});

		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String sql = "insert into Account (Acc, Name, DOB, Pin, Acc_Type, Nationality, Castle, MICR_No, Gender, Mob, Address, 'Sec.Q', 'Sec.A', Balance) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				try {

					pst = conn.prepareStatement(sql);
					pst.setString(1, jtf1.getText());
					pst.setString(2, jtf5.getText());
					Object jDateChooser1;
					pst.setString(3, new Date().toString());
					pst.setString(4, jtf3.getText());
					pst.setString(5, (String) cb.getSelectedItem());
					pst.setString(6, (String) cb1.getSelectedItem());
					pst.setString(7, jtf7.getText());
					pst.setString(8, jtf2.getText());

					male.setActionCommand("Male");
					female.setActionCommand("Female");
					
					ButtonGroup buttonGroup1 = new ButtonGroup();
					buttonGroup1.add(male);
					buttonGroup1.add(female);

					String genderCheck = "Male";
					if (female.isSelected()) {
						genderCheck = "FemMale";
					}
					
					pst.setString(9, genderCheck);

					pst.setString(10, jtf8.getText());
					pst.setString(11, jtf4.getText());
					pst.setString(12, (String) cb2.getSelectedItem());
					pst.setString(13, jtf10.getText());
					pst.setString(14, jtf11.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Congretz\nAccount has been created");
					Bal();

				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, e2);
					e2.printStackTrace();
				}
			}
		});
		
		back.addActionListener((e1)->{
			
			Authentication authentication = new Authentication();
			this.setVisible(false);
			authentication.setVisible(true);
			
		});
	}

	public static void main(String[] args) {

		Account frame = new Account();
		frame.setVisible(true);

	}

}
