package com.srushti.hotel_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Get_room_no {
	
	public static void getRoomNumber(Connection con, Scanner sc) throws SQLException {

		System.out.println("Enter Reservation Id : ");
		int id = sc.nextInt();
		System.out.println("Enter Guest name: ");
		String name = sc.next();

		String sql = "SELECT Room_no from reservations WHERE Reservation_ID = ? AND Guest_name = ?";

		try (PreparedStatement prestmt = con.prepareStatement(sql)){
			prestmt.setInt(1, id);
			prestmt.setString(2, name);
			ResultSet rs = prestmt.executeQuery();

			if (rs.next()) {
				int roomNo = rs.getInt("Room_No");
				System.out
						.println("Room number for reservation Id " + id + " and guest name " + name + " is: " + roomNo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


}
}
