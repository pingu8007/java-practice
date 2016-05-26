package com.lcpan.basic;

import java.sql.*;

import moe.pingu.iii.jdbc.DB;

// Insert one employee
public class InsertDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB.url_jdbc, DB.user, DB.pass);

			String insStmt = "INSERT INTO employee VALUES (?, ?, convert(datetime,getDate()), ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			pstmt.setInt(1, 1009);
			pstmt.setString(2, "Jean Tsao");
			// pstmt.setString(3, "2008/10/10");
			// pstmt.setDate(3, new java.sql.Date(new
			// java.util.Date().getTime()));
			pstmt.setDouble(3, 55000);
			pstmt.setInt(4, 100);
			pstmt.setString(5, "senior engineer");

			int num = pstmt.executeUpdate();
			System.out.println("insert count = " + num);

			pstmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			if (e.getErrorCode() == 2627 && e.getClass().getName() == "com.microsoft.sqlserver.jdbc.SQLServerException"){
				System.out.println("Duplicated!!");
			}
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class InsertDemo
