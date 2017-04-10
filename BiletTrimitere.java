
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BiletTrimitere {
	Connection connection = null;
	
	private JTextField textField_NrContract;
	private JTextField textField_CNP;
	private JTextField textField_Nume;
	private JTextField textField_Prenume;
	private JTextField textField_Tara;
	private JTextField txtCasaJudeteanaTimisoara;
	private JTextField textField_Serie;
	private JTextField textField_Numar;
	private JTextField textField_NrRegistru;
	private JTextField textField_DataEmitere;
	private JTextField textField_DataRegistru;
	private JTable table;
	private JComboBox comboBox_Investigatii;
	private JComboBox comboBox_Parafa;
	private JComboBox comboBox_TipAsigurat;
	private JComboBox comboBox_TipPacient;
	private JComboBox comboBox_TipInvestigatie;
	private JComboBox comboBox_DiagnosticInitial;
	private JComboBox comboBox_specialitate;
	
	public void fillComboBoxInvestigatii(){
		try{
			
			String query="select * from Servicii ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Investigatii.addItem(rs.getString("Investigatii"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
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
	
	public void fillComboBoxTipPacient(){
		try{
			
			String query="select * from TipPacient ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_TipPacient.addItem(rs.getString("TipPacient"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxTipInvestigatii(){
		try{
			
			String query="select * from TipInvestigatii ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_TipInvestigatie.addItem(rs.getString("TipInvestigatii"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxDiagnosticInitial(){
		try{
			
			String query="select * from Servicii ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_DiagnosticInitial.addItem(rs.getString("DiagnosticInitial"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxSpecialitate(){
		try{
			
			String query="select * from Servicii ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_specialitate.addItem(rs.getString("Specialitati"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	
	public BiletTrimitere(){
		
		connection=sqliteConnection.dbConnector();
		
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Date Medic"));
		panel_1.setBounds(10, 11, 824, 51);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Parafa *");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 26, 59, 14);
		panel_1.add(lblNewLabel);
		
		comboBox_Parafa = new JComboBox();
		comboBox_Parafa.setBounds(115, 24, 232, 20);
		panel_1.add(comboBox_Parafa);
		
		JLabel lblNewLabel_1 = new JLabel("Numar Contract *");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(436, 26, 102, 14);
		panel_1.add(lblNewLabel_1);
		
		textField_NrContract = new JTextField();
		textField_NrContract.setBounds(582, 24, 232, 20);
		panel_1.add(textField_NrContract);
		textField_NrContract.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder("Date Pacient"));
		panel_2.setBounds(10, 73, 824, 122);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("CNP *");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 25, 46, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nume *");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(10, 50, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prenume *");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(10, 75, 59, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tara origine");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 100, 72, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Casa de Asigurari *");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(435, 25, 117, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tip Asigurat *");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(435, 50, 82, 14);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tip Pacient *");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(435, 75, 72, 14);
		panel_2.add(lblNewLabel_8);
		
		textField_CNP = new JTextField();
		textField_CNP.setBounds(115, 23, 233, 20);
		panel_2.add(textField_CNP);
		textField_CNP.setColumns(10);
		
		textField_Nume = new JTextField();
		textField_Nume.setBounds(115, 48, 233, 20);
		panel_2.add(textField_Nume);
		textField_Nume.setColumns(10);
		
		textField_Tara = new JTextField();
		textField_Tara.setBounds(115, 98, 233, 20);
		panel_2.add(textField_Tara);
		textField_Tara.setColumns(10);
		
		textField_Prenume = new JTextField();
		textField_Prenume.setBounds(115, 73, 233, 20);
		panel_2.add(textField_Prenume);
		textField_Prenume.setColumns(10);
		
		txtCasaJudeteanaTimisoara = new JTextField();
		txtCasaJudeteanaTimisoara.setFont(new Font("Arial", Font.BOLD, 12));
		txtCasaJudeteanaTimisoara.setHorizontalAlignment(SwingConstants.CENTER);
		txtCasaJudeteanaTimisoara.setText("CASA JUDETEANA TIMISOARA");
		txtCasaJudeteanaTimisoara.setBounds(580, 23, 234, 20);
		panel_2.add(txtCasaJudeteanaTimisoara);
		txtCasaJudeteanaTimisoara.setColumns(10);
		
		comboBox_TipAsigurat = new JComboBox();
		comboBox_TipAsigurat.setBounds(580, 48, 234, 20);
		panel_2.add(comboBox_TipAsigurat);
		
		comboBox_TipPacient = new JComboBox();
		comboBox_TipPacient.setBounds(580, 73, 234, 20);
		panel_2.add(comboBox_TipPacient);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(BorderFactory.createTitledBorder("Date Trimitere"));
		panel_3.setBounds(10, 206, 824, 180);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Serie / Numar *");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(10, 25, 96, 14);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("Numar Registru *");
		lblNewLabel_11.setForeground(Color.RED);
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(10, 50, 96, 14);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Diagnostic Initial *");
		lblNewLabel_12.setForeground(Color.RED);
		lblNewLabel_12.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(10, 98, 99, 14);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Specialitate");
		lblNewLabel_13.setForeground(Color.BLACK);
		lblNewLabel_13.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(10, 123, 79, 14);
		panel_3.add(lblNewLabel_13);
		
		textField_Serie = new JTextField();
		textField_Serie.setBounds(117, 23, 86, 20);
		panel_3.add(textField_Serie);
		textField_Serie.setColumns(10);
		
		textField_Numar = new JTextField();
		textField_Numar.setBounds(220, 23, 127, 20);
		panel_3.add(textField_Numar);
		textField_Numar.setColumns(10);
		
		textField_NrRegistru = new JTextField();
		textField_NrRegistru.setBounds(116, 50, 231, 20);
		panel_3.add(textField_NrRegistru);
		textField_NrRegistru.setColumns(10);
		
		comboBox_DiagnosticInitial = new JComboBox();
		comboBox_DiagnosticInitial.setBounds(116, 96, 698, 20);
		panel_3.add(comboBox_DiagnosticInitial);
		
		JLabel lblNewLabel_10 = new JLabel("Data emiterii *");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(436, 14, 79, 14);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_14 = new JLabel("Tip investigatie *");
		lblNewLabel_14.setForeground(Color.RED);
		lblNewLabel_14.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_14.setBounds(436, 39, 96, 14);
		panel_3.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Data Registru");
		lblNewLabel_15.setBounds(436, 71, 79, 14);
		panel_3.add(lblNewLabel_15);
		
		textField_DataEmitere = new JTextField();
		textField_DataEmitere.setBounds(575, 11, 239, 20);
		panel_3.add(textField_DataEmitere);
		textField_DataEmitere.setColumns(10);
		
		comboBox_TipInvestigatie = new JComboBox();
		comboBox_TipInvestigatie.setBounds(575, 36, 239, 20);
		panel_3.add(comboBox_TipInvestigatie);
		
		textField_DataRegistru = new JTextField();
		textField_DataRegistru.setBounds(575, 68, 239, 20);
		panel_3.add(textField_DataRegistru);
		textField_DataRegistru.setColumns(10);
		
		comboBox_specialitate = new JComboBox();
		comboBox_specialitate.setBounds(117, 121, 697, 20);
		panel_3.add(comboBox_specialitate);
		
		JLabel lblNewLabel_16 = new JLabel("Investigatii *");
		lblNewLabel_16.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_16.setForeground(Color.RED);
		lblNewLabel_16.setBounds(10, 148, 79, 14);
		panel_3.add(lblNewLabel_16);
		
		comboBox_Investigatii = new JComboBox();
		comboBox_Investigatii.setBounds(117, 152, 697, 20);
		panel_3.add(comboBox_Investigatii);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(BorderFactory.createTitledBorder("Detalii Investigatii"));
		panel_4.setBounds(10, 387, 824, 190);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		scrollPane.setBounds(10, 30, 804, 100);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					int row = table.getSelectedRow();
					String ID_=(table.getModel().getValueAt(row, 0)).toString();
					
					String query="select * from DetaliiInvestigatii where ID='"+ID_+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					//pst.setString(1, (String) comboBox_Investigatii.getSelectedItem());
					
					ResultSet rs = pst.executeQuery();
					
				/*	while(rs.next()){
					String value = comboBox_Investigatii.getSelectedItem().toString();//
						//pst.setString(1, (String) comboBox_Investigatii.getSelectedItem());
					
					}*/
					
					pst.close();
			
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_Adauga = new JButton("ADAUGA");
		btnNewButton_Adauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="SELECT ID, Investigatii  FROM DetaliiInvestigatii";
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
		
		btnNewButton_Adauga.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Adauga.setBounds(10, 144, 89, 23);
		panel_4.add(btnNewButton_Adauga);
		
		JButton btnNewButton_Modifica = new JButton("MODIFICA");
		btnNewButton_Modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="insert into DetaliiInvestigatii ( Investigatii) values(?)";
					PreparedStatement pst = connection.prepareStatement(query);
		
					String value = comboBox_Investigatii.getSelectedItem().toString();
					pst.setString(1, value);
					
					pst.execute();
					//pst.close();

					
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_Modifica.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Modifica.setForeground(new Color(0, 0, 0));
		btnNewButton_Modifica.setBounds(122, 144, 89, 23);
		panel_4.add(btnNewButton_Modifica);
		
		JButton btnNewButton_Sterge = new JButton("STERGE");
		btnNewButton_Sterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query = "delete from DetaliiInvestigatii where Investigatii=?";
					PreparedStatement pst = connection.prepareStatement(query);

					String value = comboBox_Investigatii.getSelectedItem().toString();
					pst.setString(1, value);
					pst.execute();	
					
				} catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_Sterge.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Sterge.setBounds(236, 144, 89, 23);
		panel_4.add(btnNewButton_Sterge);
		
		JButton btnNewButton_Salveaza = new JButton("SALVEAZA");
		btnNewButton_Salveaza.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Salveaza.setForeground(new Color(0, 0, 0));
		btnNewButton_Salveaza.setBounds(586, 588, 99, 23);
		panel.add(btnNewButton_Salveaza);
		
		JButton btnNewButton_Tipareste = new JButton("TIPARESTE");
		btnNewButton_Tipareste.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Tipareste.setBounds(720, 588, 114, 23);
		panel.add(btnNewButton_Tipareste);
		
		frame.setVisible(true);
		frame.setBounds(100, 100, 860, 660);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		fillComboBoxInvestigatii();
		fillComboBoxParafa();
		fillComboBoxTipAsigurat();
		fillComboBoxTipPacient();
		fillComboBoxTipInvestigatii();
		fillComboBoxDiagnosticInitial();
		fillComboBoxSpecialitate();
	}
}

