import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JDateChooser;

//import com.toedter.calendar.JDateChooser;

public class StudentManagement extends JFrame implements ActionListener {

	private JFrame frame, frame1;
	private final JPanel panel = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private JTextField txtID;
	private JTextField textFname;
	private JTextField textLname;
	private JTextField txtFaName;
	private JTextField txtMoName;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField textSearch;
	private JTable table;
	JButton btnAdd, btnDelete, btnShowData, btnUpdate, btnClear;
	JButton btnLogOut;
	JScrollPane scroll;
	JPanel panel_5;
	JComboBox Bgender;
	JDateChooser dateChooser;
	JButton btnNewButton;
	DefaultTableModel model;

	/**
	 * Create the application.
	 */
	public StudentManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(0, 0, 1283, 700);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1273, 64);
		panel_1.setBorder(new LineBorder(new Color(0, 255, 255), 4));
		panel_1.setBackground(new Color(127, 255, 212));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblStu = new JLabel("Student Management System");
		lblStu.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblStu.setBounds(10, 11, 434, 42);
		panel_1.add(lblStu);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		tabbedPane.setBounds(10, 63, 1263, 626);
		panel.add(tabbedPane);
		panel_2.setBackground(new Color(128, 255, 255));
		tabbedPane.addTab("Student", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(127, 255, 212));
		panel_3.setBounds(0, 0, 535, 587);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		txtID = new JTextField();
		txtID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtID.setBounds(199, 24, 295, 30);
		panel_3.add(txtID);
		txtID.setColumns(10);

		textFname = new JTextField();
		textFname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textFname.setBounds(199, 69, 295, 30);
		panel_3.add(textFname);
		textFname.setColumns(10);

		Bgender = new JComboBox();
		Bgender.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		Bgender.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Bgender.setBounds(199, 168, 133, 30);
		panel_3.add(Bgender);

		textLname = new JTextField();
		textLname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textLname.setBounds(199, 118, 295, 30);
		panel_3.add(textLname);
		textLname.setColumns(10);

		txtFaName = new JTextField();
		txtFaName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtFaName.setBounds(199, 270, 295, 30);
		panel_3.add(txtFaName);
		txtFaName.setColumns(10);

		txtMoName = new JTextField();
		txtMoName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMoName.setBounds(199, 325, 295, 30);
		panel_3.add(txtMoName);
		txtMoName.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(199, 380, 295, 30);
		panel_3.add(txtEmail);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtAddress.setColumns(10);
		txtAddress.setBounds(199, 423, 295, 30);
		panel_3.add(txtAddress);

		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtPhone.setColumns(10);
		txtPhone.setBounds(199, 478, 295, 30);
		panel_3.add(txtPhone);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(199, 218, 295, 30);
		panel_3.add(dateChooser);

		JLabel student_ID = new JLabel("Student ID :");
		student_ID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		student_ID.setBounds(31, 24, 93, 30);
		panel_3.add(student_ID);

		JLabel Fname = new JLabel("First Name :");
		Fname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Fname.setBounds(31, 69, 93, 30);
		panel_3.add(Fname);

		JLabel Lname = new JLabel("Last Name :");
		Lname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Lname.setBounds(31, 118, 93, 30);
		panel_3.add(Lname);

		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		gender.setBounds(31, 168, 93, 30);
		panel_3.add(gender);

		JLabel dob = new JLabel("Date od Birthday :");
		dob.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		dob.setBounds(31, 218, 145, 30);
		panel_3.add(dob);

		JLabel FaName = new JLabel("Father's Name :");
		FaName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		FaName.setBounds(31, 270, 145, 30);
		panel_3.add(FaName);

		JLabel MoName = new JLabel("Mother's Name :");
		MoName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		MoName.setBounds(31, 325, 145, 30);
		panel_3.add(MoName);

		JLabel email = new JLabel("Email :");
		email.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		email.setBounds(31, 380, 93, 30);
		panel_3.add(email);

		JLabel address = new JLabel("Address :");
		address.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		address.setBounds(31, 423, 93, 30);
		panel_3.add(address);

		JLabel phone = new JLabel("Mobile Phone :");
		phone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		phone.setBounds(31, 478, 133, 30);
		panel_3.add(phone);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(173, 216, 230));
		panel_4.setBounds(10, 529, 513, 47);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		btnAdd = new JButton("Add ");
		btnAdd.setBackground(new Color(127, 255, 212));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAdd.setBounds(10, 11, 89, 25);
		panel_4.add(btnAdd);
		btnAdd.addActionListener(this);

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDelete.setBackground(new Color(127, 255, 212));
		btnDelete.setBounds(112, 11, 89, 25);
		panel_4.add(btnDelete);
		btnDelete.addActionListener(this);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnUpdate.setBackground(new Color(127, 255, 212));
		btnUpdate.setBounds(211, 11, 89, 25);
		panel_4.add(btnUpdate);
		btnUpdate.addActionListener(this);

		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnClear.setBackground(new Color(127, 255, 212));
		btnClear.setBounds(310, 11, 89, 25);
		panel_4.add(btnClear);
		btnClear.addActionListener(this);

		btnLogOut = new JButton("Log Out");
	
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogOut.setBackground(new Color(127, 255, 212));
		btnLogOut.setBounds(406, 11, 97, 25);
		panel_4.add(btnLogOut);
		btnLogOut.addActionListener(this);

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(127, 255, 212));
		panel_5.setBounds(545, 0, 713, 587);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 255, 255), 4));
		panel_6.setBackground(new Color(175, 238, 238));
		panel_6.setBounds(10, 10, 695, 90);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblsearch = new JLabel("Search by ID :");
		lblsearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblsearch.setBounds(10, 11, 140, 38);
		panel_6.add(lblsearch);

		textSearch = new JTextField();
		textSearch.setBounds(159, 11, 300, 38);
		panel_6.add(textSearch);
		textSearch.setColumns(10);

		btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(480, 11,85,38);
		panel_6.add(btnNewButton);
		btnNewButton.addActionListener(this);

		btnShowData = new JButton("Display All");
		btnShowData.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnShowData.setBounds(580, 11, 100, 38);
		panel_6.add(btnShowData);
		btnShowData.addActionListener(this);
	}
	void showdata() {
		String[] columnNames = { "ID", "First Name", "Last Name", "Gender", "Date of Birth", "Father", "Mother",
				"Email", "Address", "Phone" };

		//frame = new JFrame("Database Search Result");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(new BorderLayout());
		// TableModel tm = new TableModel();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		// DefaultTableModel model = new DefaultTableModel(tm.getData1(),
		// tm.getColumnNames());
		// table = new JTable(model);
		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFillsViewportHeight(true);
		scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(10, 100, 695, 495);
		panel_5.add(scroll);
		
		
		
	}
	public void refresh() throws SQLException{
	    String sql = "SELECT * FROM tbl_users ";
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3366/student_management", "root",
				"");
	    PreparedStatement ps = con.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));
	}

	public void actionPerformed(ActionEvent e1) {
		if (e1.getSource() == btnAdd) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String s1 = txtID.getText();
				String s2 = textFname.getText();
				String s3 = textLname.getText();
				String s4 = Bgender.getSelectedItem().toString();
				String s5 = dateFormat.format(dateChooser.getDate());
				String s6 = txtFaName.getText();

				String s7 = txtMoName.getText();
				String s8 = txtEmail.getText();
				String s9 = txtAddress.getText();
				String s10 = txtPhone.getText();

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3366/student_management", "root",
						"");
				PreparedStatement ps = con.prepareStatement(
						"insert into tbl_users(Student_id, First_name, Last_name,Gender,Date_of_birth, Father_name, Mother_name, Email, Address, Phone_number)values(?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, s1);
				ps.setString(2, s2);
				ps.setString(3, s3);
				ps.setString(4, s4);
				ps.setString(5, s5);
				ps.setString(6, s6);
				ps.setString(7, s7);
				ps.setString(8, s8);
				ps.setString(9, s9);
				ps.setString(10, s10);

				ps.executeUpdate();
				JOptionPane.showMessageDialog(btnAdd, "Data Saved Successfully");
				refresh();
				con.close();
				ps.close();
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				System.out.println(ex);
			}
			
		}
		if (e1.getSource() == btnDelete) {
			try {
				String del_id  = JOptionPane.showInputDialog("Input student id to delete: ");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3366/student_management", "root",
						"");
				PreparedStatement ps = con.prepareStatement("delete from tbl_users where Student_id = ?");
				
				JOptionPane.showConfirmDialog(null, "Confirm if you want to delete student", "Warning",
						JOptionPane.YES_NO_OPTION);
				int opt = 0;
				if (opt == JOptionPane.YES_OPTION) {
				ps.setString(1, del_id);
				int k=ps.executeUpdate();
				if(k==1) {
						JOptionPane.showMessageDialog(btnDelete, "Data delete Successfully");
						refresh();
						con.close();
						ps.close();
					}
				 
				else {
					JOptionPane.showMessageDialog(btnDelete, "Student id not found");	
				}
				}
//				con.close();
//				ps.close();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		if (e1.getSource() == btnUpdate) {
			try {
				String Up_id = JOptionPane.showInputDialog("Input student id to Update: ");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3366/student_management", "root",
						"");
				
				PreparedStatement ps = con.prepareStatement("update tbl_users set Student_id=?, First_name=?,Last_name=?,Gender=?,Date_of_birth=?,"
						+ "Father_name=?,Mother_name=?,Email=?,Address=?,Phone_number=? where Student_id=?");

					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					
					ps.setString(1, txtID.getText());
		            ps.setString(2,textFname.getText());
		            ps.setString(3,textLname.getText());
		            ps.setString(4,Bgender.getSelectedItem().toString());
		            ps.setString(5,dateFormat.format(dateChooser.getDate()));
		            ps.setString(6,txtFaName.getText());
		            ps.setString(7,txtMoName.getText());
		            ps.setString(8,txtEmail.getText());
		            ps.setString(9,txtAddress.getText());
		            ps.setString(10,txtPhone.getText());
//		            ps.setString(10, txtID.getText());

	        	            JOptionPane.showConfirmDialog(null, "Confirm if you want to Update this student data", "Warning",
	    							JOptionPane.YES_NO_OPTION);
	    					int opt = 0;
	        	            if (opt == JOptionPane.YES_OPTION) {
	        	            	ps.setString(11, Up_id);
	        					int k=ps.executeUpdate();
	        					if (k==1) {
	        						JOptionPane.showMessageDialog(null, "Updated Successfully :)");
	        						refresh();
	        						con.close();
	        						ps.close();
	        					}
				}
//				con.close();
//				ps.close();

			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	

		if (e1.getSource() == btnNewButton) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String s1 = txtID.getText();
				String s2 = textFname.getText();
				String s3 = textLname.getText();
				String s4 = Bgender.getSelectedItem().toString();
				String s5 = dateFormat.format(dateChooser.getDate());
				String s6 = txtFaName.getText();

				String s7 = txtMoName.getText();
				String s8 = txtEmail.getText();
				String s9 = txtAddress.getText();
				String s10 = txtPhone.getText();
				
				showdata();
				
				String search_id = textSearch.getText();

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3366/student_management", "root",
						"");
				PreparedStatement ps = con.prepareStatement("select * from tbl_users where Student_id=?");

				ps.setString(1, search_id);
				ResultSet rs = ps.executeQuery();
				if (search_id.equals(search_id)) {

					int i = 0;
					while (rs.next()) {
						s1 = rs.getString("Student_id");
						// txtID.setText(a);
						s2 = rs.getString("First_name");
						// textFname.setText(b);
						s3 = rs.getString("Last_name");
						// textLname.setText(c);
						s4 = rs.getString("Gender");
						s5 = rs.getString("Date_of_birth");
						s6 = rs.getString("Father_name");
						// txtFaName.setText(d);
						s7 = rs.getString("Mother_name");
						// txtMoName.setText(e);
						s8 = rs.getString("Email");
						// txtEmail.setText(f);
						s9 = rs.getString("Address");
						// txtAddress.setText(g);
						s10 = rs.getString("Phone_number");
						// txtPhone.setText(h);

						// System.out.println(s1+","+s2+","+s3+","+s4+","+s5+","+s6+","+s7+","+s8);
						// JOptionPane.showMessageDialog(btnShowData, "Data display Successfully");
						model.addRow(new Object[] { s1, s2, s3, s4, s5, s6, s7, s8, s9, s10 });
						i++;
					}
					
				}
				else {
					JOptionPane.showMessageDialog(btnAdd, "Student id not found");
				}
				con.close();
				ps.close();

			} catch (Exception ex) {
				// TODO Auto-generated catch block
				System.out.println(ex);
			}
//			scroll.setBounds(10, 100, 695, 495);
//			panel_5.add(scroll);
		}
		
		if (e1.getSource() == btnClear) {
			
			txtID.setText("");
			textFname.setText("");
			textLname.setText("");
			Bgender.setSelectedItem("");
            //dateChooser.setDate(null);
//	        	Bgender.contains(null);
//	        	dateChooser.contains(null);
			txtFaName.setText("");
			txtMoName.setText("");
			txtEmail.setText("");
			txtAddress.setText("");
			txtPhone.setText("");
		}
		if (e1.getSource() == btnLogOut ) {
			FirstScreen.main(new String[] {});
			frame.dispose();
		}
			

		if (e1.getSource() == btnShowData) {
			showdata();

			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String s1 = txtID.getText();
				String s2 = textFname.getText();
				String s3 = textLname.getText();
				String s4 = Bgender.getSelectedItem().toString();
				String s5 = dateFormat.format(dateChooser.getDate());
				String s6 = txtFaName.getText();

				String s7 = txtMoName.getText();
				String s8 = txtEmail.getText();
				String s9 = txtAddress.getText();
				String s10 = txtPhone.getText();

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3366/student_management", "root",
						"");
				PreparedStatement ps = con.prepareStatement("select * from tbl_users");
				ResultSet rs = ps.executeQuery();

				int i = 0;
				while (rs.next()) {
					s1 = rs.getString("Student_id");
					// txtID.setText(a);
					s2 = rs.getString("First_name");
					// textFname.setText(b);
					s3 = rs.getString("Last_name");
					// textLname.setText(c);
					s4 = rs.getString("Gender");
					s5 = rs.getString("Date_of_birth");
					s6 = rs.getString("Father_name");
					// txtFaName.setText(d);
					s7 = rs.getString("Mother_name");
					// txtMoName.setText(e);
					s8 = rs.getString("Email");
					// txtEmail.setText(f);
					s9 = rs.getString("Address");
					// txtAddress.setText(g);
					s10 = rs.getString("Phone_number");
					// txtPhone.setText(h);

					// System.out.println(s1+","+s2+","+s3+","+s4+","+s5+","+s6+","+s7+","+s8);
					// JOptionPane.showMessageDialog(btnShowData, "Data display Successfully");
					model.addRow(new Object[] { s1, s2, s3, s4, s5, s6, s7, s8, s9, s10 });
					i++;
				}
				con.close();
				ps.close();

			} catch (Exception ex) {
				// TODO Auto-generated catch block
				System.out.println(ex);
			}

		} else {
			txtID.setText("");
			textFname.setText("");
			textLname.setText("");
			Bgender.setSelectedItem("");
            //dateChooser.setDate(null);
			txtFaName.setText("");
			txtMoName.setText("");
			txtEmail.setText("");
			txtAddress.setText("");
			txtPhone.setText("");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				StudentManagement window = new StudentManagement();
				window.frame.setVisible(true);
			}
		});
	}

}
