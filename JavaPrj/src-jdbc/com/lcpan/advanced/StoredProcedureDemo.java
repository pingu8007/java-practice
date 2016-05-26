package com.lcpan.advanced;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import moe.pingu.iii.jdbc.DB;

// Update employee data with CallableStatement
public class StoredProcedureDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB.url_jdbc, DB.user, DB.pass);

			CallableStatement cstmt = conn.prepareCall("{call upd_emp_salary(?, ?)}");
			cstmt.setDouble(1, 44000);
			cstmt.setInt(2, 1002);
			cstmt.execute();

			cstmt = conn.prepareCall("{call qry_emp(?,?,?)}");
			cstmt.setInt(1, 1002);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.DOUBLE);
			cstmt.execute();
			String ename = cstmt.getString(2);
			double salary = cstmt.getDouble(3);

			System.out.print("name = " + ename + ", ");
			System.out.println("salary = " + salary);

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
}// end of class StoredProcedureDemo
