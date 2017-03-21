

package testProject4;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LaboratorAnalize extends JPanel {
	private JTextField textField_nume;
	private JTextField textField_prenume;
	private JTextField textField_data;
	private JComboBox comboBox_Doctor;
	private JComboBox comboBox_CNP;
	private JComboBox comboBox_Recoltare;
	private JComboBox comboBox_Analize;
	
	Connection connection = null;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public void fillComboBoxDoctor(){
		try{
			
			String query="select * from Doctori ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Doctor.addItem(rs.getString("NumeSiPrenume"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxCNP(){
		try{
			
			String query="select * from ProgramariAnalize ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_CNP.addItem(rs.getString("CNP"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxRecoltare(){
		try{
			
			String query="select * from Servicii ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Recoltare.addItem(rs.getString("Recoltari"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxAnalize(){
		try{
			
			String query="select * from Servicii ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Analize.addItem(rs.getString("Analize"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public LaboratorAnalize() {
		connection=sqliteConnection.dbConnector();
		setLayout(null);
		
		JLabel lblNewLabel_Analize = new JLabel("LABORATOR ANALIZE");
		lblNewLabel_Analize.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Analize.setBounds(291, 11, 213, 17);
		add(lblNewLabel_Analize);
		
		JLabel lblNewLabel_Doctor = new JLabel("DOCTOR");
		lblNewLabel_Doctor.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Doctor.setBounds(10, 69, 78, 14);
		add(lblNewLabel_Doctor);
		
		JLabel lblNewLabel_cnp = new JLabel("CNP");
		lblNewLabel_cnp.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_cnp.setBounds(10, 111, 46, 14);
		add(lblNewLabel_cnp);
		
		JLabel lblNewLabel_Nume = new JLabel("NUME");
		lblNewLabel_Nume.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Nume.setBounds(10, 154, 46, 14);
		add(lblNewLabel_Nume);
		
		textField_nume = new JTextField();
		textField_nume.setBackground(SystemColor.info);
		textField_nume.setBounds(66, 152, 185, 20);
		add(textField_nume);
		textField_nume.setColumns(10);
		
		JLabel lblNewLabel_Prenume = new JLabel("PRENUME");
		lblNewLabel_Prenume.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Prenume.setBounds(10, 191, 70, 14);
		add(lblNewLabel_Prenume);
		
		textField_prenume = new JTextField();
		textField_prenume.setBackground(SystemColor.info);
		textField_prenume.setBounds(90, 189, 161, 20);
		add(textField_prenume);
		textField_prenume.setColumns(10);
		
		JLabel lblNewLabel_Data = new JLabel("DATA");
		lblNewLabel_Data.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Data.setBounds(10, 228, 46, 14);
		add(lblNewLabel_Data);
		
		textField_data = new JTextField();
		textField_data.setBackground(SystemColor.info);
		textField_data.setBounds(66, 226, 185, 20);
		add(textField_data);
		textField_data.setColumns(10);
		
		JLabel lblNewLabel_analiz = new JLabel("ANALIZE");
		lblNewLabel_analiz.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_analiz.setBounds(10, 257, 70, 14);
		add(lblNewLabel_analiz);
		
		JLabel lblNewLabel_recoltare = new JLabel("RECOLTARE");
		lblNewLabel_recoltare.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_recoltare.setBounds(10, 288, 89, 14);
		add(lblNewLabel_recoltare);
		
		comboBox_Doctor = new JComboBox();
		comboBox_Doctor.setBackground(SystemColor.info);
		comboBox_Doctor.setBounds(79, 67, 172, 20);
		add(comboBox_Doctor);
		
	    comboBox_CNP = new JComboBox();
	    comboBox_CNP.setBackground(SystemColor.info);
	    comboBox_CNP.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try{
					String query="select * from ProgramariAnalize where CNP=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, (String)comboBox_CNP.getSelectedItem());
					ResultSet rs = pst.executeQuery();
					while(rs.next()){
						textField_nume.setText(rs.getString("Nume"));
						textField_prenume.setText(rs.getString("Prenume"));
						textField_data.setText(rs.getString("Data"));
					}
					
					pst.close();
					
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
	    	}
	    });
		comboBox_CNP.setBounds(54, 109, 197, 20);
		add(comboBox_CNP);
		
		comboBox_Recoltare = new JComboBox();
		comboBox_Recoltare.setBackground(SystemColor.info);
		comboBox_Recoltare.setBounds(109, 286, 128, 20);
		add(comboBox_Recoltare);
		
		comboBox_Analize = new JComboBox();
		comboBox_Analize.setBackground(SystemColor.info);
		comboBox_Analize.setBounds(76, 257, 175, 20);
		add(comboBox_Analize);
		
		JButton btnNewButton_RapProg = new JButton("Programari Analize");
		btnNewButton_RapProg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="SELECT Nume, Prenume, Data, Analize, CNP FROM ProgramariAnalize";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_RapProg.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_RapProg.setBounds(278, 328, 172, 23);
		add(btnNewButton_RapProg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 376, 734, 198);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					int row = table.getSelectedRow();
					String Nume_ = (table.getModel().getValueAt(row, 0)).toString();
					
					String query="select * from ProgramariAnalize where Nume='"+Nume_+"'";
					
					PreparedStatement pst = connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					while(rs.next()){
						textField_nume.setText(rs.getString("Nume"));
						textField_prenume.setText(rs.getString("Prenume"));
						textField_data.setText(rs.getString("Data"));
					}
					
					pst.close();
					
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		fillComboBoxDoctor();
		fillComboBoxCNP();
		fillComboBoxRecoltare();
		fillComboBoxAnalize();
	}
}

