

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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "LABORATOR RADIOLOGIE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(23, 20, 815, 604);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Date Initiale", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(17, 34, 426, 235);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DOCTOR");
		lblNewLabel.setBounds(6, 18, 69, 14);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
	    comboBox_DoctorRadiologie = new JComboBox();
	    comboBox_DoctorRadiologie.setBounds(94, 16, 216, 20);
	    panel_2.add(comboBox_DoctorRadiologie);
		
		JLabel lblNewLabel_1 = new JLabel("CAUTA CNP");
		lblNewLabel_1.setBounds(6, 56, 79, 14);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		text_Cauta = new JTextField();
		text_Cauta.setBounds(95, 53, 216, 20);
		panel_2.add(text_Cauta);
		text_Cauta.setBackground(SystemColor.info);
		text_Cauta.setFont(new Font("Arial", Font.PLAIN, 12));
		text_Cauta.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NUME");
		lblNewLabel_2.setBounds(6, 96, 52, 14);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		
		text_Nume = new JTextField();
		text_Nume.setBounds(94, 93, 216, 20);
		panel_2.add(text_Nume);
		text_Nume.setFont(new Font("Arial", Font.PLAIN, 12));
		text_Nume.setBackground(SystemColor.info);
		text_Nume.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PRENUME");
		lblNewLabel_3.setBounds(6, 135, 79, 14);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		
		text_Prenume = new JTextField();
		text_Prenume.setBounds(94, 132, 216, 20);
		panel_2.add(text_Prenume);
		text_Prenume.setFont(new Font("Arial", Font.PLAIN, 12));
		text_Prenume.setBackground(SystemColor.info);
		text_Prenume.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DATA/ORA");
		lblNewLabel_4.setBounds(6, 167, 79, 14);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		
		text_Data = new JTextField();
		text_Data.setBounds(94, 164, 216, 20);
		panel_2.add(text_Data);
		text_Data.setFont(new Font("Arial", Font.PLAIN, 12));
		text_Data.setBackground(SystemColor.info);
		text_Data.setColumns(10);
		
		JButton btnNewButton_Clear = new JButton("CLEAR");
		btnNewButton_Clear.setBounds(148, 205, 89, 23);
		panel_2.add(btnNewButton_Clear);
		btnNewButton_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text_Cauta.setText("");
				text_Nume.setText("");
				text_Prenume.setText("");
				text_Data.setText("");
				
			}
		});
		btnNewButton_Clear.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton_Cauta = new JButton("Cautare");
		btnNewButton_Cauta.setBounds(331, 52, 89, 23);
		panel_2.add(btnNewButton_Cauta);
		btnNewButton_Cauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						String add3 = rs.getString("DataSiOra");
						text_Data.setText(add3);
						
					} else{
						JOptionPane.showMessageDialog(null, "Pacientul cu CNP-ul introdus nu exista sau nu are programare!");
					}
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_Cauta.setFont(new Font("Arial", Font.BOLD, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Date Medicale", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(461, 34, 345, 235);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		comboBox_Radiologie = new JComboBox();
		comboBox_Radiologie.setBounds(106, 16, 208, 20);
		panel_1.add(comboBox_Radiologie);
		
		JLabel lblNewLabel_5 = new JLabel("INVESTIGATII");
		lblNewLabel_5.setBounds(6, 18, 98, 14);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton_RezImagine = new JButton("REZULTATE IMAGINE");
		btnNewButton_RezImagine.setBounds(127, 56, 187, 25);
		panel_1.add(btnNewButton_RezImagine);
		btnNewButton_RezImagine.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton_Tiparire = new JButton("TIPARESTE IMAGINE");
		btnNewButton_Tiparire.setBounds(127, 96, 187, 23);
		panel_1.add(btnNewButton_Tiparire);
		btnNewButton_Tiparire.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton_Raportare = new JButton("RAPORTARE CNAS");
		btnNewButton_Raportare.setBounds(613, 280, 185, 59);
		panel.add(btnNewButton_Raportare);
		btnNewButton_Raportare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RaportareCNAS s = new RaportareCNAS();
				
			}
		});
		btnNewButton_Raportare.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Programari", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(17, 348, 788, 245);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_radiologie = new JButton("PROGRAMARI RADIOLOGIE");
		btnNewButton_radiologie.setBounds(249, 16, 225, 23);
		panel_3.add(btnNewButton_radiologie);
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
		
		JButton btnNewButton_inapoi = new JButton("INAPOI");
		btnNewButton_inapoi.setBounds(6, 212, 89, 23);
		panel_3.add(btnNewButton_inapoi);
		btnNewButton_inapoi.setFont(new Font("Arial", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 50, 776, 151);
		panel_3.add(scrollPane);
		
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
		btnNewButton_inapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelOptions options = new PanelOptions();
				Login.frame.setContentPane(options);
				Login.frame.invalidate();
				Login.frame.validate();
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 860, 21);
		add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnFile);
		
		JMenu mnFile_1 = new JMenu("New");
		mnFile_1.setFont(new Font("Arial", Font.PLAIN, 12));
		mnFile.add(mnFile_1);
		
		JMenuItem mntmFile = new JMenuItem("File");
		mntmFile.setFont(new Font("Arial", Font.PLAIN, 12));
		mnFile_1.add(mntmFile);
		
		JMenuItem mntmFolder = new JMenuItem("Folder");
		mntmFolder.setFont(new Font("Arial", Font.PLAIN, 12));
		mnFile_1.add(mntmFolder);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnEdit);
		
		JMenu mnRapoarte = new JMenu("Rapoarte");
		mnRapoarte.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnRapoarte);
		
		JMenuItem mntmRapoarteDirector = new JMenuItem("Rapoarte Director");
		mntmRapoarteDirector.setFont(new Font("Arial", Font.PLAIN, 12));
		mnRapoarte.add(mntmRapoarteDirector);
		
		JMenuItem mntmFisaPacient = new JMenuItem("Fisa Pacient");
		mntmFisaPacient.setFont(new Font("Arial", Font.PLAIN, 12));
		mnRapoarte.add(mntmFisaPacient);
		
		JMenuItem mntmRaportareCnas = new JMenuItem("Raportare CNAS");
		mntmRaportareCnas.setFont(new Font("Arial", Font.BOLD, 12));
		mnRapoarte.add(mntmRaportareCnas);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnHelp);
		
		JMenuItem mntmInformatiiRaportareCnas = new JMenuItem("Informatii Raportare CNAS");
		mntmInformatiiRaportareCnas.setFont(new Font("Arial", Font.PLAIN, 12));
		mnHelp.add(mntmInformatiiRaportareCnas);
		fillComboBoxDoctor();
		fillComboBoxRadiologie();

	}
}
