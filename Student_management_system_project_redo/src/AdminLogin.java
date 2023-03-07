import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLogin  {

	private JFrame frame;
	private JTextField txtUName;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.getContentPane().setLayout(null);
		frame.setSize(450,300);
		
		JLabel lblAdmin = new JLabel("Admin Login");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdmin.setBounds(0, 0, 436, 40);
		frame.getContentPane().add(lblAdmin);
		
		txtUName = new JTextField();
		txtUName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtUName.setBounds(152, 62, 252, 40);
		frame.getContentPane().add(txtUName);
		txtUName.setColumns(10);
		
		JLabel lblname = new JLabel("Username:");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblname.setBounds(26, 66, 116, 32);
		frame.getContentPane().add(lblname);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPassword.setBounds(26, 140, 116, 32);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUName.getText();
				String password = txtPass.getText();
				if(password.contains("group9")&&username.contains("GroupC9")) {
					txtUName.setText(null);
					txtPass.setText(null);
					JOptionPane.showMessageDialog(null, "Login Successfully..!");
					StudentManagement.main(new String[] {});
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Login","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(46, 211, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstScreen.main(new String[] {});
				frame.dispose();			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBounds(322, 211, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUName.setText(null);
				txtPass.setText(null);
			
			}
			
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReset.setBounds(186, 211, 89, 23);
		frame.getContentPane().add(btnReset);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtPass.setBounds(152, 131, 252, 40);
		frame.getContentPane().add(txtPass);
	}
}
