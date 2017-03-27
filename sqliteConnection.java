

import java.awt.Color;
import java.io.File;
import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	
	public static Connection dbConnector() {
		Connection con=null;
		
		File f = new File(Login.dbUrl);
		if (f.exists()){
			try {
			
			
			con = DriverManager.getConnection("jdbc:sqlite:" + Login.dbUrl);
			
			//JOptionPane.showMessageDialog(null, "Connection succesfull to database");
			Login.txtConexiuneLaBaza.setBackground(Color.GREEN);
			Login.txtConexiuneLaBaza.setText("Conexiune la baza de date: DA");
			return con;
			} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e);
			
			
			}
			
			
		} else {
			JOptionPane.showMessageDialog(null, "Nu exista fisier baza de date");
		}
		
		return null;
		

		
		
		
	}
	public static Connection setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		return null;
	}
}
