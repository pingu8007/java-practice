package com.lcpan.basic;

import java.sql.*;
import moe.pingu.iii.jdbc.DB;

// Query all employees using PrepareStatement
public class QueryDemo4 {
	public static void main(String[] args) {
		String qryStmt = "SELECT ename, salary FROM employee";
		try (Connection conn = DriverManager.getConnection(DB.url_jdbc, DB.user, DB.pass);
				PreparedStatement pstmt = conn.prepareStatement(qryStmt);) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of main()
}// end of class QueryDemo4
