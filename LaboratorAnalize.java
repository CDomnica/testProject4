

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LaboratorAnalize extends JPanel {
	private JTextField textField_nume;
	private JTextField textField_prenume;
	private JTextField textField_data;
	private JComboBox comboBox_Doctor;
	private JComboBox comboBox_Recoltare;
	private JComboBox comboBox_Analize;
	
	Connection connection = null;
	private JTable table;
	private JTextField text_CautaCNP;
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
		lblNewLabel_Analize.setBounds(316, 32, 213, 17);
		add(lblNewLabel_Analize);
		
		JLabel lblNewLabel_Doctor = new JLabel("DOCTOR");
		lblNewLabel_Doctor.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Doctor.setBounds(21, 129, 78, 14);
		add(lblNewLabel_Doctor);
		
		JLabel lblNewLabel_cnp = new JLabel("Cauta CNP");
		lblNewLabel_cnp.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_cnp.setBounds(10, 170, 89, 14);
		add(lblNewLabel_cnp);
		
		JLabel lblNewLabel_Nume = new JLabel("NUME");
		lblNewLabel_Nume.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Nume.setBounds(10, 210, 46, 14);
		add(lblNewLabel_Nume);
		
		textField_nume = new JTextField();
		textField_nume.setBackground(SystemColor.info);
		textField_nume.setBounds(76, 208, 233, 20);
		add(textField_nume);
		textField_nume.setColumns(10);
		
		JLabel lblNewLabel_Prenume = new JLabel("PRENUME");
		lblNewLabel_Prenume.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Prenume.setBounds(10, 252, 70, 14);
		add(lblNewLabel_Prenume);
		
		textField_prenume = new JTextField();
		textField_prenume.setBackground(SystemColor.info);
		textField_prenume.setBounds(90, 250, 222, 20);
		add(textField_prenume);
		textField_prenume.setColumns(10);
		
		JLabel lblNewLabel_Data = new JLabel("DATA/ORA");
		lblNewLabel_Data.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Data.setBounds(10, 288, 70, 14);
		add(lblNewLabel_Data);
		
		textField_data = new JTextField();
		textField_data.setBackground(SystemColor.info);
		textField_data.setBounds(90, 286, 222, 20);
		add(textField_data);
		textField_data.setColumns(10);
		
		JLabel lblNewLabel_analiz = new JLabel("ANALIZE");
		lblNewLabel_analiz.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_analiz.setBounds(464, 210, 70, 14);
		add(lblNewLabel_analiz);
		
		JLabel lblNewLabel_recoltare = new JLabel("RECOLTARE");
		lblNewLabel_recoltare.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_recoltare.setBounds(445, 252, 89, 14);
		add(lblNewLabel_recoltare);
		
		comboBox_Doctor = new JComboBox();
		comboBox_Doctor.setBackground(SystemColor.info);
		comboBox_Doctor.setBounds(89, 123, 228, 20);
		add(comboBox_Doctor);
		
		comboBox_Recoltare = new JComboBox();
		comboBox_Recoltare.setBackground(SystemColor.info);
		comboBox_Recoltare.setBounds(546, 250, 242, 20);
		add(comboBox_Recoltare);
		
		comboBox_Analize = new JComboBox();
		comboBox_Analize.setBackground(SystemColor.info);
		comboBox_Analize.setBounds(546, 208, 242, 20);
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
		btnNewButton_RapProg.setBounds(316, 393, 172, 23);
		add(btnNewButton_RapProg);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 438, 734, 135);
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
		
		
		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);
		
		JButton btnNewButton_inapoi = new JButton("INAPOI");
		btnNewButton_inapoi.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_inapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelOptions options = new PanelOptions();
				Login.frame.setContentPane(options);
				Login.frame.invalidate();
				Login.frame.validate();
			}
		});
		btnNewButton_inapoi.setBounds(54, 584, 89, 23);
		add(btnNewButton_inapoi);
		
		text_CautaCNP = new JTextField();
		text_CautaCNP.setBackground(SystemColor.info);
		text_CautaCNP.setBounds(100, 168, 213, 20);
		add(text_CautaCNP);
		text_CautaCNP.setColumns(10);
		
		JButton btnNewButton_RezAnalize = new JButton("REZULTATE ANALIZE");
		btnNewButton_RezAnalize.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_RezAnalize.setBounds(603, 306, 185, 23);
		add(btnNewButton_RezAnalize);
		
		JButton btnNewButton_Tipareste = new JButton("TIPARESTE ");
		btnNewButton_Tipareste.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Tipareste.setBounds(603, 340, 185, 23);
		add(btnNewButton_Tipareste);
		
		JButton btnNewButton_Raportare = new JButton("RAPORTARE CNAS");
		btnNewButton_Raportare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RaportareCNAS s = new RaportareCNAS();
				
			}
		});
		btnNewButton_Raportare.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Raportare.setBounds(582, 107, 185, 59);
		add(btnNewButton_Raportare);
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_CautaCNP.setText("");
				textField_nume.setText("");
				textField_prenume.setText("");
				textField_data.setText("");
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(648, 540, 89, 23);
		add(btnNewButton);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 860, 21);
		add(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar_1.add(mnNewMenu);
		
		JMenu mnNewFile = new JMenu("New");
		mnNewMenu.add(mnNewFile);
		
		JMenuItem mntmFile = new JMenuItem("File");
		mntmFile.setFont(new Font("Arial", Font.PLAIN, 12));
		mnNewFile.add(mntmFile);
		
		JMenuItem mntmFolder = new JMenuItem("Folder");
		mntmFolder.setFont(new Font("Arial", Font.PLAIN, 12));
		mnNewFile.add(mntmFolder);
		
		JMenuItem mntmOpenFile = new JMenuItem("Open File");
		mntmOpenFile.setFont(new Font("Arial", Font.PLAIN, 12));
		mnNewMenu.add(mntmOpenFile);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.setFont(new Font("Arial", Font.PLAIN, 12));
		mnNewMenu.add(mntmSaveAs);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mntmExport.setFont(new Font("Arial", Font.PLAIN, 12));
		mnNewMenu.add(mntmExport);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Arial", Font.PLAIN, 12));
		mnNewMenu.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar_1.add(mnEdit);
		
		JMenuItem mntmUndoTyping = new JMenuItem("Undo typing");
		mntmUndoTyping.setFont(new Font("Arial", Font.PLAIN, 12));
		mnEdit.add(mntmUndoTyping);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setFont(new Font("Arial", Font.PLAIN, 12));
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.setFont(new Font("Arial", Font.PLAIN, 12));
		mnEdit.add(mntmPaste);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setFont(new Font("Arial", Font.PLAIN, 12));
		mnEdit.add(mntmDelete);
		
		JMenu mnRapoarte = new JMenu("Rapoarte");
		mnRapoarte.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar_1.add(mnRapoarte);
		
		JMenuItem mntmRapoarteDirector = new JMenuItem("Rapoarte Director");
		mntmRapoarteDirector.setFont(new Font("Arial", Font.PLAIN, 12));
		mnRapoarte.add(mntmRapoarteDirector);
		
		JMenuItem mntmFisaPacient = new JMenuItem("Fisa pacient");
		mntmFisaPacient.setFont(new Font("Arial", Font.PLAIN, 12));
		mnRapoarte.add(mntmFisaPacient);
		
		JMenuItem mntmRaportareCnas = new JMenuItem("Raportare CNAS");
		mntmRaportareCnas.setFont(new Font("Arial", Font.BOLD, 12));
		mnRapoarte.add(mntmRaportareCnas);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar_1.add(mnHelp);
		
		JMenuItem mntmInformatiiRaportareCnas = new JMenuItem("Informatii raportare CNAS");
		mntmInformatiiRaportareCnas.setFont(new Font("Arial", Font.PLAIN, 12));
		mnHelp.add(mntmInformatiiRaportareCnas);
		
		JButton btnNewButton_Cautare = new JButton("Cautare");
		btnNewButton_Cautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "select * from ProgramariAnalize where CNP=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, text_CautaCNP.getText());
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()){
						String add1 = rs.getString("Nume");
						textField_nume.setText(add1);
						String add2 = rs.getString("Prenume");
						textField_prenume.setText(add2);
						String add3 = rs.getString("DataSiOra");
						textField_data.setText(add3);
						
					} else{
						JOptionPane.showMessageDialog(null, "Pacientul cu CNP-ul introdus nu exista sau nu are programare!");
					}
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_Cautare.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_Cautare.setBounds(323, 167, 89, 23);
		add(btnNewButton_Cautare);
		
		fillComboBoxDoctor();
		//fillComboBoxCNP();
		fillComboBoxRecoltare();
		fillComboBoxAnalize();
	}
}
