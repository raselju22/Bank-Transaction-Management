package com.system.transaction.bank;

import java.sql.*;
import javax.swing.JOptionPane;

public class JavaConnect {

	Connection conn = null;
	
	public static Connection ConnecrDb(){
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Rasel-JU\\workspace\\Bank_Transaction_Management\\bank");
			return conn;
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		return null;
	}
	
}
