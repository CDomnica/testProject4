

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Color;

public class Login {

	public static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	static JTextField txtConexiuneLaBaza = new JTextField();
	static String dbUrl = "D:\\workspace\\testProject4\\src\\poli.sqlite";
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setVgap(5);
		borderLayout.setHgap(5);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(313, 114, 114, 19);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Nume Utilizator");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 14));
		lblUsername.setBounds(189, 114, 114, 19);
		panel.add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(313, 177, 114, 19);
		panel.add(passwordField);
		
		JLabel lblPassword = new JLabel("Parola");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassword.setBounds(242, 177, 61, 19);
		panel.add(lblPassword);
		
		PanelOptions options = new PanelOptions();
				
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				try{
					String querry="select * from users where username=? and password=? ";
					PreparedStatement pst = connection.prepareStatement(querry);
					pst.setString(1, txtUsername.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count = 0;
					while (rs.next()) {
						count = count + 1;
						
					}
					if(count == 1) {
						JOptionPane.showMessageDialog(null, "User name and password is correct");
						
						frame.setContentPane(options);
						frame.invalidate();
						frame.validate();

					} else if (count > 1){
						JOptionPane.showMessageDialog(null, "Duplicate user and password");
					} else {
						JOptionPane.showMessageDialog(null, "Usename and password is incorrect");
					}
					rs.close();
					pst.close();
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				} 
			}
		});
		btnLogin.setBounds(296, 246, 131, 60);
		panel.add(btnLogin);
		
		JButton btnNewButton = new JButton("Alege baza de date");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Selectati baza de date .sqlite");
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					dbUrl = file.getAbsolutePath();
				}	
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnNewButton.setBounds(296, 317, 177, 43);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Conecteaza baza de date");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection=sqliteConnection.dbConnector();
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnNewButton_1.setBounds(296, 371, 177, 43);
		panel.add(btnNewButton_1);
		
		
		txtConexiuneLaBaza.setBackground(Color.RED);
		txtConexiuneLaBaza.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 11));
		txtConexiuneLaBaza.setText("Conexiune la baza de date: NU");
		txtConexiuneLaBaza.setBounds(296, 434, 177, 20);
		panel.add(txtConexiuneLaBaza);
		txtConexiuneLaBaza.setColumns(10);
		frame.setBounds(100, 100, 860, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
