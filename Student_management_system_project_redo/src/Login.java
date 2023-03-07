import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField txtEmail;
	private JPasswordField txtPass;

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
		frame = new JFrame("User Login");
		frame.setBounds(100, 100, 450, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(0, 0, 436, 383);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel StuLogin = new JLabel("Student Login");
		StuLogin.setForeground(Color.BLUE);
		StuLogin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		StuLogin.setBounds(56, 0, 175, 61);
		panel.add(StuLogin);
		
		JLabel Email = new JLabel("Enter Email:");
		Email.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Email.setBounds(40, 72, 101, 14);
		panel.add(Email);
		
		JLabel lblEnterPassword = new JLabel("Enter Password :");
		lblEnterPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnterPassword.setBounds(40, 134, 135, 21);
		panel.add(lblEnterPassword);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setBounds(192, 64, 203, 32);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPass.setBounds(192, 124, 203, 32);
		panel.add(txtPass);
		
		JButton btnNuser = new JButton("New User");
		btnNuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register.main(new String[] {} );
				frame.dispose();
			}
		});
		btnNuser.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNuser.setBounds(20, 213, 131, 32);
		panel.add(btnNuser);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
					JFrame f = new JFrame();
					boolean matched = false;
					String uname = txtEmail.getText().toString();
					String pwd = txtPass.getText().toString();
					try {
						FileReader fr = new FileReader("Login.txt");
						BufferedReader br = new BufferedReader(fr);
						String line;
						while((line = br.readLine())!=null) {
							if(line.equals(uname+ "\t"+ pwd)) {
								matched = true;
								break;
							}
						}
						fr.close();
					} catch (Exception e) {
					}
				if(matched) {
					JOptionPane.showMessageDialog(f, "Login Sucessfully...!");
					StudentDetails.main(new String[] {});
					frame.dispose();
				}else {
					
					JOptionPane.showMessageDialog(f, "Invalid Password");
				}
					
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogin.setBounds(170, 213, 115, 32);
		panel.add(btnLogin);
		
		JButton btnNuser_2 = new JButton("Back");
		btnNuser_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstScreen.main(new String[] {});
				frame.dispose();
			}
		});
		btnNuser_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNuser_2.setBounds(306, 213, 106, 32);
		panel.add(btnNuser_2);
		
		
	}
}
