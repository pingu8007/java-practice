package com.lcpan.basic;

import java.sql.*;

import moe.pingu.iii.jdbc.DB;

// delete a employee data
public class DeleteDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			conn = DriverManager.getConnection(DB.url_jdbc, DB.user, DB.pass);
			
			String delStmt = "DELETE employee WHERE empno=?";
			PreparedStatement pstmt = conn.prepareStatement(delStmt);
			pstmt.setInt(1, 1009);
			int num = pstmt.executeUpdate();
			System.out.println("delete count = " + num);
			
			pstmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class DeleteDemo
