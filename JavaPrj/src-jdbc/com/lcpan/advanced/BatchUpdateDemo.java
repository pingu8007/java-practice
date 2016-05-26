package com.lcpan.advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import moe.pingu.iii.jdbc.DB;

public class BatchUpdateDemo {
	public static void main(String[] args) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DB.url_jdbc, DB.user, DB.pass);

			String qryStmt = "SELECT empno, salary FROM employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();

			String updateStmt = "UPDATE employee SET salary = ? WHERE empno = ?";
			pstmt = conn.prepareStatement(updateStmt);
			int cmdCount = 0;
			int[] result;
			while (rs.next()) {
				pstmt.setDouble(1, rs.getDouble(2) * 1.1);
				pstmt.setInt(2, rs.getInt(1));
				pstmt.addBatch();
				cmdCount++;
				if (cmdCount > 4) {
					cmdCount = 0;
					result = pstmt.executeBatch();
					for (int i : result)
						System.out.print(i);
					System.out.print("\n");
				}
			}
			result = pstmt.executeBatch();
			for (int i : result)
				System.out.print(i);
			System.out.print("\n");

			qryStmt = "SELECT ename, salary FROM employee";
			pstmt = conn.prepareStatement(qryStmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("name = " + rs.getString("ename"));
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class BatchUpdateDemo
