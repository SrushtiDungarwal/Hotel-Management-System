package com.srushti.hotel_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_reservation {

	public static void updateReservation(Connection con, Scanner sc) {

		String sql = "UPDATE reservations SET guest_name = ?, room_no = ?, contact_number = ? WHERE reservation_id = ?";
		
		try (PreparedStatement prestmt = con.prepareStatement(sql)){
			System.out.println("Enter the Reservation Id: ");
			int id = sc.nextInt();
			sc.nextLine();

			if (!Reservation_exist.reservationExists(con, id)) {
				System.out.println("Reservation not found for the given ID.");
				return;
			}
			System.out.print("Enter new guest name: ");
			String newGuestName = sc.nextLine();
			System.out.print("Enter new room number: ");
			int newRoomNumber = sc.nextInt();
			System.out.print("Enter new contact number: ");
			String newContactNumber = sc.next();


			prestmt.setString(1, newGuestName);
			prestmt.setInt(2, newRoomNumber);
			prestmt.setString(3, newContactNumber);
			prestmt.setInt(4, id);
			int affectedRows = prestmt.executeUpdate();

			if (affectedRows > 0) {
				System.out.println("Reservation updated successfully!");
			} else {
				System.out.println("Reservation update failed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
