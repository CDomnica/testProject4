

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
		lblNewLabel_Analize.setBounds(291, 11, 213, 17);
		add(lblNewLabel_Analize);
		
		JLabel lblNewLabel_Doctor = new JLabel("DOCTOR");
		lblNewLabel_Doctor.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Doctor.setBounds(10, 69, 78, 14);
		add(lblNewLabel_Doctor);
		
		JLabel lblNewLabel_cnp = new JLabel("Cauta CNP");
		lblNewLabel_cnp.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_cnp.setBounds(10, 111, 89, 14);
		add(lblNewLabel_cnp);
		
		JLabel lblNewLabel_Nume = new JLabel("NUME");
		lblNewLabel_Nume.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Nume.setBounds(10, 154, 46, 14);
		add(lblNewLabel_Nume);
		
		textField_nume = new JTextField();
		textField_nume.setBackground(SystemColor.info);
		textField_nume.setBounds(66, 152, 252, 20);
		add(textField_nume);
		textField_nume.setColumns(10);
		
		JLabel lblNewLabel_Prenume = new JLabel("PRENUME");
		lblNewLabel_Prenume.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Prenume.setBounds(10, 191, 70, 14);
		add(lblNewLabel_Prenume);
		
		textField_prenume = new JTextField();
		textField_prenume.setBackground(SystemColor.info);
		textField_prenume.setBounds(90, 189, 228, 20);
		add(textField_prenume);
		textField_prenume.setColumns(10);
		
		JLabel lblNewLabel_Data = new JLabel("DATA/ORA");
		lblNewLabel_Data.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_Data.setBounds(10, 228, 70, 14);
		add(lblNewLabel_Data);
		
		textField_data = new JTextField();
		textField_data.setBackground(SystemColor.info);
		textField_data.setBounds(90, 226, 228, 20);
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
		comboBox_Doctor.setBounds(79, 67, 239, 20);
		add(comboBox_Doctor);
		
		comboBox_Recoltare = new JComboBox();
		comboBox_Recoltare.setBackground(SystemColor.info);
		comboBox_Recoltare.setBounds(109, 286, 209, 20);
		add(comboBox_Recoltare);
		
		comboBox_Analize = new JComboBox();
		comboBox_Analize.setBackground(SystemColor.info);
		comboBox_Analize.setBounds(76, 257, 242, 20);
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
		scrollPane.setBounds(54, 376, 734, 135);
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
		btnNewButton_inapoi.setBounds(55, 539, 89, 23);
		add(btnNewButton_inapoi);
		
		text_CautaCNP = new JTextField();
		text_CautaCNP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
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
					String add3 = rs.getString("Data");
					textField_data.setText(add3);
			
					
					}
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		text_CautaCNP.setBackground(SystemColor.info);
		text_CautaCNP.setBounds(90, 109, 228, 20);
		add(text_CautaCNP);
		text_CautaCNP.setColumns(10);
		
		JButton btnNewButton_RezAnalize = new JButton("REZULTATE ANALIZE");
		btnNewButton_RezAnalize.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_RezAnalize.setBounds(552, 201, 185, 23);
		add(btnNewButton_RezAnalize);
		
		JButton btnNewButton_Tipareste = new JButton("TIPARESTE ");
		btnNewButton_Tipareste.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Tipareste.setBounds(552, 253, 185, 23);
		add(btnNewButton_Tipareste);
		
		JButton btnNewButton_Raportare = new JButton("RAPORTARE CNAS");
		btnNewButton_Raportare.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Raportare.setBounds(552, 66, 185, 59);
		add(btnNewButton_Raportare);
		
		fillComboBoxDoctor();
		//fillComboBoxCNP();
		fillComboBoxRecoltare();
		fillComboBoxAnalize();
	}
}
