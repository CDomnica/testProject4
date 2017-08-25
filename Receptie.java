
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
import javax.swing.BorderFactory;
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
import javax.swing.border.TitledBorder;

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
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "RECEPTIE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(10, 0, 836, 630);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 16, 359, 188);
		panel_7.add(panel_1);
		panel_1.setBorder(BorderFactory.createTitledBorder("Date Pacienti "));
		panel_1.setLayout(null);
		
		JLabel Label_Nume = new JLabel("NUME");
		Label_Nume.setBounds(14, 43, 55, 14);
		panel_1.add(Label_Nume);
		Label_Nume.setFont(new Font("Arial", Font.BOLD, 14));
		
		txtNume = new JTextField();
		txtNume.setBounds(89, 40, 260, 20);
		panel_1.add(txtNume);
		txtNume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNume.setBackground(SystemColor.info);
		txtNume.setColumns(10);
		
		JLabel Label_Prenume = new JLabel("PRENUME");
		Label_Prenume.setBounds(10, 81, 80, 14);
		panel_1.add(Label_Prenume);
		Label_Prenume.setFont(new Font("Arial", Font.BOLD, 14));
		
		textPrenume = new JTextField();
		textPrenume.setBounds(89, 78, 260, 20);
		panel_1.add(textPrenume);
		textPrenume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPrenume.setBackground(SystemColor.info);
		textPrenume.setColumns(10);
		
		JLabel LabelCNP = new JLabel("CNP");
		LabelCNP.setBounds(14, 124, 46, 14);
		panel_1.add(LabelCNP);
		LabelCNP.setFont(new Font("Arial", Font.BOLD, 14));
		
		textCNP = new JTextField();
		textCNP.setBounds(89, 121, 260, 20);
		panel_1.add(textCNP);
		textCNP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCNP.setBackground(SystemColor.info);
		textCNP.setColumns(10);
		
		JLabel Label_Adresa = new JLabel("ADRESA");
		Label_Adresa.setBounds(14, 159, 68, 14);
		panel_1.add(Label_Adresa);
		Label_Adresa.setFont(new Font("Arial", Font.BOLD, 14));
		
		textAdresa = new JTextField();
		textAdresa.setBounds(89, 156, 260, 20);
		panel_1.add(textAdresa);
		textAdresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAdresa.setBackground(SystemColor.info);
		textAdresa.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(432, 16, 398, 188);
		panel_7.add(panel_2);
		panel_2.setBorder(BorderFactory.createTitledBorder("Programari"));
		panel_2.setLayout(null);
		
		JLabel Label_Data = new JLabel("DATA");
		Label_Data.setBounds(14, 43, 46, 14);
		panel_2.add(Label_Data);
		Label_Data.setFont(new Font("Arial", Font.BOLD, 14));
		
		textData = new JTextField();
		textData.setBounds(117, 40, 271, 20);
		panel_2.add(textData);
		textData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setBackground(SystemColor.info);
		textData.setColumns(10);
		
		JLabel Label_Cabinet = new JLabel("CABINET");
		Label_Cabinet.setBounds(9, 81, 68, 14);
		panel_2.add(Label_Cabinet);
		Label_Cabinet.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel Label_Doctor = new JLabel("DOCTOR");
		Label_Doctor.setBounds(9, 124, 68, 14);
		panel_2.add(Label_Doctor);
		Label_Doctor.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel Label_Laborator = new JLabel("LABORATOR");
		Label_Laborator.setBounds(10, 159, 97, 14);
		panel_2.add(Label_Laborator);
		Label_Laborator.setFont(new Font("Arial", Font.BOLD, 14));
		
		textCabinet = new JTextField();
		textCabinet.setBounds(117, 78, 271, 20);
		panel_2.add(textCabinet);
		textCabinet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCabinet.setBackground(SystemColor.info);
		textCabinet.setColumns(10);
		
		textDoctor = new JTextField();
		textDoctor.setBounds(117, 121, 271, 20);
		panel_2.add(textDoctor);
		textDoctor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDoctor.setBackground(SystemColor.info);
		textDoctor.setColumns(10);
		
		textLab = new JTextField();
		textLab.setBounds(117, 156, 271, 20);
		panel_2.add(textLab);
		textLab.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textLab.setBackground(SystemColor.info);
		textLab.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(686, 228, 140, 96);
		panel_7.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_Salveaza = new JButton("SALVEAZA");
		btnNewButton_Salveaza.setBounds(0, 0, 140, 23);
		panel_3.add(btnNewButton_Salveaza);
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
		
		JButton btnNewButton_Actualizeaza = new JButton("ACTUALIZEAZA");
		btnNewButton_Actualizeaza.setBounds(0, 34, 140, 23);
		panel_3.add(btnNewButton_Actualizeaza);
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
		
		JButton btnNewButton_Sterge = new JButton("STERGE ");
		btnNewButton_Sterge.setBounds(0, 68, 140, 23);
		panel_3.add(btnNewButton_Sterge);
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
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(6, 227, 359, 97);
		panel_7.add(panel_6);
		panel_6.setBorder(new TitledBorder(null, "Plata Servicii", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setLayout(null);
		
		JLabel Label_Plata = new JLabel("TOTAL PLATA");
		Label_Plata.setBounds(20, 22, 103, 20);
		panel_6.add(Label_Plata);
		Label_Plata.setFont(new Font("Arial", Font.BOLD, 14));
		
		textPlata = new JTextField();
		textPlata.setBounds(133, 18, 103, 30);
		panel_6.add(textPlata);
		textPlata.setHorizontalAlignment(SwingConstants.CENTER);
		textPlata.setFont(new Font("Arial", Font.BOLD, 14));
		textPlata.setBackground(SystemColor.info);
		textPlata.setColumns(10);
		
		JButton btnNewButton_Chitanta = new JButton("GENEREAZA CHITANTA");
		btnNewButton_Chitanta.setBounds(20, 66, 201, 20);
		panel_6.add(btnNewButton_Chitanta);
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(18, 384, 804, 235);
		panel_7.add(panel_4);
		panel_4.setBorder(new TitledBorder(null, "Raport Programari", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setLayout(null);
		
		JButton btnNewButton_RaportProgramari = new JButton("Raport Programari");
		btnNewButton_RaportProgramari.setBounds(308, 16, 169, 25);
		panel_4.add(btnNewButton_RaportProgramari);
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
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 52, 785, 139);
		panel_4.add(scrollPane);
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
		
		JButton btnNewButton_StergeProgramare = new JButton("Sterge Programare");
		btnNewButton_StergeProgramare.setBounds(615, 202, 175, 23);
		panel_4.add(btnNewButton_StergeProgramare);
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
					
					String query3 = "delete from ProgramariRadiologie where CNP=?";
					PreparedStatement pst3 = connection.prepareStatement(query3);
					pst3.setString(1, textCNP.getText());
					pst3.execute();
					
					JOptionPane.showMessageDialog(null, "Programarea a fost Stearsa!");
					
				} catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
			}
		});
		btnNewButton_StergeProgramare.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton_Inapoi = new JButton("INAPOI");
		btnNewButton_Inapoi.setBounds(10, 202, 89, 23);
		panel_4.add(btnNewButton_Inapoi);
		btnNewButton_Inapoi.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(16, 335, 301, 23);
		panel_7.add(panel_5);
		panel_5.setLayout(null);
		
		textCautaCNP = new JTextField();
		textCautaCNP.setBounds(77, 1, 125, 20);
		panel_5.add(textCautaCNP);
		textCautaCNP.setBackground(SystemColor.info);
		textCautaCNP.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cauta CNP");
		lblNewLabel.setBounds(0, 3, 83, 14);
		panel_5.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Cautare");
		btnNewButton.setBounds(212, 0, 89, 23);
		panel_5.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					
					
					}else{
						JOptionPane.showMessageDialog(null, "Pacientul cu CNP-ul introdus nu exista sau nu are programare!");
					}
				}
				catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton_Clear = new JButton("Clear");
		btnNewButton_Clear.setBounds(327, 335, 89, 23);
		panel_7.add(btnNewButton_Clear);
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
		btnNewButton_Inapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelOptions options = new PanelOptions();
				Login.frame.setContentPane(options);
				Login.frame.invalidate();
				Login.frame.validate();
			}
		});
		
	}
}
