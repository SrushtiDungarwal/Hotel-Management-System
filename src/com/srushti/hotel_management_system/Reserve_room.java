package com.srushti.hotel_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Reserve_room {

	public static void reserveRoom(Connection con, Scanner sc ) {

		System.out.println("Enter Guest name: ");
		String guestName = sc.next();
		sc.nextLine();

		System.out.println("Enter Room Number: ");
		int roomNo = sc.nextInt();

		System.out.println("Enter Contact Number: ");
		String contact = sc.next();

		String sql = "INSERT INTO reservations(Guest_name, Room_no, Contact_number) VALUES (?,?,?)";

		try (PreparedStatement prestmt = con.prepareStatement(sql)){
			prestmt.setString(1, guestName);
			prestmt.setInt(2, roomNo);
			prestmt.setString(3, contact);
			int rowaffected = prestmt.executeUpdate();

			if (rowaffected > 0) {
				System.out.println("Reservation Sucessfull!");
			} else {
				System.out.println("Reservation Failed!");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
