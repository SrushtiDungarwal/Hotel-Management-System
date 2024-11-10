package com.srushti.hotel_management_system;

public class Exit_menu {
	
	public static void exit() throws InterruptedException {
		System.out.print("Exiting");
		int i = 4;
		while(i != 0) {
			System.out.print(".");
			Thread.sleep(350);
			i--;
		}
		System.out.println();
		System.out.println("Thankyou for using Hotel Management System!!");
	}

}

