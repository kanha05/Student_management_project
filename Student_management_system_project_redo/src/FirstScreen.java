import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FirstScreen   {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstScreen window = new FirstScreen();
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
	public FirstScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Student Management System");
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin or Student");
		lblNewLabel.setBounds(0, 11, 436, 29);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBackground(new Color(245, 245, 245));
		btnAdmin.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[] {});
				frame.dispose();
			}
		});
		btnAdmin.setBounds(142, 72, 143, 43);
		frame.getContentPane().add(btnAdmin);
		
		JButton btnStu = new JButton("Student");
		btnStu.setBackground(new Color(245, 245, 245));
		btnStu.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnStu.setBounds(142, 164, 143, 43);
		btnStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[] {});
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnStu);
	}


}
