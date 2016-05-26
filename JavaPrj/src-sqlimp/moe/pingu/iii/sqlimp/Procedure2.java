package moe.pingu.iii.sqlimp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import moe.pingu.iii.jdbc.DB;

public class Procedure2 {

	public static void main(String[] args) {
		insertPlaylist("2016-12-25 13:00", 1, "A廳");
	}

	public static void insertPlaylist(String pTime, int movieId, String room) {
		try (Connection conn = DriverManager.getConnection(DB.url_db01, DB.user, DB.pass);) {
			String insStmt = "";
			CallableStatement cstmt = null;

			insStmt = "{call gen_seats(?, ?, ?)}";
			cstmt = conn.prepareCall(insStmt);
			cstmt.setString(1, pTime);
			cstmt.setInt(2, movieId);
			cstmt.setString(3, room);
			
			conn.setAutoCommit(false);
			
			cstmt.execute();

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
