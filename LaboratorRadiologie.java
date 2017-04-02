


import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LaboratorRadiologie extends JPanel {
	private JTextField text_Cauta;
	private JTextField text_Nume;
	private JTextField text_Prenume;
	private JTextField text_Data;
	private JComboBox comboBox_DoctorRadiologie;
	private JComboBox comboBox_Radiologie;

	/**
	 * Create the panel.
	 */
	Connection connection = null;
	private JTable table;
	
	public void fillComboBoxDoctor(){
		try{
			
			String query="select * from Doctori ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_DoctorRadiologie.addItem(rs.getString("NumeSiPrenume"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	public void fillComboBoxRadiologie(){
		try{
			
			String query="select * from Servicii ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Radiologie.addItem(rs.getString("Radiologie"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	public LaboratorRadiologie() {
		connection=sqliteConnection.dbConnector();
		setLayout(null);
		
		JLabel lblNewLabel_LabRadiologie = new JLabel("LABORATOR RADIOLOGIE");
		lblNewLabel_LabRadiologie.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_LabRadiologie.setBounds(311, 22, 208, 20);
		add(lblNewLabel_LabRadiologie);
		
		JLabel lblNewLabel = new JLabel("DOCTOR");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 90, 69, 14);
		add(lblNewLabel);
		
	    comboBox_DoctorRadiologie = new JComboBox();
		comboBox_DoctorRadiologie.setBounds(89, 88, 235, 20);
		add(comboBox_DoctorRadiologie);
		
		JLabel lblNewLabel_1 = new JLabel("CAUTA CNP");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 134, 79, 14);
		add(lblNewLabel_1);
		
		text_Cauta = new JTextField();
		text_Cauta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					String query = "select * from ProgramariRadiologie where CNP=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, text_Cauta.getText());
					ResultSet rs = pst.executeQuery();
					if(rs.next()){
					String add1 = rs.getString("Nume");
					text_Nume.setText(add1);
					String add2 = rs.getString("Prenume");
					text_Prenume.setText(add2);
					String add3 = rs.getString("Data");
					text_Data.setText(add3);
			
					
					}
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		
		text_Cauta.setBackground(SystemColor.info);
		text_Cauta.setFont(new Font("Arial", Font.PLAIN, 12));
		text_Cauta.setBounds(99, 131, 225, 20);
		add(text_Cauta);
		text_Cauta.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NUME");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 175, 52, 14);
		add(lblNewLabel_2);
		
		text_Nume = new JTextField();
		text_Nume.setFont(new Font("Arial", Font.PLAIN, 12));
		text_Nume.setBackground(SystemColor.info);
		text_Nume.setBounds(59, 172, 265, 20);
		add(text_Nume);
		text_Nume.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PRENUME");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 214, 79, 14);
		add(lblNewLabel_3);
		
		text_Prenume = new JTextField();
		text_Prenume.setFont(new Font("Arial", Font.PLAIN, 12));
		text_Prenume.setBackground(SystemColor.info);
		text_Prenume.setBounds(89, 211, 235, 20);
		add(text_Prenume);
		text_Prenume.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DATA/ORA");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 257, 79, 14);
		add(lblNewLabel_4);
		
		text_Data = new JTextField();
		text_Data.setFont(new Font("Arial", Font.PLAIN, 12));
		text_Data.setBackground(SystemColor.info);
		text_Data.setBounds(89, 255, 235, 20);
		add(text_Data);
		text_Data.setColumns(10);
		
		comboBox_Radiologie = new JComboBox();
		comboBox_Radiologie.setBounds(116, 307, 208, 20);
		add(comboBox_Radiologie);
		
		JLabel lblNewLabel_5 = new JLabel("INVESTIGATII");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 309, 98, 14);
		add(lblNewLabel_5);
		
		JButton btnNewButton_CNAS = new JButton("RAPORTARE CNAS");
		btnNewButton_CNAS.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_CNAS.setBounds(547, 87, 187, 61);
		add(btnNewButton_CNAS);
		
		JButton btnNewButton_RezImagine = new JButton("REZULTATE IMAGINE");
		btnNewButton_RezImagine.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_RezImagine.setBounds(547, 209, 187, 25);
		add(btnNewButton_RezImagine);
		
		JButton btnNewButton_Tiparire = new JButton("TIPARESTE IMAGINE");
		btnNewButton_Tiparire.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Tiparire.setBounds(547, 269, 187, 23);
		add(btnNewButton_Tiparire);
		
		JButton btnNewButton_radiologie = new JButton("PROGRAMARI RADIOLOGIE");
		btnNewButton_radiologie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String query="SELECT Nume, Prenume, Data, Radiologie, CNP FROM ProgramariRadiologie";
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
		btnNewButton_radiologie.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_radiologie.setBounds(259, 361, 225, 23);
		add(btnNewButton_radiologie);
		
		JButton btnNewButton = new JButton("INAPOI");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(36, 587, 89, 23);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(20, 395, 794, 170);
		add(scrollPane);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int row = table.getSelectedRow();
					String Nume_ = (table.getModel().getValueAt(row, 0)).toString();
					
					String query="select * from ProgramariRadiologie where Nume='"+Nume_+"'";
					
					PreparedStatement pst = connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					while(rs.next()){
						text_Nume.setText(rs.getString("Nume"));
						text_Prenume.setText(rs.getString("Prenume"));
						text_Data.setText(rs.getString("Data"));
					}
					
					pst.close();
					
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
				
			
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_Clear = new JButton("CLEAR");
		btnNewButton_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text_Cauta.setText("");
				text_Nume.setText("");
				text_Prenume.setText("");
				text_Data.setText("");
				
			}
		});
		btnNewButton_Clear.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Clear.setBounds(706, 588, 89, 23);
		add(btnNewButton_Clear);
		fillComboBoxDoctor();
		fillComboBoxRadiologie();

	}
}
