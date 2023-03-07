import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txt_ID;
	private JPasswordField txtPass;
	private JPasswordField txtCPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(0, 0, 486, 563);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Sign Up");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 0, 235, 44);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblName.setBounds(33, 57, 73, 21);
		panel.add(lblName);
		
		JLabel lblEmailid = new JLabel("Email-ID :");
		lblEmailid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmailid.setBounds(33, 108, 94, 21);
		panel.add(lblEmailid);
		
		JLabel lblCreatePassword = new JLabel("Create Password :");
		lblCreatePassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCreatePassword.setBounds(34, 159, 148, 21);
		panel.add(lblCreatePassword);
		
		JLabel lblComfirmPassword = new JLabel("Comfirm Password :");
		lblComfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblComfirmPassword.setBounds(33, 207, 168, 21);
		panel.add(lblComfirmPassword);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtName.setBounds(211, 48, 235, 28);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txt_ID = new JTextField();
		txt_ID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_ID.setColumns(10);
		txt_ID.setBounds(211, 103, 235, 28);
		panel.add(txt_ID);
		
		JButton btnSummit = new JButton("Summit");
		btnSummit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				try {
					FileWriter fw = new FileWriter("Login.txt",true);
					 
						fw.write(txt_ID.getText()+ "\t" +  txtPass.getText()+"\n");
						fw.close();
						
						JOptionPane.showMessageDialog(f, "Resgister Completed");
						Login.main(new String[] {});
						frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSummit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSummit.setBounds(33, 278, 110, 33);
		panel.add(btnSummit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txt_ID.setText(null);
				txtPass.setText(null);
				txtCPass.setText(null);
				
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.setBounds(187, 278, 110, 33);
		panel.add(btnClear);
		
  		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[] {});
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBounds(332, 278, 110, 33);
		panel.add(btnBack);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(211, 153, 235, 28);
		panel.add(txtPass);
		
		txtCPass = new JPasswordField();
		txtCPass.setBounds(211, 200, 235, 28);
		panel.add(txtCPass);
	}
}
