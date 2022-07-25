package com.tableReservationSystem;

import java.io.FileWriter;
import java.util.Scanner;
import com.tableReservationSystem.Reservation;

public class ReservationHome {
	public static void main(String[] args) {

		ReservationHelper obj = new ReservationHelper();
		final String path = null;
		Scanner input = new Scanner(System.in);
		FileWriter fw = null;

		try {
			fw = new FileWriter("C:/Users/Jenish Kanani/Desktop/Reservation.txt", true);
		} catch (Exception e0) {
			e0.printStackTrace();
		}

		int id;
		obj.readFiletoArrayList();

		while (true) {

			System.out.println();
			System.out.println("************ Table Reservation System ************");
			System.out.println("		1. Add Reservation.			");
			System.out.println("		2. View Reservation List.			");
			System.out.println("		3. View By Reservation Id.			");
			System.out.println("		4. Sort Reservation.");
			System.out.println("		5. Delete Reservation by Id.			");
			System.out.println("		6. Confirmed Reservation by Id.			");
			System.out.println("		7. Cencelled Reservation by Id.		");
			System.out.println("		8. Generate Reservation Report.		");
			System.out.println("		9. Exit		");

			System.out.println("Choose Option: ");
			try {
				int ch = new Scanner(System.in).nextInt();

				switch (ch) {
				case 1:
					obj.createReservation();
					break;
				case 2:
					obj.viewReservations();
					break;
				case 3:
					int flag2 = 1;
					while (flag2 == 1) {
						System.out.println("Enter Reservation Id : ");
						id = Integer.parseInt(input.next());
						int res = obj.viewReservations(id);

						if (res == 1) {
							flag2 = 1;
						} else {
							flag2 = 0;
						}
					}
					break;
				case 4:
					obj.sortReservation();
					break;
				case 5:

					int flag3 = 1;
					while (flag3 == 1) {
						System.out.println("Enter Reservation Id : ");
						int did = input.nextInt();
						int deleteReservationRes = obj.deleteReservationById(did);

						if (deleteReservationRes == 1) {
							flag3 = 1;
						} else {
							flag3 = 0;
						}
					}

					break;
				case 6:
					int flag4 = 1;
					while (flag4 == 1) {
						System.out.println("Enter Reservation Id : ");
						int resId = input.nextInt();

						int confirmReservationRes = obj.confirmedResById(resId);

						obj.cleanFile();
						obj.writeToFile();

						if (confirmReservationRes == 1) {
							flag4 = 1;
						} else {
							flag4 = 0;
						}
					}
					break;
				case 7:
					int flag5 = 1;
					while (flag5 == 1) {
						System.out.println("Enter Reservation Id : ");
						int cancelResId = input.nextInt();

						int cancelReservationRes = obj.cancelResById(cancelResId);

						obj.cleanFile();
						obj.writeToFile();

						if (cancelReservationRes == 1) {
							flag5 = 1;
						} else {
							flag5 = 0;
						}
					}
					break;
				case 8:
					obj.generateResReport();
					break;
				case 9:
					obj.cleanFile();
					obj.writeToFile();
					System.out.println("\n		THANKS :)		");
					System.out.println("   You Are Now Exit From Application.	");
					System.exit(0);
					break;
				default:
					System.out.println("Please Choose Correct Option!!");
					break;
				}
			} catch (Exception e) {
				System.out.println("Please Enter Only Numeric Value!!");
			}
		}
	}
}
