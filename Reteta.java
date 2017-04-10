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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Reteta {
	
	Connection connection = null;
	
	private JTextField textField_NrContract;
	private JTextField textField_CNP;
	private JTextField textField_Nume;
	private JTextField textField_Prenume;
	private JTextField txtCasaDeAsigurari;
	private JTextField textField_RC;
	private JTextField textField_SerieReteta;
	private JTextField textField_NumarReteta;
	private JTextField textField_DataReteta;
	private JTable table;
	private JComboBox comboBox_TipAsigurat;
	private JComboBox comboBox_Parafa;
	private JComboBox comboBox_Diagnostic;
	private JComboBox comboBox_Medicament;
	
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
			
			String query="select * from Servicii ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Diagnostic.addItem(rs.getString("DiagnosticInitial"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxMedicament(){
		try{
			
			String query="select * from Tratament ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Medicament.addItem(rs.getString("Tratamente"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	
	public Reteta() {
		
		connection=sqliteConnection.dbConnector();
	
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("RETETA"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Date Medic"));
		panel_1.setBounds(10, 21, 824, 56);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNumarParafa = new JLabel("Numar Parafa *");
		lblNumarParafa.setForeground(Color.RED);
		lblNumarParafa.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumarParafa.setBounds(10, 27, 87, 14);
		panel_1.add(lblNumarParafa);
		
		JLabel lblNumarContract = new JLabel("Numar Contract *");
		lblNumarContract.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumarContract.setForeground(Color.RED);
		lblNumarContract.setBounds(426, 27, 104, 14);
		panel_1.add(lblNumarContract);
		
		textField_NrContract = new JTextField();
		textField_NrContract.setBounds(551, 25, 263, 20);
		panel_1.add(textField_NrContract);
		textField_NrContract.setColumns(10);
		
		comboBox_Parafa = new JComboBox();
		comboBox_Parafa.setBounds(107, 25, 263, 20);
		panel_1.add(comboBox_Parafa);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder("Date Pacient"));
		panel_2.setBounds(10, 88, 824, 124);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CNP *");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 22, 46, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nume *");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 47, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prenume *");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(10, 72, 59, 14);
		panel_2.add(lblNewLabel_2);
		
		textField_CNP = new JTextField();
		textField_CNP.setBounds(105, 16, 263, 20);
		panel_2.add(textField_CNP);
		textField_CNP.setColumns(10);
		
		textField_Nume = new JTextField();
		textField_Nume.setBounds(105, 45, 263, 20);
		panel_2.add(textField_Nume);
		textField_Nume.setColumns(10);
		
		textField_Prenume = new JTextField();
		textField_Prenume.setBounds(105, 72, 263, 20);
		panel_2.add(textField_Prenume);
		textField_Prenume.setColumns(10);
		
		JLabel lblCasaDeAsigurari = new JLabel("Casa de Asigurari *");
		lblCasaDeAsigurari.setForeground(Color.RED);
		lblCasaDeAsigurari.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCasaDeAsigurari.setBounds(431, 23, 107, 14);
		panel_2.add(lblCasaDeAsigurari);
		
		txtCasaDeAsigurari = new JTextField();
		txtCasaDeAsigurari.setBounds(556, 20, 258, 20);
		panel_2.add(txtCasaDeAsigurari);
		txtCasaDeAsigurari.setColumns(10);
		
		JLabel lblTipAsigurat = new JLabel("Tip Asigurat *");
		lblTipAsigurat.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTipAsigurat.setForeground(Color.RED);
		lblTipAsigurat.setBounds(427, 51, 92, 14);
		panel_2.add(lblTipAsigurat);
		
		JLabel lblNumarPns = new JLabel("Numar PNS");
		lblNumarPns.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumarPns.setBounds(427, 78, 77, 14);
		panel_2.add(lblNumarPns);
		
		JComboBox comboBox_NrPNS = new JComboBox();
		comboBox_NrPNS.setBounds(556, 80, 59, 20);
		panel_2.add(comboBox_NrPNS);
		
		JLabel lblNrFo = new JLabel("Nr FO / RC *");
		lblNrFo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNrFo.setForeground(Color.RED);
		lblNrFo.setBounds(630, 83, 77, 14);
		panel_2.add(lblNrFo);
		
		textField_RC = new JTextField();
		textField_RC.setBounds(715, 80, 99, 20);
		panel_2.add(textField_RC);
		textField_RC.setColumns(10);
		
		comboBox_TipAsigurat = new JComboBox();
		comboBox_TipAsigurat.setBounds(556, 45, 258, 20);
		panel_2.add(comboBox_TipAsigurat);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(BorderFactory.createTitledBorder("Date Reteta"));
		panel_3.setBounds(10, 223, 824, 110);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Serie Reteta *");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 24, 83, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Numar Reteta *");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 52, 93, 14);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Diagnostic *");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(10, 77, 83, 14);
		panel_3.add(lblNewLabel_5);
		
		textField_SerieReteta = new JTextField();
		textField_SerieReteta.setBounds(107, 22, 263, 20);
		panel_3.add(textField_SerieReteta);
		textField_SerieReteta.setColumns(10);
		
		textField_NumarReteta = new JTextField();
		textField_NumarReteta.setBounds(107, 50, 263, 20);
		panel_3.add(textField_NumarReteta);
		textField_NumarReteta.setColumns(10);
		
		comboBox_Diagnostic = new JComboBox();
		comboBox_Diagnostic.setBounds(103, 81, 711, 20);
		panel_3.add(comboBox_Diagnostic);
		
		JLabel lblNewLabel_6 = new JLabel("Data Reteta *");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(430, 25, 83, 14);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tip Reteta *");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(430, 53, 72, 14);
		panel_3.add(lblNewLabel_7);
		
		textField_DataReteta = new JTextField();
		textField_DataReteta.setBounds(557, 18, 257, 20);
		panel_3.add(textField_DataReteta);
		textField_DataReteta.setColumns(10);
		
		JComboBox comboBox_TipReteta = new JComboBox();
		comboBox_TipReteta.setBounds(557, 50, 257, 20);
		panel_3.add(comboBox_TipReteta);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(BorderFactory.createTitledBorder("Date Medicatie"));
		panel_4.setBounds(10, 344, 824, 231);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Compensatie *");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(10, 30, 91, 14);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tip Lista *");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(10, 55, 65, 14);
		panel_4.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Cod Boala *");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setBounds(10, 80, 65, 14);
		panel_4.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Tip Diagnostic *");
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_11.setForeground(Color.RED);
		lblNewLabel_11.setBounds(424, 30, 91, 14);
		panel_4.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Medicament *");
		lblNewLabel_12.setForeground(Color.RED);
		lblNewLabel_12.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(424, 55, 91, 14);
		panel_4.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Cantitate *");
		lblNewLabel_13.setForeground(Color.RED);
		lblNewLabel_13.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(424, 80, 78, 14);
		panel_4.add(lblNewLabel_13);
		
		JComboBox comboBox_Compensatie = new JComboBox();
		comboBox_Compensatie.setBounds(111, 27, 263, 20);
		panel_4.add(comboBox_Compensatie);
		
		JComboBox comboBox_TipLista = new JComboBox();
		comboBox_TipLista.setBounds(111, 52, 263, 20);
		panel_4.add(comboBox_TipLista);
		
		JComboBox comboBox_CodBoala = new JComboBox();
		comboBox_CodBoala.setBounds(111, 77, 263, 20);
		panel_4.add(comboBox_CodBoala);
		
		JComboBox comboBox_TipDiagnostic = new JComboBox();
		comboBox_TipDiagnostic.setBounds(561, 27, 253, 20);
		panel_4.add(comboBox_TipDiagnostic);
		
		comboBox_Medicament = new JComboBox();
		comboBox_Medicament.setBounds(561, 52, 253, 20);
		panel_4.add(comboBox_Medicament);
		
		JComboBox comboBox_Cantitate = new JComboBox();
		comboBox_Cantitate.setBounds(561, 80, 253, 20);
		panel_4.add(comboBox_Cantitate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 804, 63);
		panel_4.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_Adauga = new JButton("Adauga");
		btnNewButton_Adauga.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Adauga.setBounds(10, 197, 89, 23);
		panel_4.add(btnNewButton_Adauga);
		
		JButton btnNewButton_Modifica = new JButton("Modifica");
		btnNewButton_Modifica.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Modifica.setBounds(111, 197, 89, 23);
		panel_4.add(btnNewButton_Modifica);
		
		JButton btnNewButton_Sterge = new JButton("Sterge");
		btnNewButton_Sterge.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Sterge.setBounds(210, 197, 89, 23);
		panel_4.add(btnNewButton_Sterge);
		
		JButton btnNewButton_Tipareste = new JButton("TIPARESTE");
		btnNewButton_Tipareste.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Tipareste.setBounds(723, 577, 111, 23);
		panel.add(btnNewButton_Tipareste);
		
		JButton btnNewButton_Salveaza = new JButton("SALVEAZA");
		btnNewButton_Salveaza.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Salveaza.setBounds(591, 577, 104, 23);
		panel.add(btnNewButton_Salveaza);
		
		frame.setVisible(true);
		frame.setBounds(100, 100, 860, 660);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		fillComboBoxTipAsigurat();
		fillComboBoxParafa();
		fillComboBoxDiagnostic();
		fillComboBoxMedicament();
	}
}
