package com.srushti.hotel_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Hotel_management {

	private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
	private static final String username = "root";
	private static final String password = "Srushtid@2002";
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			Connection con = DriverManager.getConnection(url, username, password);

			while (true) {
				System.out.println();
				System.out.println("HOTEL MANAGEMENT SYSTEM.");
				Scanner sc = new Scanner(System.in);
				System.out.println("1. Reserve a room.");
				System.out.println("2. View Reservations.");
				System.out.println("3. Get Room Number.");
				System.out.println("4. Update Reservation");
				System.out.println("5. Delete Reservation.");
				System.out.println("0. Exit.");
				System.out.println("Choose an option: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					Reserve_room.reserveRoom(con, sc);
					break;
				case 2:
					View_reservations.veiwReservation(con);
					break;
				case 3:
					Get_room_no.getRoomNumber(con, sc);
					break;
				case 4:
					Update_reservation.updateReservation(con, sc);
					break;
				case 5:
					Delete_reservation.deleteReservation(con, sc);
					break;
				case 0:
					Exit_menu.exit();
					sc.close();
					return;
				default:
					System.out.println("Invalid Choice. Try Again!!");
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
