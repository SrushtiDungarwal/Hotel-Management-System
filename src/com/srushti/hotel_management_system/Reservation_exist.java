package com.srushti.hotel_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservation_exist {

	public static boolean reservationExists(Connection con, int id) {

		String sql = "SELECT reservation_id FROM reservations WHERE reservation_id = ?";
		
		try (PreparedStatement prestmt = con.prepareStatement(sql)){

			prestmt.setInt(1, id);
			ResultSet rs = prestmt.executeQuery();
			return rs.next(); // If there's a result, the reservation exists

		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Handle database errors as needed
		}
	}

}

