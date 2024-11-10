package com.srushti.hotel_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete_reservation {

	public static void deleteReservation(Connection con, Scanner sc) {

		String sql = "DELETE FROM reservations WHERE reservation_id = ? ";
		
		try (PreparedStatement prestmt = con.prepareStatement(sql)){
			System.out.println("Enter the Reservation Id: ");
			int id = sc.nextInt();
			sc.nextLine();

			if (!Reservation_exist.reservationExists(con, id)) {
				System.out.println("Reservation not found for the given ID.");
				return;
			}

			prestmt.setInt(1, id);
			int rowaffected = prestmt.executeUpdate();
			if (rowaffected > 0) {
				System.out.println("Reservation deleted successfully!");
			} else {
				System.out.println("Reservation deletion failed!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
