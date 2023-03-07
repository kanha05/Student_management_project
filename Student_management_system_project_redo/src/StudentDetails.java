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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class StudentDetails {

	private JFrame frame,frame1;
	private JTextField txtid;
	//private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails window = new StudentDetails();
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
	public StudentDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Veiw Student Info");
		frame.setBounds(100, 100, 650, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(0, 0, 736, 383);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel StuLogin = new JLabel("Enter Your Student Id to view details");
		StuLogin.setForeground(Color.BLUE);
		StuLogin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		StuLogin.setBounds(56, 0, 575, 61);
		panel.add(StuLogin);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtid.setBounds(56, 72, 500, 50);
		panel.add(txtid);
		txtid.setColumns(10);
		
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstScreen.main(new String[] {} );
				frame.dispose();
			}
		});
		btnback.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnback.setBounds(120, 150, 131, 32);
		panel.add(btnback);
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame1 = new JFrame("Veiw Student Info");
//				frame1.setBounds(100, 100, 650, 420);
//				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				frame1.getContentPane().setLayout(null);
				
				try {
					
					
					String stu_id = txtid.getText();

					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3366/student_management", "root",
							"");
					PreparedStatement ps = con.prepareStatement("select * from tbl_users where Student_id=?");

					ps.setString(1, stu_id);
					ResultSet rs = ps.executeQuery();
					if (stu_id.equals(stu_id)) {

						int i = 0;
						while (rs.next()) {
							
//							JLabel StuLogin = new JLabel("Enter Your Student Id to view details");
//							StuLogin.setForeground(Color.BLUE);
//							StuLogin.setFont(new Font("Times New Roman", Font.BOLD, 25));
//							StuLogin.setBounds(56, 0, 175, 61);
//							panel.add(StuLogin);
							
							JLabel info1 = new JLabel("Student_id    : " + rs.getString("Student_id"));
							JLabel info2 = new JLabel("First name    : " + rs.getString("First_name"));
							JLabel info3 = new JLabel("Last name     : " + rs.getString("Last_name"));
							JLabel info4 = new JLabel("Gender        : " + rs.getString("Gender"));
							JLabel info5 = new JLabel("Date of birth : " + rs.getString("Date_of_birth"));
							JLabel info6 = new JLabel("Father name   : " + rs.getString("Father_name"));
							JLabel info7 = new JLabel("Mother name   : " + rs.getString("Mother_name"));
							JLabel info8 = new JLabel("Email         : " + rs.getString("Email"));
							JLabel info9 = new JLabel("Address       : " + rs.getString("Address"));
							JLabel info10= new JLabel("Phone number  : " + rs.getString("Phone_number"));
							
							JLabel l1 = new JLabel("*** Student Details ***");
							l1.setBounds(30,10,300,61);
							l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
							frame1.add(l1);
							
							info1.setBounds(56, 50, 300, 61);
							info1.setFont(new Font("Tahoma", Font.PLAIN, 20));
							frame1.add(info1);
							
							info2.setBounds(56, 80, 300, 61);
							info2.setFont(new Font("Tahoma", Font.PLAIN, 20));
							frame1.add(info2);
							
							info3.setBounds(56, 110, 300, 61);
							info3.setFont(new Font("Tahoma", Font.PLAIN, 20));
							frame1.add(info3);
							
							info4.setBounds(56, 140, 300, 61);
							info4.setFont(new Font("Tahoma", Font.PLAIN, 20));
							frame1.add(info4);
							
							info5.setBounds(56, 170, 300, 61);
							info5.setFont(new Font("Tahoma", Font.PLAIN, 20));
							frame1.add(info5);
							
							info6.setBounds(56, 200, 300, 61);
							info6.setFont(new Font("Tahoma", Font.PLAIN, 20));
							frame1.add(info6);
							
							info7.setBounds(56, 230, 300, 61);
							info7.setFont(new Font("Tahoma", Font.PLAIN, 20));
							frame1.add(info7);
							
							info8.setBounds(56, 260, 300, 61);
							info8.setFont(new Font("Tahoma", Font.PLAIN, 20));
							frame1.add(info8);
							
							info9.setBounds(56, 290, 300, 61);
							info9.setFont(new Font("Tahoma", Font.PLAIN, 20));
							frame1.add(info9);
							
							info10.setBounds(56, 310, 300, 61);
							info10.setFont(new Font("Tahoma", Font.PLAIN, 20));
							frame1.add(info10);
							
							// txtPhone.setText(h);

							// System.out.println(s1+","+s2+","+s3+","+s4+","+s5+","+s6+","+s7+","+s8);
							// JOptionPane.showMessageDialog(btnShowData, "Data display Successfully");
							//model.addRow(new Object[] { s1, s2, s3, s4, s5, s6, s7, s8, s9, s10 });
							i++;
							JButton btnback1 = new JButton("Back");
							btnback1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									StudentDetails.main(new String[] {} );
									frame1.dispose();
								}
							});
							btnback1.setFont(new Font("Times New Roman", Font.BOLD, 20));
							btnback1.setBounds(450, 360, 131, 32);
							frame1.add(btnback1);
						}
					}
					con.close();
					ps.close();

				} catch (Exception ex) {
					// TODO Auto-generated catch block
					System.out.println(ex);
				}
				frame1.setSize(700, 700);
				frame1.setLayout(null);
				frame1.setVisible(true);
				frame1.setResizable(true);
				frame.dispose();
			}
		});
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNext.setBounds(350, 150, 131, 32);
		panel.add(btnNext);
		
		
	}
}
