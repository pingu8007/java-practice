package moe.pingu.iii.sqlimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import moe.pingu.iii.jdbc.DB;

public class Procedure1 {

	public static void main(String[] args) {
		insertPlaylist("2016-12-25 13:00", 1, "A廳");
	}
/*
	@Deprecated
	public static void querySeatsByRoom(String room) {
		try (Connection conn = DriverManager.getConnection(DB.url_db01, DB.user, DB.pass);) {
			String insStmt = "SELECT roomid, seat_row, seat_col FROM m_room WHERE roomid = ?";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			pstmt.setString(1, room);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("roomid") + " HAS ");
				System.out.println(rs.getInt("seat_row") + " * " + rs.getInt("seat_col"));
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			if (e.getErrorCode() == 2627
					&& e.getClass().getName() == "com.microsoft.sqlserver.jdbc.SQLServerException") {
				System.out.println("Duplicated!!");
			}
		}
	}
*/
	public static void insertPlaylist(String pTime, int movieId, String room) {
		try (Connection conn = DriverManager.getConnection(DB.url_db01, DB.user, DB.pass);) {
			String insStmt = "";
			PreparedStatement pstmt = null;
			SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date time = timeformat.parse(pTime);

			insStmt = "SELECT roomid, seat_row, seat_col FROM m_room WHERE roomid = ?";
			pstmt = conn.prepareStatement(insStmt);
			pstmt.setString(1, room);
			ResultSet rs = pstmt.executeQuery();
			
			conn.setAutoCommit(false);
			
			insStmt = "INSERT INTO playlist (ptime, movie, roomid) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(insStmt);
			pstmt.setTimestamp(1, java.sql.Timestamp.from(time.toInstant()));
			pstmt.setInt(2, movieId);
			pstmt.setString(3, room);
			pstmt.executeUpdate();

			insStmt = "INSERT INTO seats (ptime, movie, seat_num, sold, ordid) VALUES (?, ?, ?, '0', null)";
			pstmt = conn.prepareStatement(insStmt);
			while (rs.next()) {
				pstmt.setTimestamp(1, java.sql.Timestamp.from(time.toInstant()));
				pstmt.setInt(2, movieId);
				for (int row = 1; row <= rs.getInt(2); row++) {
					for (int col = 1; col <= rs.getInt(3); col++) {
						pstmt.setString(3, String.format("%1$02d-%2$02d", row, col));
						pstmt.addBatch();
					}
				}
				pstmt.executeBatch();
			}
			
			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
/*
	@Deprecated
	public static int insertSeats(String pTime, int movieId, String room) {
		try (Connection conn = DriverManager.getConnection(DB.url_db01, DB.user, DB.pass);) {
			String insStmt = "INSERT INTO seats (ptime, movie, seat_num, sold, ordid) VALUES (?, ?, ?, '0', null)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			Instant ts = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("pTime").toInstant();
			pstmt.setTimestamp(1, java.sql.Timestamp.from(ts));
			pstmt.setInt(2, movieId);
			pstmt.setString(3, room);

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			if (e.getErrorCode() == 2627
					&& e.getClass().getName() == "com.microsoft.sqlserver.jdbc.SQLServerException") {
				System.out.println("Duplicated!!");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}
*/
}
