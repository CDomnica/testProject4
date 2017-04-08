import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Reteta {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table;
	
	public Reteta() {
	
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(551, 25, 263, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_Parafa = new JComboBox();
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
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 16, 263, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(105, 45, 263, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(105, 72, 263, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCasaDeAsigurari = new JLabel("Casa de Asigurari *");
		lblCasaDeAsigurari.setForeground(Color.RED);
		lblCasaDeAsigurari.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCasaDeAsigurari.setBounds(431, 23, 107, 14);
		panel_2.add(lblCasaDeAsigurari);
		
		textField_5 = new JTextField();
		textField_5.setBounds(556, 20, 258, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblTipAsigurat = new JLabel("Tip Asigurat *");
		lblTipAsigurat.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTipAsigurat.setForeground(Color.RED);
		lblTipAsigurat.setBounds(427, 51, 92, 14);
		panel_2.add(lblTipAsigurat);
		
		textField_6 = new JTextField();
		textField_6.setBounds(556, 49, 258, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNumarPns = new JLabel("Numar PNS");
		lblNumarPns.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNumarPns.setBounds(427, 78, 77, 14);
		panel_2.add(lblNumarPns);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(556, 80, 59, 20);
		panel_2.add(comboBox);
		
		JLabel lblNrFo = new JLabel("Nr FO / RC *");
		lblNrFo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNrFo.setForeground(Color.RED);
		lblNrFo.setBounds(630, 83, 77, 14);
		panel_2.add(lblNrFo);
		
		textField_7 = new JTextField();
		textField_7.setBounds(715, 80, 99, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
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
		
		textField_8 = new JTextField();
		textField_8.setBounds(107, 22, 263, 20);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(107, 50, 263, 20);
		panel_3.add(textField_9);
		textField_9.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(103, 81, 711, 20);
		panel_3.add(comboBox_1);
		
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
		
		textField_10 = new JTextField();
		textField_10.setBounds(557, 18, 257, 20);
		panel_3.add(textField_10);
		textField_10.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(557, 50, 257, 20);
		panel_3.add(comboBox_2);
		
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
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(111, 27, 263, 20);
		panel_4.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(111, 52, 263, 20);
		panel_4.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(111, 77, 263, 20);
		panel_4.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(561, 27, 253, 20);
		panel_4.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(561, 52, 253, 20);
		panel_4.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(561, 80, 253, 20);
		panel_4.add(comboBox_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 804, 63);
		panel_4.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(10, 197, 89, 23);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifica");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBounds(111, 197, 89, 23);
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sterge");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_2.setBounds(210, 197, 89, 23);
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("TIPARESTE");
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_3.setBounds(723, 577, 111, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("SALVEAZA");
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_4.setBounds(591, 577, 104, 23);
		panel.add(btnNewButton_4);
		
		frame.setVisible(true);
		frame.setBounds(100, 100, 860, 660);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
