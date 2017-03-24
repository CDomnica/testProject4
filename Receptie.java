
import java.sql.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Receptie extends JPanel {
	private JTextField txtNume;
	private JTextField textPrenume;
	private JTextField textCNP;
	private JTextField textAdresa;
	private JTextField textData;
	private JTextField textPlata;
	private JTable table;

	/**
	 * Create the panel.
	 */
	Connection connection = null;
	private JTextField textCabinet;
	private JTextField textDoctor;
	private JTextField textLab;
	private JTextField textCautaCNP;
	public Receptie() {
		connection=sqliteConnection.dbConnector();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JLabel Label_DatePacienti = new JLabel("DATE PACIENTI");
		Label_DatePacienti.setFont(new Font("Arial", Font.BOLD, 14));
		Label_DatePacienti.setBounds(49, 11, 117, 20);
		panel.add(Label_DatePacienti);
		
		JLabel Label_Nume = new JLabel("NUME");
		Label_Nume.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Nume.setBounds(49, 54, 55, 14);
		panel.add(Label_Nume);
		
		txtNume = new JTextField();
		txtNume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNume.setBackground(SystemColor.info);
		txtNume.setBounds(99, 51, 201, 20);
		panel.add(txtNume);
		txtNume.setColumns(10);
		
		JLabel Label_Prenume = new JLabel("PRENUME");
		Label_Prenume.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Prenume.setBounds(50, 92, 80, 14);
		panel.add(Label_Prenume);
		
		textPrenume = new JTextField();
		textPrenume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPrenume.setBackground(SystemColor.info);
		textPrenume.setBounds(128, 89, 175, 20);
		panel.add(textPrenume);
		textPrenume.setColumns(10);
		
		JLabel LabelCNP = new JLabel("CNP");
		LabelCNP.setFont(new Font("Arial", Font.BOLD, 14));
		LabelCNP.setBounds(49, 135, 46, 14);
		panel.add(LabelCNP);
		
		textCNP = new JTextField();
		textCNP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCNP.setBackground(SystemColor.info);
		textCNP.setBounds(99, 132, 217, 20);
		panel.add(textCNP);
		textCNP.setColumns(10);
		
		JLabel Label_Adresa = new JLabel("ADRESA");
		Label_Adresa.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Adresa.setBounds(49, 170, 68, 14);
		panel.add(Label_Adresa);
		
		textAdresa = new JTextField();
		textAdresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAdresa.setBackground(SystemColor.info);
		textAdresa.setBounds(119, 167, 228, 20);
		panel.add(textAdresa);
		textAdresa.setColumns(10);
		
		JLabel lblProgramareConsultatii = new JLabel("PROGRAMARE CONSULTATII / LABORATOR");
		lblProgramareConsultatii.setFont(new Font("Arial", Font.BOLD, 14));
		lblProgramareConsultatii.setBounds(461, 11, 318, 20);
		panel.add(lblProgramareConsultatii);
		
		JLabel Label_Data = new JLabel("DATA");
		Label_Data.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Data.setBounds(452, 54, 46, 14);
		panel.add(Label_Data);
		
		textData = new JTextField();
		textData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setBackground(SystemColor.info);
		textData.setBounds(508, 51, 239, 20);
		panel.add(textData);
		textData.setColumns(10);
		
		JLabel Label_Cabinet = new JLabel("CABINET");
		Label_Cabinet.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Cabinet.setBounds(452, 92, 68, 14);
		panel.add(Label_Cabinet);
		
		JLabel Label_Doctor = new JLabel("DOCTOR");
		Label_Doctor.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Doctor.setBounds(452, 135, 68, 14);
		panel.add(Label_Doctor);
		
		JButton btnNewButton_Salveaza = new JButton("SALVEAZA");
		btnNewButton_Salveaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="insert into Pacienti (Nume, Prenume, CNP, Adresa, Cabinet, Doctor, DataSiOra) values(?,?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,txtNume.getText());
					pst.setString(2,textPrenume.getText());
					pst.setString(3,textCNP.getText());
					pst.setString(4,textAdresa.getText());
					pst.setString(5,textCabinet.getText());
					pst.setString(6,textDoctor.getText());
					pst.setString(7,textData.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Date Salvate!");
					
					pst.close();
				
					String query2="insert into Programari (Nume, Prenume, Cabinet, Doctor, DataSiOra, Laborator, CNP) values(?,?,?,?,?,?,?)";
					PreparedStatement pst2 = connection.prepareStatement(query2);
					pst2.setString(1,txtNume.getText());
					pst2.setString(2,textPrenume.getText());
					pst2.setString(3,textCabinet.getText());
					pst2.setString(4,textDoctor.getText());
					pst2.setString(5,textData.getText());
					pst2.setString(6,textLab.getText());
					pst2.setString(7,textCNP.getText());
					
					pst2.execute();
					
					JOptionPane.showMessageDialog(null, "Date Salvate!");
					
					pst2.close();
					
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_Salveaza.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Salveaza.setBounds(570, 222, 140, 23);
		panel.add(btnNewButton_Salveaza);
		
		JLabel Label_Plata = new JLabel("TOTAL PLATA");
		Label_Plata.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Plata.setBounds(45, 223, 103, 20);
		panel.add(Label_Plata);
		
		textPlata = new JTextField();
		textPlata.setHorizontalAlignment(SwingConstants.CENTER);
		textPlata.setFont(new Font("Arial", Font.BOLD, 14));
		textPlata.setBackground(SystemColor.info);
		textPlata.setBounds(147, 219, 103, 30);
		panel.add(textPlata);
		textPlata.setColumns(10);
		
		JButton btnNewButton_Chitanta = new JButton("GENEREAZA CHITANTA");
		btnNewButton_Chitanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + " C://Users//StefanDomnica//Desktop//chitanta.gif");
					
				} catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_Chitanta.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Chitanta.setBounds(49, 273, 201, 20);
		panel.add(btnNewButton_Chitanta);
		
		JLabel Label_Laborator = new JLabel("LABORATOR");
		Label_Laborator.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Laborator.setBounds(452, 170, 97, 14);
		panel.add(Label_Laborator);
		
		JButton btnNewButton_RaportProgramari = new JButton("Raport Programari");
		btnNewButton_RaportProgramari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="SELECT nume, prenume, Cabinet, Doctor, DataSiOra, Laborator, CNP FROM Programari";
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
		btnNewButton_RaportProgramari.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_RaportProgramari.setBounds(299, 326, 169, 25);
		panel.add(btnNewButton_RaportProgramari);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 362, 745, 139);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		 
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					int row = table.getSelectedRow();
					String Nume_=(table.getModel().getValueAt(row, 0)).toString();
					
					String query="select * from Pacienti where Nume='"+Nume_+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						txtNume.setText(rs.getString("Nume"));
						textPrenume.setText(rs.getString("Prenume"));
						textCNP.setText(rs.getString("CNP"));
						textAdresa.setText(rs.getString("Adresa"));
						textData.setText(rs.getString("DataSiOra"));
						textCabinet.setText(rs.getString("Cabinet"));
						textDoctor.setText(rs.getString("Doctor"));
						textLab.setText(rs.getString("Laborator"));
					}
					
					pst.close();
			
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		
		scrollPane.setViewportView(table);
		
		textCabinet = new JTextField();
		textCabinet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCabinet.setBackground(SystemColor.info);
		textCabinet.setBounds(534, 89, 213, 20);
		panel.add(textCabinet);
		textCabinet.setColumns(10);
		
		textDoctor = new JTextField();
		textDoctor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDoctor.setBackground(SystemColor.info);
		textDoctor.setBounds(530, 132, 217, 20);
		panel.add(textDoctor);
		textDoctor.setColumns(10);
		
		textLab = new JTextField();
		textLab.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textLab.setBackground(SystemColor.info);
		textLab.setBounds(549, 170, 198, 20);
		panel.add(textLab);
		textLab.setColumns(10);
		
		JButton btnNewButton_Actualizeaza = new JButton("ACTUALIZEAZA");
		btnNewButton_Actualizeaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query=" Update Pacienti set CNP='"+textCNP.getText()+"', Nume='"+txtNume.getText()+"', Prenume='"+textPrenume.getText()+"', Adresa='"+textAdresa.getText()+"', Cabinet='"+textCabinet.getText()+"', Doctor='"+textDoctor.getText()+"', DataSiOra='"+textData.getText()+"' where CNP='"+textCNP.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Datele au fost Actualizate!");
					
					pst.close();
				
					String query2="Update Programari set CNP='"+textCNP.getText()+"', Nume='"+txtNume.getText()+"', Prenume='"+textPrenume.getText()+"', Cabinet='"+textCabinet.getText()+"', Doctor='"+textDoctor.getText()+"', DataSiOra='"+textData.getText()+"', Laborator='"+textLab.getText()+"' where CNP='"+textCNP.getText()+"'";
					PreparedStatement pst2 = connection.prepareStatement(query2);
					
					pst2.execute();
					
					//JOptionPane.showMessageDialog(null, "Datele au fost Actualizate!");
					
					pst2.close();
					
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
				
			}
		});
		btnNewButton_Actualizeaza.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Actualizeaza.setBounds(570, 256, 140, 23);
		panel.add(btnNewButton_Actualizeaza);
		
		JButton btnNewButton_Sterge = new JButton("STERGE ");
		btnNewButton_Sterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p = JOptionPane.showConfirmDialog(null, "Esti sigur ca vrei sa stergi datele pacientului?", "Sterge", JOptionPane.YES_NO_OPTION);
				if (p==0){
				try{
					String query="delete from Pacienti where CNP='"+textCNP.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Datele au fost Sterse!");
					
					pst.close();
				
					String query2="delete from Programari where CNP='"+textCNP.getText()+"'";
					PreparedStatement pst2 = connection.prepareStatement(query2);
					
					pst2.execute();
					pst2.close();
					

					String query3="delete from ProgramariAnalize where CNP='"+textCNP.getText()+"'";
					PreparedStatement pst3 = connection.prepareStatement(query3);
					
					pst3.execute();	
					pst3.close();
					
					String query4="delete from ProgramariLaborator where CNP='"+textCNP.getText()+"'";
					PreparedStatement pst4 = connection.prepareStatement(query4);
					
					pst4.execute();	
					pst4.close();
					
					
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
				}
			}
		});
		btnNewButton_Sterge.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Sterge.setBounds(570, 290, 140, 23);
		panel.add(btnNewButton_Sterge);
		
		textCautaCNP = new JTextField();
		textCautaCNP.setBackground(SystemColor.info);
		textCautaCNP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					String query = "select * from Pacienti where CNP=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textCautaCNP.getText());
					ResultSet rs = pst.executeQuery();
					if(rs.next()){
					String add1 = rs.getString("Nume");
					txtNume.setText(add1);
					String add2 = rs.getString("Prenume");
					textPrenume.setText(add2);
					String add3 = rs.getString("CNP");
					textCNP.setText(add3);
					String add4 = rs.getString("Adresa");
					textAdresa.setText(add4);
					String add5 = rs.getString("DataSiOra");
					textData.setText(add5);
					String add6 = rs.getString("Cabinet");
					textCabinet.setText(add6);
					String add7 = rs.getString("Doctor");
					textDoctor.setText(add7);
					String add8 = rs.getString("Laborator");
					textLab.setText(add8);
					
					
					}
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		textCautaCNP.setBounds(34, 329, 216, 20);
		panel.add(textCautaCNP);
		textCautaCNP.setColumns(10);
		
		JButton btnNewButton_StergeProgramare = new JButton("Sterge Programare");
		btnNewButton_StergeProgramare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p = JOptionPane.showConfirmDialog(null, "Esti sigur ca vrei sa stergi programarea?", "Sterge", JOptionPane.YES_NO_OPTION);
				if(p==0){
				try {
				
					String query = "delete from Programari where CNP=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textCNP.getText());
					pst.execute();
					
					String query2 = "delete from ProgramariAnalize where CNP=?";
					PreparedStatement pst2 = connection.prepareStatement(query2);
					pst2.setString(1, textCNP.getText());
					pst2.execute();
					
					String query3 = "delete from ProgramariAnalize where CNP=?";
					PreparedStatement pst3 = connection.prepareStatement(query3);
					pst3.setString(1, textCNP.getText());
					pst3.execute();
					
					JOptionPane.showMessageDialog(null, "Programare Stearsa!");
					
				} catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
			}
		});
		btnNewButton_StergeProgramare.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_StergeProgramare.setBounds(583, 522, 175, 23);
		panel.add(btnNewButton_StergeProgramare);
		
		JButton btnNewButton_Clear = new JButton("CLEAR");
		btnNewButton_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNume.setText("");
				textPrenume.setText("");
				textCNP.setText("");
				textAdresa.setText("");
				textData.setText("");
				textCabinet.setText("");
				textDoctor.setText("");
				textLab.setText("");
			}
		});
		btnNewButton_Clear.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Clear.setBounds(44, 522, 140, 23);
		panel.add(btnNewButton_Clear);
		
		JButton btnNewButton_Inapoi = new JButton("Inapoi");
		btnNewButton_Inapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelOptions options = new PanelOptions();
				Login.frame.setContentPane(options);
				Login.frame.invalidate();
				Login.frame.validate();
			}
		});
		btnNewButton_Inapoi.setBounds(54, 554, 89, 23);
		panel.add(btnNewButton_Inapoi);
		
	}
}
