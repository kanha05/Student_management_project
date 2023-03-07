
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josphat Wanjiru
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Josphat Wanjiru
 */
public class connect {
	static PreparedStatement pre = null;
	static Connection conn = null;

	/**
	 * Connect to database
	 */
	public static Connection ConnectDb() {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/student_management", "root",
					"");
			return conn;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 *
	 * @return
	 * @throws Exception
	 */
	public static Vector getStudents() throws Exception {
		conn = ConnectDb();
		pre = conn.prepareStatement("select * from tbl_users");

		ResultSet rs = pre.executeQuery();
		Vector<Vector<String>> studentVector = new Vector<Vector<String>>();

		while (rs.next()) {
			Vector<String> student = new Vector<String>();
			student.add(rs.getString(1));
			student.add(rs.getString(2));
			student.add(rs.getString(3));
			student.add(rs.getString(4));
			student.add(rs.getString(5));
			student.add(rs.getString(6));
			student.add(rs.getString(7));
			student.add(rs.getString(8));
			student.add(rs.getString(9));
			student.add(rs.getString(10));
//
			studentVector.add(student);
		}

		/* Close the connection after use (MUST) */
		if (conn != null)
			conn.close();

		return studentVector;
	}
}
//	public static Vector getstudents() throws Exception {
//		conn = ConnectDb();
//		pre = conn.prepareStatement("select * from rooms");
//
//		ResultSet rs = pre.executeQuery();
//		Vector<Vector<String>> roomsVector = new Vector<Vector<String>>();
//
//		while (rs.next()) {
//			Vector<String> rooms = new Vector<String>();
//			rooms.add(rs.getString(1));
//			rooms.add(rs.getString(2));
//
//			/*
//			 * rooms.add(rs.getString(3)); rooms.add(rs.getString(4));
//			 */
//
////
//			roomsVector.add(rooms);
//		}
//
//		/* Close the connection after use (MUST) */
//		if (conn != null)
//			conn.close();
//
//		return roomsVector;
//	}
//}