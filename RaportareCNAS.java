


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class RaportareCNAS 
{
	Connection connection = null;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtCasaJudeteanaTimisoara;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JComboBox comboBox_Parafa;
	private JComboBox comboBox_TipAsigurat;
	private JComboBox comboBox_Diagnostic;
	private JComboBox comboBox_Diagnostic2;
	private JComboBox comboBox_Parafa2;
	
	public void fillComboBoxParafa(){
		try{
			
			String query="select * from Doctori ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Parafa.addItem(rs.getString("NumeSiPrenume"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxTipAsigurat(){
		try{
			
			String query="select * from Asigurati ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_TipAsigurat.addItem(rs.getString("TipAsigurat"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxDiagnostic(){
		try{
			
			String query="select * from Diagnostic ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Diagnostic.addItem(rs.getString("Diagnostice"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxDiagnostic2(){
		try{
			
			String query="select * from Diagnostic ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Diagnostic2.addItem(rs.getString("Diagnostice"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxParafa2(){
		try{
			
			String query="select * from Doctori ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Parafa2.addItem(rs.getString("NumeSiPrenume"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public RaportareCNAS() {
		connection=sqliteConnection.dbConnector();
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Detalii Medic"));
		panel.setMaximumSize(new Dimension(1800, 10000));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Parafa <font color='red'>*</font></html>");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 25, 46, 14);
		panel.add(lblNewLabel_1);
		
		comboBox_Parafa = new JComboBox();
		comboBox_Parafa.setBounds(107, 23, 244, 20);
		panel.add(comboBox_Parafa);
		
		JLabel lblNewLabel = new JLabel("Numar Contract *");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(450, 25, 105, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial", Font.BOLD, 12));
		textField.setText("123456");
		textField.setBounds(572, 23, 250, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(1800, 20000));
		panel_1.setBorder(BorderFactory.createTitledBorder("Detalii Pacient"));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("CNP *");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 22, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 20, 243, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNume = new JLabel("Nume *");
		lblNume.setForeground(Color.RED);
		lblNume.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNume.setBounds(10, 53, 46, 14);
		panel_1.add(lblNume);
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 51, 243, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPrenume = new JLabel("Prenume *");
		lblPrenume.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrenume.setForeground(Color.RED);
		lblPrenume.setBounds(10, 81, 70, 14);
		panel_1.add(lblPrenume);
		
		textField_3 = new JTextField();
		textField_3.setBounds(107, 82, 243, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tara origine");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(10, 115, 70, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(107, 113, 243, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCasaDeAsigurari = new JLabel("Casa de asigurari *");
		lblCasaDeAsigurari.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCasaDeAsigurari.setForeground(Color.RED);
		lblCasaDeAsigurari.setBounds(451, 23, 112, 14);
		panel_1.add(lblCasaDeAsigurari);
		
		txtCasaJudeteanaTimisoara = new JTextField();
		txtCasaJudeteanaTimisoara.setFont(new Font("Arial", Font.BOLD, 12));
		txtCasaJudeteanaTimisoara.setHorizontalAlignment(SwingConstants.CENTER);
		txtCasaJudeteanaTimisoara.setText("CASA JUDETEANA TIMISOARA");
		txtCasaJudeteanaTimisoara.setBounds(573, 20, 243, 20);
		panel_1.add(txtCasaJudeteanaTimisoara);
		txtCasaJudeteanaTimisoara.setColumns(10);
		
		JLabel lblTipSigurat = new JLabel("Tip asigurat *");
		lblTipSigurat.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTipSigurat.setForeground(Color.RED);
		lblTipSigurat.setBounds(451, 54, 91, 14);
		panel_1.add(lblTipSigurat);
		
		comboBox_TipAsigurat = new JComboBox();
		comboBox_TipAsigurat.setBounds(573, 51, 243, 20);
		panel_1.add(comboBox_TipAsigurat);
		
		JLabel lblNewLabel_4 = new JLabel("Cu bilet trimitere");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(451, 88, 101, 14);
		panel_1.add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(573, 81, 22, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_5 = new JLabel("Tip pacient *");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(451, 116, 91, 14);
		panel_1.add(lblNewLabel_5);
		
		JComboBox comboBox_TipPacient = new JComboBox();
		comboBox_TipPacient.setBounds(573, 113, 243, 20);
		panel_1.add(comboBox_TipPacient);
		
		JPanel panel_2 = new JPanel();
		panel_2.setMaximumSize(new Dimension(1800, 22000));
		panel_2.setBorder(BorderFactory.createTitledBorder("Date Bilet de Trimitere"));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Serie/Numar *");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 27, 84, 14);
		panel_2.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(106, 25, 84, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(200, 25, 150, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Data *");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(10, 62, 46, 14);
		panel_2.add(lblNewLabel_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(106, 62, 244, 20);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Diagnostic *");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(10, 98, 72, 14);
		panel_2.add(lblNewLabel_8);
		
		comboBox_Diagnostic = new JComboBox();
		comboBox_Diagnostic.setBounds(106, 96, 715, 20);
		panel_2.add(comboBox_Diagnostic);
		
		JLabel lblNewLabel_9 = new JLabel("Specialitate *");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(10, 128, 72, 14);
		panel_2.add(lblNewLabel_9);
		
		textField_9 = new JTextField();
		textField_9.setBounds(106, 126, 715, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Parafa *");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setBounds(451, 28, 58, 14);
		panel_2.add(lblNewLabel_10);
		
		comboBox_Parafa2 = new JComboBox();
		comboBox_Parafa2.setBounds(576, 25, 245, 20);
		panel_2.add(comboBox_Parafa2);
		
		JLabel lblNewLabel_11 = new JLabel("Numar Contract *");
		lblNewLabel_11.setForeground(Color.RED);
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(451, 63, 108, 14);
		panel_2.add(lblNewLabel_11);
		
		textField_10 = new JTextField();
		textField_10.setBounds(576, 60, 245, 20);
		panel_2.add(textField_10);
		textField_10.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(BorderFactory.createTitledBorder("Detalii Serviciu Paraclinic"));
		panel_3.setPreferredSize(new Dimension(860, 20));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("Data Serviciu *");
		lblNewLabel_12.setForeground(Color.RED);
		lblNewLabel_12.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(10, 22, 80, 14);
		panel_3.add(lblNewLabel_12);
		
		textField_11 = new JTextField();
		textField_11.setBounds(105, 20, 175, 20);
		panel_3.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Urgenta?");
		lblNewLabel_13.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(357, 22, 60, 14);
		panel_3.add(lblNewLabel_13);
		
		JCheckBox chckbxDa = new JCheckBox("DA");
		chckbxDa.setBounds(443, 19, 60, 23);
		panel_3.add(chckbxDa);
		
		JCheckBox chckbxNu = new JCheckBox("NU");
		chckbxNu.setBounds(505, 19, 60, 23);
		panel_3.add(chckbxNu);
		
		JLabel lblNewLabel_14 = new JLabel("De la MF *");
		lblNewLabel_14.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_14.setForeground(Color.RED);
		lblNewLabel_14.setBounds(609, 22, 69, 14);
		panel_3.add(lblNewLabel_14);
		
		JCheckBox chckbxDa_1 = new JCheckBox("DA");
		chckbxDa_1.setBounds(700, 19, 60, 23);
		panel_3.add(chckbxDa_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("NU");
		chckbxNewCheckBox_1.setBounds(774, 19, 53, 23);
		panel_3.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel_15 = new JLabel("Pachet Medical *");
		lblNewLabel_15.setForeground(Color.RED);
		lblNewLabel_15.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_15.setBounds(10, 60, 91, 14);
		panel_3.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Diagnostic *");
		lblNewLabel_16.setForeground(Color.RED);
		lblNewLabel_16.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_16.setBounds(10, 94, 69, 14);
		panel_3.add(lblNewLabel_16);
		
		comboBox_Diagnostic2 = new JComboBox();
		comboBox_Diagnostic2.setBounds(105, 88, 708, 20);
		panel_3.add(comboBox_Diagnostic2);
		
		JLabel lblNewLabel_17 = new JLabel("Investigatie *");
		lblNewLabel_17.setForeground(Color.RED);
		lblNewLabel_17.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_17.setBounds(10, 120, 80, 14);
		panel_3.add(lblNewLabel_17);
		
		JComboBox comboBox_Investigatie = new JComboBox();
		comboBox_Investigatie.setBounds(105, 119, 708, 20);
		panel_3.add(comboBox_Investigatie);
		
		JLabel lblNewLabel_18 = new JLabel("Cantitate *");
		lblNewLabel_18.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_18.setForeground(Color.RED);
		lblNewLabel_18.setBounds(10, 155, 69, 14);
		panel_3.add(lblNewLabel_18);
		
		textField_13 = new JTextField();
		textField_13.setBounds(103, 150, 248, 20);
		panel_3.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblNewLabel_19 = new JLabel("Tarif *");
		lblNewLabel_19.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_19.setForeground(Color.RED);
		lblNewLabel_19.setBounds(458, 155, 46, 14);
		panel_3.add(lblNewLabel_19);
		
		textField_14 = new JTextField();
		textField_14.setBounds(592, 152, 221, 20);
		panel_3.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblNumarFisa = new JLabel("Numar Fisa");
		lblNumarFisa.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumarFisa.setBounds(10, 176, 80, 14);
		panel_3.add(lblNumarFisa);
		
		textField_15 = new JTextField();
		textField_15.setBounds(103, 181, 248, 20);
		panel_3.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("Data Fisa");
		lblNewLabel_20.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_20.setBounds(457, 184, 69, 14);
		panel_3.add(lblNewLabel_20);
		
		textField_16 = new JTextField();
		textField_16.setBounds(592, 181, 221, 20);
		panel_3.add(textField_16);
		textField_16.setColumns(10);
		
		JButton btnNewButton_Salveaza = new JButton("SALVEAZA");
		btnNewButton_Salveaza.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Salveaza.setBounds(245, 217, 106, 23);
		panel_3.add(btnNewButton_Salveaza);
		
		JButton btnNewButton_Tipareste = new JButton("TIPARESTE");
		btnNewButton_Tipareste.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Tipareste.setBounds(700, 212, 113, 23);
		panel_3.add(btnNewButton_Tipareste);
		
		JComboBox comboBox_PachetMedical = new JComboBox();
		comboBox_PachetMedical.setBounds(105, 58, 708, 20);
		panel_3.add(comboBox_PachetMedical);
		frame.setVisible(true);
		frame.setBounds(100, 100, 860, 660);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		fillComboBoxParafa();
		fillComboBoxTipAsigurat();
		fillComboBoxDiagnostic();
		fillComboBoxDiagnostic2();
		fillComboBoxParafa2();
		
	}
	}

