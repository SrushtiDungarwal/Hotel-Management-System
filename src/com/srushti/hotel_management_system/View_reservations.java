package com.srushti.hotel_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class View_reservations {

	public static void veiwReservation(Connection con) {

		String sql = "SELECT * FROM reservations";
		try (PreparedStatement prestmt = con.prepareStatement(sql)){
			ResultSet rs = prestmt.executeQuery(sql);

			System.out.println("Current Reservations:");
			System.out.println(
					"+----------------+-----------------+---------------+----------------------+-------------------------+");
			System.out.println(
					"| Reservation ID | Guest           | Room Number   | Contact Number       | Reservation Date        |");
			System.out.println(
					"+----------------+-----------------+---------------+----------------------+-------------------------+");

//			Reservation_ID | Guest_name | Room_no | Contact_number | Reservation_date
			while (rs.next()) {

				int id = rs.getInt("Reservation_ID");
				String name = rs.getString("Guest_name");
				int roomNo = rs.getInt("Room_no");
				String mobNo = rs.getString("Contact_number");
				String date = rs.getString("Reservation_date");
				System.out.printf("| %-14d | %-15s | %-13d | %-20s | %-19s     |\n", id, name, roomNo, mobNo, date);
				System.out.println(
						"+----------------+-----------------+---------------+----------------------+-------------------------+");

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
