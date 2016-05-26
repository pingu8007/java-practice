package com.lcpan.advanced;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import moe.pingu.iii.jdbc.DB;

public class BatchUpdateDemo2 {
	public static void main(String[] args) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DB.url_jdbc, DB.user, DB.pass);
			int cmdCount = 0;

			PreparedStatement pstmt, pstmtdel;
			ResultSet rs;
			File path = new File(args[0]);
			if (path.exists() && path.isDirectory()) {
				pstmt = conn.prepareStatement("SELECT * FROM blobtest WHERE name = ?");
				pstmtdel = conn.prepareStatement("DELETE FROM blobtest WHERE name = ?");
				cmdCount = 0;
				for (File file : path.listFiles()) {
					pstmt.setString(1, file.getPath());
					rs = pstmt.executeQuery();
					if (rs.next()) {
						pstmtdel.setString(1, file.getPath());
						pstmtdel.addBatch();
						cmdCount++;
						if (cmdCount > 5) {
							pstmtdel.executeBatch();
							cmdCount = 0;
						}
					}
				}
				pstmtdel.executeBatch();

				pstmt = conn.prepareStatement("INSERT INTO blobtest VALUES(?,?)");
				cmdCount = 0;
				for (File file : path.listFiles()) {
					FileInputStream fis = new FileInputStream(file);
					pstmt.setString(1, file.getPath());
					pstmt.setBinaryStream(2, fis, file.length());
					pstmt.addBatch();
					System.out.print("Processing ");
					System.out.print(file.getPath());
					System.out.print("\n");
					cmdCount++;
					if (cmdCount > 2) {
						pstmt.executeBatch();
						cmdCount = 0;
					}
					// fis.close();
				}
				pstmt.executeBatch();
			}

			// pstmt = conn.prepareStatement("SELECT ename, salary FROM
			// employee");
			// rs = pstmt.executeQuery();
			// while (rs.next()) {
			// System.out.println("name = " + rs.getString("ename"));
			// System.out.println("salary = " + rs.getDouble("salary"));
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}// end
		// of
		// main()
}// end of class BatchUpdateDemo
