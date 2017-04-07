

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
import javax.swing.border.TitledBorder;

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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Date Initiale", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 19, 407, 249);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCnpCautare = new JLabel("Cauta CNP");
		lblCnpCautare.setBounds(6, 67, 80, 14);
		panel_2.add(lblCnpCautare);
		lblCnpCautare.setFont(new Font("Arial", Font.BOLD, 14));
		
		textCautaCNP = new JTextField();
		textCautaCNP.setBounds(87, 65, 215, 20);
		panel_2.add(textCautaCNP);
		textCautaCNP.setBackground(SystemColor.info);
		textCautaCNP.setColumns(10);
		
		JButton btnCautare = new JButton("Cautare");
		btnCautare.setBounds(312, 63, 89, 23);
		panel_2.add(btnCautare);
		btnCautare.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNume = new JLabel("NUME");
		lblNume.setBounds(6, 103, 55, 14);
		panel_2.add(lblNume);
		lblNume.setFont(new Font("Arial", Font.BOLD, 14));
		
		textNume = new JTextField();
		textNume.setBounds(87, 96, 215, 20);
		panel_2.add(textNume);
		textNume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNume.setColumns(10);
		textNume.setBackground(SystemColor.info);
		
		JLabel lblPrenume = new JLabel("PRENUME");
		lblPrenume.setBounds(6, 135, 80, 14);
		panel_2.add(lblPrenume);
		lblPrenume.setFont(new Font("Arial", Font.BOLD, 14));
		
		textPrenume = new JTextField();
		textPrenume.setBounds(87, 132, 215, 20);
		panel_2.add(textPrenume);
		textPrenume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPrenume.setColumns(10);
		textPrenume.setBackground(SystemColor.info);
		
		JLabel lblDoctor = new JLabel("DOCTOR");
		lblDoctor.setBounds(6, 16, 68, 20);
		panel_2.add(lblDoctor);
		lblDoctor.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblDataora = new JLabel("DATA/ORA");
		lblDataora.setBounds(6, 160, 70, 23);
		panel_2.add(lblDataora);
		lblDataora.setFont(new Font("Arial", Font.BOLD, 14));
		
		textData = new JTextField();
		textData.setBounds(87, 163, 215, 21);
		panel_2.add(textData);
		textData.setBackground(SystemColor.info);
		textData.setColumns(10);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(115, 219, 114, 23);
		panel_2.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCautaCNP.setText("");
				textNume.setText("");
				textPrenume.setText("");
				textData.setText("");
			}
		});
		btnClear.setFont(new Font("Arial", Font.BOLD, 14));
		
		comboBox_Doctor = new JComboBox();
		comboBox_Doctor.setBounds(84, 17, 215, 20);
		panel_2.add(comboBox_Doctor);
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Reteta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(494, 13, 317, 128);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblDiagnostic = new JLabel("Diagnostic");
		lblDiagnostic.setBounds(6, 16, 81, 20);
		panel_3.add(lblDiagnostic);
		lblDiagnostic.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblTratament = new JLabel("Tratament");
		lblTratament.setBounds(6, 47, 80, 23);
		panel_3.add(lblTratament);
		lblTratament.setFont(new Font("Arial", Font.BOLD, 14));
		
		comboBox_Diagnostic = new JComboBox();
		comboBox_Diagnostic.setBounds(97, 17, 214, 20);
		panel_3.add(comboBox_Diagnostic);
		
		comboBox_Tratament = new JComboBox();
		comboBox_Tratament.setBounds(96, 55, 215, 20);
		panel_3.add(comboBox_Tratament);
		
		JButton btnNewButton_5 = new JButton("Genereaza Reteta");
		btnNewButton_5.setBounds(163, 98, 146, 23);
		panel_3.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 12));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Programari", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(15, 350, 802, 229);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnInapoi = new JButton("INAPOI");
		btnInapoi.setBounds(26, 189, 114, 23);
		panel_5.add(btnInapoi);
		btnInapoi.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnSalveaza = new JButton("SALVEAZA");
		btnSalveaza.setBounds(676, 199, 114, 23);
		panel_5.add(btnSalveaza);
		btnSalveaza.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton_7 = new JButton("Programari Medicina Generala");
		btnNewButton_7.setBounds(263, 16, 208, 23);
		panel_5.add(btnNewButton_7);
		btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 12));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 59, 790, 119);
		panel_5.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		btnInapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelOptions options = new PanelOptions();
				Login.frame.setContentPane(options);
				Login.frame.invalidate();
				Login.frame.validate();
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Trimitere", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(494, 160, 317, 108);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblAnalize = new JLabel("Analize");
		lblAnalize.setBounds(6, 18, 68, 14);
		panel_4.add(lblAnalize);
		lblAnalize.setFont(new Font("Arial", Font.BOLD, 14));
		
		comboBox_Analize = new JComboBox();
		comboBox_Analize.setBounds(99, 16, 212, 20);
		panel_4.add(comboBox_Analize);
		
		JLabel lblNewLabel = new JLabel("Radiologie");
		lblNewLabel.setBounds(6, 49, 89, 14);
		panel_4.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		comboBox_Radiologie = new JComboBox();
		comboBox_Radiologie.setBounds(97, 47, 213, 20);
		panel_4.add(comboBox_Radiologie);
		
		JButton btnNewButton_6 = new JButton("Genereaza Trimitere");
		btnNewButton_6.setBounds(158, 78, 153, 23);
		panel_4.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BiletTrimitere bt = new BiletTrimitere();
			}
		});
		btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnNewButton_4 = new JButton("RAPORTARE CNAS");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RaportareCNAS s = new RaportareCNAS();
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_4.setBounds(620, 285, 185, 59);
		panel.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Pediatrie", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Date Initiale", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(11, 19, 409, 241);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		
		JLabel lblCnpCautare2 = new JLabel("Cauta CNP");
		lblCnpCautare2.setBounds(6, 70, 85, 14);
		panel_6.add(lblCnpCautare2);
		lblCnpCautare2.setFont(new Font("Arial", Font.BOLD, 14));
		
		textCautaCNP2 = new JTextField();
		textCautaCNP2.setBounds(89, 68, 215, 20);
		panel_6.add(textCautaCNP2);
		textCautaCNP2.setBackground(SystemColor.info);
		textCautaCNP2.setColumns(10);
		
		JButton btnCautare2 = new JButton("Cautare");
		btnCautare2.setBounds(314, 66, 89, 23);
		panel_6.add(btnCautare2);
		btnCautare2.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNume2 = new JLabel("NUME");
		lblNume2.setBounds(6, 105, 55, 14);
		panel_6.add(lblNume2);
		lblNume2.setFont(new Font("Arial", Font.BOLD, 14));
		
		textNume2 = new JTextField();
		textNume2.setBounds(89, 99, 215, 20);
		panel_6.add(textNume2);
		textNume2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNume2.setColumns(10);
		textNume2.setBackground(SystemColor.info);
		
		JLabel lblPrenume2 = new JLabel("PRENUME");
		lblPrenume2.setBounds(6, 130, 80, 14);
		panel_6.add(lblPrenume2);
		lblPrenume2.setFont(new Font("Arial", Font.BOLD, 14));
		
		textPrenume2 = new JTextField();
		textPrenume2.setBounds(89, 130, 215, 20);
		panel_6.add(textPrenume2);
		textPrenume2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPrenume2.setColumns(10);
		textPrenume2.setBackground(SystemColor.info);
		
		JLabel lblDoctor2 = new JLabel("DOCTOR");
		lblDoctor2.setBounds(6, 16, 68, 20);
		panel_6.add(lblDoctor2);
		lblDoctor2.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblDataora2 = new JLabel("DATA/ORA");
		lblDataora2.setBounds(6, 159, 70, 23);
		panel_6.add(lblDataora2);
		lblDataora2.setFont(new Font("Arial", Font.BOLD, 14));
		
		textData2 = new JTextField();
		textData2.setBounds(89, 161, 215, 21);
		panel_6.add(textData2);
		textData2.setColumns(10);
		textData2.setBackground(SystemColor.info);
		
		JButton btnClear2 = new JButton("CLEAR");
		btnClear2.setBounds(126, 211, 114, 23);
		panel_6.add(btnClear2);
		btnClear2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textCautaCNP2.setText("");
				textNume2.setText("");
				textPrenume2.setText("");
				textData2.setText("");
			}
		});
		btnClear2.setFont(new Font("Arial", Font.BOLD, 14));
		
		comboBox_DoctorP = new JComboBox();
		comboBox_DoctorP.setBounds(85, 17, 219, 20);
		panel_6.add(comboBox_DoctorP);
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
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Reteta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(485, 11, 329, 120);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblDiagnotic2 = new JLabel("Diagnostic");
		lblDiagnotic2.setBounds(6, 16, 81, 20);
		panel_7.add(lblDiagnotic2);
		lblDiagnotic2.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblTratament2 = new JLabel("Tratament");
		lblTratament2.setBounds(6, 47, 80, 23);
		panel_7.add(lblTratament2);
		lblTratament2.setFont(new Font("Arial", Font.BOLD, 14));
		
		comboBox_DiagnosticP = new JComboBox();
		comboBox_DiagnosticP.setBounds(106, 17, 217, 20);
		panel_7.add(comboBox_DiagnosticP);
		
		comboBox_TratamentP = new JComboBox();
		comboBox_TratamentP.setBounds(106, 49, 217, 20);
		panel_7.add(comboBox_TratamentP);
		
		JButton btnNewButton_2 = new JButton("Genereaza Reteta");
		btnNewButton_2.setBounds(178, 90, 145, 23);
		panel_7.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "Programari", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(15, 359, 800, 219);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		
		JButton btnInapoi2 = new JButton("INAPOI");
		btnInapoi2.setBounds(31, 189, 114, 23);
		panel_9.add(btnInapoi2);
		btnInapoi2.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Programari Pediatrie");
		btnNewButton.setBounds(307, 16, 155, 23);
		panel_9.add(btnNewButton);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 50, 787, 128);
		panel_9.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_8 = new JButton("SALVEAZA");
		btnNewButton_8.setBounds(680, 189, 114, 23);
		panel_9.add(btnNewButton_8);
		btnNewButton_8.setFont(new Font("Arial", Font.BOLD, 14));
		btnInapoi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelOptions options2 = new PanelOptions();
				Login.frame.setContentPane(options2);
				Login.frame.invalidate();
				Login.frame.validate();
			}
		});
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Trimitere", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(485, 140, 329, 127);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblLaborator = new JLabel("Analize");
		lblLaborator.setBounds(6, 18, 68, 14);
		panel_8.add(lblLaborator);
		lblLaborator.setFont(new Font("Arial", Font.BOLD, 14));
		
		comboBox_AnalizeP = new JComboBox();
		comboBox_AnalizeP.setBounds(106, 16, 217, 20);
		panel_8.add(comboBox_AnalizeP);
		
		JLabel lblRadiologie = new JLabel("Radiologie");
		lblRadiologie.setBounds(6, 57, 80, 14);
		panel_8.add(lblRadiologie);
		lblRadiologie.setFont(new Font("Arial", Font.BOLD, 14));
		
		comboBox_RadiologieP = new JComboBox();
		comboBox_RadiologieP.setBounds(106, 55, 217, 20);
		panel_8.add(comboBox_RadiologieP);
		
		JButton btnNewButton_3 = new JButton("Genereaza Trimitere");
		btnNewButton_3.setBounds(168, 97, 155, 23);
		panel_8.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BiletTrimitere bt  = new BiletTrimitere();
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnNewButton_1 = new JButton("RAPORTARE CNAS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RaportareCNAS s = new RaportareCNAS();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBounds(624, 286, 185, 59);
		panel_1.add(btnNewButton_1);
		
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
