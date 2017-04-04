

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Cabinete extends JPanel {
	private JTextField textCautaCNP;
	private JTextField textNume;
	private JTextField textPrenume;

	/**
	 * Create the panel.
	 */
	Connection connection = null;
	private JTextField textData;
	private JTextField textCautaCNP2;
	private JTextField textNume2;
	private JTextField textPrenume2;
	private JTextField textData2;
	private JTable table;
	private JTable table_1;
	private JComboBox comboBox_Doctor;
	private JComboBox comboBox_Diagnostic;
	private JComboBox comboBox_Tratament;
	private JComboBox comboBox_Analize;
	private JComboBox comboBox_Radiologie;
	private JComboBox comboBox_DoctorP;
	private JComboBox comboBox_DiagnosticP;
	private JComboBox comboBox_TratamentP;
	private JComboBox comboBox_AnalizeP;
	private JComboBox comboBox_RadiologieP;
	
	public void fillComboBoxDoctorMG(){
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
	

	public void fillComboBoxDoctorP(){
		try{
			
			String query="select * from Doctori ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_DoctorP.addItem(rs.getString("NumeSiPrenume"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxDiagnosticMG(){
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
	
	public void fillComboBoxDiagnosticP(){
		try{
			
			String query="select * from Diagnostic ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_DiagnosticP.addItem(rs.getString("Diagnostice"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxTratamentMG(){
		try{
			
			String query="select * from Tratament ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_Tratament.addItem(rs.getString("Tratamente"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxTratamentP(){
		try{
			
			String query="select * from Tratament ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_TratamentP.addItem(rs.getString("Tratamente"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxAnalizeMG(){
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
	
	public void fillComboBoxAnalizeP(){
		try{
			
			String query="select * from Servicii ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_AnalizeP.addItem(rs.getString("Analize"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	

	public void fillComboBoxRadiologieMG(){
		try{
			
			String query="select * from Servicii ";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				comboBox_RadiologieP.addItem(rs.getString("Radiologie"));
				
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public void fillComboBoxRadiologieP(){
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
	
	public Cabinete() {
		connection=sqliteConnection.dbConnector();
		setLayout(null);
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 21, 876, 639);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Medicina Generala", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblCnpCautare = new JLabel("Cauta CNP");
		lblCnpCautare.setFont(new Font("Arial", Font.BOLD, 14));
		lblCnpCautare.setBounds(10, 134, 80, 14);
		panel.add(lblCnpCautare);
		
		textCautaCNP = new JTextField();
		textCautaCNP.setBackground(SystemColor.info);
		textCautaCNP.setBounds(91, 132, 215, 20);
		panel.add(textCautaCNP);
		textCautaCNP.setColumns(10);
		
		JButton btnCautare = new JButton("Cautare");
		btnCautare.setFont(new Font("Arial", Font.BOLD, 12));
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "select * from MedicinaGenerala where CNP=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textCautaCNP.getText());
					ResultSet rs = pst.executeQuery();
					//String cabinet = rs.getString("Cabinet");
					
					if(rs.next()){
						String add1 = rs.getString("Nume");
						textNume.setText(add1);
						String add2 = rs.getString("Prenume");
						textPrenume.setText(add2);
						String add4 = rs.getString("Data");
						textData.setText(add4);
						
					} else{
						JOptionPane.showMessageDialog(null, "Pacientul cu CNP-ul introdus nu exista sau nu are programare!");
					}
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnCautare.setBounds(318, 130, 89, 23);
		panel.add(btnCautare);
		
		JLabel lblNume = new JLabel("NUME");
		lblNume.setFont(new Font("Arial", Font.BOLD, 14));
		lblNume.setBounds(10, 188, 55, 14);
		panel.add(lblNume);
		
		textNume = new JTextField();
		textNume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNume.setColumns(10);
		textNume.setBackground(SystemColor.info);
		textNume.setBounds(60, 182, 246, 20);
		panel.add(textNume);
		
		JLabel lblPrenume = new JLabel("PRENUME");
		lblPrenume.setFont(new Font("Arial", Font.BOLD, 14));
		lblPrenume.setBounds(10, 228, 80, 14);
		panel.add(lblPrenume);
		
		textPrenume = new JTextField();
		textPrenume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPrenume.setColumns(10);
		textPrenume.setBackground(SystemColor.info);
		textPrenume.setBounds(91, 225, 215, 20);
		panel.add(textPrenume);
		
		JLabel lblDiagnostic = new JLabel("Diagnostic");
		lblDiagnostic.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiagnostic.setBounds(516, 131, 81, 20);
		panel.add(lblDiagnostic);
		
		JLabel lblTratament = new JLabel("Tratament");
		lblTratament.setFont(new Font("Arial", Font.BOLD, 14));
		lblTratament.setBounds(516, 162, 80, 23);
		panel.add(lblTratament);
		
		JButton btnInapoi = new JButton("INAPOI");
		btnInapoi.setFont(new Font("Arial", Font.BOLD, 14));
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelOptions options = new PanelOptions();
				Login.frame.setContentPane(options);
				Login.frame.invalidate();
				Login.frame.validate();
			}
		});
		btnInapoi.setBounds(41, 539, 114, 23);
		panel.add(btnInapoi);
		
		JLabel lblDoctor = new JLabel("DOCTOR");
		lblDoctor.setFont(new Font("Arial", Font.BOLD, 14));
		lblDoctor.setBounds(10, 63, 68, 20);
		panel.add(lblDoctor);
		
		JLabel lblDataora = new JLabel("DATA/ORA");
		lblDataora.setFont(new Font("Arial", Font.BOLD, 14));
		lblDataora.setBounds(10, 265, 70, 23);
		panel.add(lblDataora);
		
		textData = new JTextField();
		textData.setBackground(SystemColor.info);
		textData.setBounds(91, 267, 215, 21);
		panel.add(textData);
		textData.setColumns(10);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCautaCNP.setText("");
				textNume.setText("");
				textPrenume.setText("");
				textData.setText("");
			}
		});
		btnClear.setFont(new Font("Arial", Font.BOLD, 14));
		btnClear.setBounds(696, 539, 114, 23);
		panel.add(btnClear);
		
		JLabel lblAnalize = new JLabel("Analize");
		lblAnalize.setFont(new Font("Arial", Font.BOLD, 14));
		lblAnalize.setBounds(541, 254, 68, 14);
		panel.add(lblAnalize);
		
		JButton btnSalveaza = new JButton("SALVEAZA");
		btnSalveaza.setFont(new Font("Arial", Font.BOLD, 14));
		btnSalveaza.setBounds(358, 539, 114, 23);
		panel.add(btnSalveaza);
		
		comboBox_Doctor = new JComboBox();
		comboBox_Doctor.setBounds(80, 64, 226, 20);
		panel.add(comboBox_Doctor);
		
		JButton btnNewButton_4 = new JButton("RAPORTARE CNAS");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RaportareCNAS s = new RaportareCNAS();
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4.setBounds(625, 28, 185, 59);
		panel.add(btnNewButton_4);
		
		comboBox_Diagnostic = new JComboBox();
		comboBox_Diagnostic.setBounds(602, 133, 208, 20);
		panel.add(comboBox_Diagnostic);
		
		comboBox_Tratament = new JComboBox();
		comboBox_Tratament.setBounds(597, 164, 213, 20);
		panel.add(comboBox_Tratament);
		
		JButton btnNewButton_5 = new JButton("Genereaza Reteta");
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_5.setBounds(659, 206, 146, 23);
		panel.add(btnNewButton_5);
		
		comboBox_Analize = new JComboBox();
		comboBox_Analize.setBounds(602, 252, 212, 20);
		panel.add(comboBox_Analize);
		
		JLabel lblNewLabel = new JLabel("Radiologie");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(516, 289, 89, 14);
		panel.add(lblNewLabel);
		
		comboBox_Radiologie = new JComboBox();
		comboBox_Radiologie.setBounds(602, 287, 208, 20);
		panel.add(comboBox_Radiologie);
		
		JButton btnNewButton_6 = new JButton("Genereaza Trimitere");
		btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_6.setBounds(657, 332, 153, 23);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Programari Medicina Generala");
		btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_7.setBounds(278, 366, 208, 23);
		panel.add(btnNewButton_7);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 409, 790, 119);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Pediatrie", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		JLabel lblCnpCautare2 = new JLabel("Cauta CNP");
		lblCnpCautare2.setBounds(0, 138, 85, 14);
		lblCnpCautare2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblCnpCautare2);
		
		textCautaCNP2 = new JTextField();
		textCautaCNP2.setBackground(SystemColor.info);
		textCautaCNP2.setBounds(77, 136, 215, 20);
		textCautaCNP2.setColumns(10);
		panel_1.add(textCautaCNP2);
		
		JButton btnCautare2 = new JButton("Cautare");
		btnCautare2.setFont(new Font("Arial", Font.BOLD, 12));
		btnCautare2.setBounds(302, 134, 89, 23);
		btnCautare2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from Pediatrie where CNP=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textCautaCNP2.getText());
					ResultSet rs = pst.executeQuery();
					//String cabinet = rs.getString("Cabinet");
					
					if(rs.next()){
						String add1_2 = rs.getString("Nume");
						textNume2.setText(add1_2);
						String add2_2 = rs.getString("Prenume");
						textPrenume2.setText(add2_2);
						String add4_2 = rs.getString("Data");
						textData2.setText(add4_2);
						
					} else{
						JOptionPane.showMessageDialog(null, "Pacientul cu CNP-ul introdus nu exista sau nu are programare!");
					}
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		panel_1.add(btnCautare2);
		
		JLabel lblNume2 = new JLabel("NUME");
		lblNume2.setBounds(5, 189, 55, 14);
		lblNume2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblNume2);
		
		textNume2 = new JTextField();
		textNume2.setBounds(59, 186, 239, 20);
		textNume2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNume2.setColumns(10);
		textNume2.setBackground(SystemColor.info);
		panel_1.add(textNume2);
		
		JLabel lblPrenume2 = new JLabel("PRENUME");
		lblPrenume2.setBounds(5, 231, 80, 14);
		lblPrenume2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblPrenume2);
		
		textPrenume2 = new JTextField();
		textPrenume2.setBounds(81, 228, 215, 20);
		textPrenume2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPrenume2.setColumns(10);
		textPrenume2.setBackground(SystemColor.info);
		panel_1.add(textPrenume2);
		
		JLabel lblDiagnotic2 = new JLabel("Diagnostic");
		lblDiagnotic2.setBounds(517, 135, 81, 20);
		lblDiagnotic2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblDiagnotic2);
		
		JLabel lblTratament2 = new JLabel("Tratament");
		lblTratament2.setBounds(517, 166, 80, 23);
		lblTratament2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblTratament2);
		
		JButton btnInapoi2 = new JButton("INAPOI");
		btnInapoi2.setFont(new Font("Arial", Font.BOLD, 14));
		btnInapoi2.setBounds(46, 548, 114, 23);
		btnInapoi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelOptions options2 = new PanelOptions();
				Login.frame.setContentPane(options2);
				Login.frame.invalidate();
				Login.frame.validate();
			}
		});
		panel_1.add(btnInapoi2);
		
		JLabel lblDoctor2 = new JLabel("DOCTOR");
		lblDoctor2.setBounds(7, 74, 68, 20);
		lblDoctor2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblDoctor2);
		
		JLabel lblDataora2 = new JLabel("DATA/ORA");
		lblDataora2.setBounds(5, 268, 70, 23);
		lblDataora2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblDataora2);
		
		textData2 = new JTextField();
		textData2.setBounds(89, 270, 209, 21);
		textData2.setColumns(10);
		textData2.setBackground(SystemColor.info);
		panel_1.add(textData2);
		
		JButton btnClear2 = new JButton("CLEAR");
		btnClear2.setBounds(688, 547, 114, 23);
		btnClear2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textCautaCNP2.setText("");
				textNume2.setText("");
				textPrenume2.setText("");
				textData2.setText("");
			}
		});
		btnClear2.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(btnClear2);
		
		JLabel lblLaborator = new JLabel("Analize");
		lblLaborator.setBounds(530, 258, 68, 14);
		lblLaborator.setFont(new Font("Arial", Font.BOLD, 14));
		panel_1.add(lblLaborator);
		
		comboBox_DoctorP = new JComboBox();
		comboBox_DoctorP.setBounds(77, 75, 215, 20);
		panel_1.add(comboBox_DoctorP);
		
		JButton btnNewButton = new JButton("Programari Pediatrie");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(322, 375, 155, 23);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 409, 787, 128);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("RAPORTARE CNAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RaportareCNAS s = new RaportareCNAS();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBounds(628, 35, 185, 59);
		panel_1.add(btnNewButton_1);
		
		comboBox_DiagnosticP = new JComboBox();
		comboBox_DiagnosticP.setBounds(608, 136, 202, 20);
		panel_1.add(comboBox_DiagnosticP);
		
		comboBox_TratamentP = new JComboBox();
		comboBox_TratamentP.setBounds(607, 168, 202, 20);
		panel_1.add(comboBox_TratamentP);
		
		comboBox_AnalizeP = new JComboBox();
		comboBox_AnalizeP.setBounds(608, 256, 201, 20);
		panel_1.add(comboBox_AnalizeP);
		
		JLabel lblRadiologie = new JLabel("Radiologie");
		lblRadiologie.setFont(new Font("Arial", Font.BOLD, 14));
		lblRadiologie.setBounds(518, 289, 80, 14);
		panel_1.add(lblRadiologie);
		
		comboBox_RadiologieP = new JComboBox();
		comboBox_RadiologieP.setBounds(608, 287, 201, 20);
		panel_1.add(comboBox_RadiologieP);
		
		JButton btnNewButton_2 = new JButton("Genereaza Reteta");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2.setBounds(664, 208, 145, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Genereaza Trimitere");
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_3.setBounds(649, 326, 155, 23);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_8 = new JButton("SALVEAZA");
		btnNewButton_8.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_8.setBounds(359, 549, 114, 23);
		panel_1.add(btnNewButton_8);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 876, 21);
		add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);
		
		JMenuItem mntmFile = new JMenuItem("File");
		mnNew.add(mntmFile);
		
		JMenuItem mntmFolder = new JMenuItem("Folder");
		mnNew.add(mntmFolder);
		
		JMenuItem mntmOpenFile = new JMenuItem("Open File");
		mnFile.add(mntmOpenFile);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mnFile.add(mntmExport);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndoTyping = new JMenuItem("Undo Typing");
		mnEdit.add(mntmUndoTyping);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mnEdit.add(mntmDelete);
		
		JMenu mnRapoarte = new JMenu("Rapoarte");
		mnRapoarte.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnRapoarte);
		
		JMenuItem mntmRapoarteDirector = new JMenuItem("Rapoarte Director");
		mnRapoarte.add(mntmRapoarteDirector);
		
		JMenuItem mntmFisaPacient = new JMenuItem("Fisa Pacient");
		mnRapoarte.add(mntmFisaPacient);
		
		JMenuItem mntmRaportareCnas = new JMenuItem("Raportare CNAS");
		mntmRaportareCnas.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnRapoarte.add(mntmRaportareCnas);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnHelp);
		
		JMenuItem mntmInformatiiRaportareCnas = new JMenuItem("Informatii raportare CNAS");
		mnHelp.add(mntmInformatiiRaportareCnas);

		fillComboBoxDoctorMG();
		fillComboBoxDoctorP();
		fillComboBoxDiagnosticMG();
		fillComboBoxDiagnosticP();
		fillComboBoxTratamentMG();
		fillComboBoxTratamentP();
		fillComboBoxAnalizeMG();
		fillComboBoxAnalizeP();
		fillComboBoxRadiologieMG();
		fillComboBoxRadiologieP();
	} 
}
