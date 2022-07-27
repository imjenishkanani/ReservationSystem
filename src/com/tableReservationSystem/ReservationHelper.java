package com.tableReservationSystem;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

//class Th1 extends Thread {
//		ArrayList<Reservation> tempList1 = new ArrayList<Reservation>();
//		
//		
////		cleanReportFile();
////		for (int i = 0; i < mList.size(); i++) {
////
////			fw.write(mList.get(i) + "");
////			fw.write("\n");
////		}
////		fw.close();
//		//public Th1() {};
////		public Th1()
////		{}
//		Th1(){
//			
//		}
//		public Th1(ArrayList<Reservation> exportAllList) {
//			
//			
//			for(int i=0; i<exportAllList.size(); i++)
//			{
//				tempList1.add(exportAllList.get(i));
//				
//			}
//		}
//		
//		public void run() {
//			try {
//			FileWriter fw = new FileWriter("C:/Users/Jenish Kanani/Desktop/AllReportFile.txt", true);
//			for(int i=0; i<tempList1.size()/2; i++)
//			{
//				
//				fw.write(tempList1.get(i) + "");
//				fw.write("\n");
//			
//				Thread.sleep(1000); 
//				
//			}
//			fw.close();
//			
////			System.out.println("--------------------------------------------------------");
////			System.out.println("Export All Reservation Report Genrated Successfully...");
////			System.out.println("--------------------------------------------------------");
//		} catch(Exception e) {
//			System.out.println(e);
//		};
//}
//
//class Th2 extends Thread {
//	ArrayList<Reservation> tempList2 = new ArrayList<Reservation>();
//	
//	
////	cleanReportFile();
////	for (int i = 0; i < mList.size(); i++) {
////
////		fw.write(mList.get(i) + "");
////		fw.write("\n");
////	}
////	fw.close();
//	public Th2(ArrayList<Reservation> exportAllList) {
//		for(int i=exportAllList.size(); i<exportAllList.size(); i++)
//		{
//			tempList2.add(exportAllList.get(i));
//			
//		}
//	}
//	
//	public void run() {
//		try {
//		FileWriter fw = new FileWriter("C:/Users/Jenish Kanani/Desktop/AllReportFile.txt", true);
//		for(int i=0; i<tempList2.size()/2; i++)
//		{
//			fw.write(tempList2.get(i) + "");
//			fw.write("\n");
//			
//			Thread.sleep(1000);
//			
//		}
//		fw.close();
//		} catch(Exception e) {
//			System.out.println(e);
//		}
////		System.out.println("--------------------------------------------------------");
////		System.out.println("Export All Reservation Report Genrated Successfully...");
////		System.out.println("--------------------------------------------------------");
//	}
//}

public class ReservationHelper implements ReservationMethods {

	private static ArrayList<Reservation> mList = new ArrayList<>();
	private static final String ReservationfilePath = "C:/Users/Jenish Kanani/Desktop/Reservation.txt";

	// added today
	// public Th1 getTh1() {
	// return new Th1();
	// }
	// end

	public ReservationHelper() {
	};

	public int genrateId(LocalDateTime ReservationDate) {
		int minRange = 1;
		int maxRange = 9999;
		int range = maxRange - minRange + 1;

		int rand = (int) (Math.random() * range) + minRange;
		int resYear = ReservationDate.getYear();

		String r = Integer.toString(rand);
		String y = Integer.toString(resYear);
		String Id = y + r;
		int resId = Integer.parseInt(Id);
		return resId;
	}

	public double discount(double SubTotalAmount, LocalDateTime ReservationDate) {

		String day = ReservationDate.getDayOfWeek().toString();
		double amount = 0.0;

		if ("WEDNESDAY" == day) {
			amount = (SubTotalAmount / 100) * 25;
		}
		return amount;
	}

	public void showDetail(int ReservationId, double SubTotalAmount, double DiscountAmount, double TaxAmount,
			double TotalAmount) {

		System.out.println("Reservation Id:   " + ReservationId);
		System.out.println("Sub Total Amount: " + SubTotalAmount + " Rupees");
		System.out.println("Discount Amount:  " + DiscountAmount + " Rupees");
		System.out.println("Tax Amount:       " + TaxAmount + " Rupees");
		System.out.println("Total Amount:     " + TotalAmount + " Rupees" + "\n");

	}

	public void writeToFile() {
		try {
			FileWriter fw = new FileWriter("C:/Users/Jenish Kanani/Desktop/Reservation.txt", true);

			for (int i = 0; i < mList.size(); i++) {
				fw.write(mList.get(i).toString() + "\n");
			}
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void cleanFile() {
		try {

			PrintWriter pw = new PrintWriter(new File("C:/Users/Jenish Kanani/Desktop/Reservation.txt"));
			pw.print("");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createReservation() {

		Date date = new Date();
		Scanner input = new Scanner(System.in);
		int flag = 1;
		outer: while (flag == 1) {
			try {
				if (date.getHours() >= 7 && date.getHours() <= 24) {
					System.out.println("\n --------- WELCOME ---------\n");
				} else {
					System.out.println("\n Sorry We Can Not Book You Reservation Now!! \n");
					System.exit(0);
				}

				System.out.println("Enter you details: ");

				String customerName = null;
				nameLabel: while (true) {

					System.out.println("Enter Your Name: ");
					customerName = input.nextLine().trim();
					if (!customerName.matches("[a-zA-Z ]+")) {
						System.out.println("Please Enter Valid Name!!");
						continue nameLabel;
					} else {
						if (customerName.equals("")) {
							System.out.println("Please Enter Valid Name!!");
							continue nameLabel;
						} else {
							break;
						}
					}
				}

				String reservationDes = null;
				descriptionLabel: while (true) {

					input.nextLine();
					System.out.println("Enter Reservation Description: ");
					reservationDes = input.nextLine().trim();

					if (!(reservationDes.matches("[a-zA-Z0-9 ]+") && !reservationDes.matches("[0-9]+"))) {

						System.out.println("Please Enter Valid Description!!!");
						continue descriptionLabel;
					} else {
						if (customerName.equals("")) {
							System.out.println("Please Enter Valid Description!!");
							continue descriptionLabel;
						} else {
							break;
						}
					}
				}

				LocalDateTime reservationDate = LocalDateTime.now();

				int reservationId = genrateId(reservationDate);
				int adult = 0;
				int children = 0;
				int flag1 = 1;
				inner1: while (flag1 == 1) {
					try {
						System.out.println("Enter Number of Adult: ");

						adult = input.nextInt();
						break;
					} catch (Exception e) {
						input.nextLine();
						System.out.println("enter valid input");
						continue inner1;
					}
				}

				inner2: while (flag1 == 1) {
					try {
						System.out.println("Enter Number of Children: ");
						children = input.nextInt();
						break;
					} catch (Exception e) {
						input.nextLine();
						System.out.println("enter valid input");
						continue inner2;
					}
				}

				String status = "Booked";

				double adultCharge = 500 * adult;
				double childrenCharge = 300 * children;
				double subTotalAmount = adultCharge + childrenCharge;
				double discountAmount = discount(subTotalAmount, reservationDate);
				double tax = ((subTotalAmount - discountAmount) / 100) * 5;
				double taxAmount = tax;
				double totalAmount = (subTotalAmount - discountAmount) + taxAmount;

				mList.add(new Reservation(reservationId, customerName, reservationDes, reservationDate, adult, children,
						status, subTotalAmount, discountAmount, taxAmount, totalAmount));

				System.out.println("-------- Reservation Created Successfully --------");
				showDetail(reservationId, subTotalAmount, discountAmount, taxAmount, totalAmount);
				System.out.println();
				input.nextLine();

				// clear file before the writing.
				cleanFile();
				writeToFile();
				flag = 0;
			} catch (Exception e) {
				System.out.println("We Can't book your resrvation. please try on time!!");
			}
			System.out.println("Do you want to enter more Reservation details(Y/N)");
			String ans = input.next();

			if (ans.equalsIgnoreCase("y")) {
				createReservation();

			} else if (ans.equalsIgnoreCase("n")) {
				return;
			} else {
				System.out.println("Please give correct answer!!");
				break;
			}
		}
	}

	public void readFiletoArrayList() {

		try {
			Scanner fetchFileData = new Scanner(new File("C:/Users/Jenish Kanani/Desktop/Reservation.txt"));

			while (fetchFileData.hasNextLine()) {
				String line = fetchFileData.nextLine();
				if (line != null || line != "") {
					String[] fields = line.split(",");
					Reservation reservation = new Reservation(Integer.parseInt(fields[0].trim()), fields[1], fields[2],
							LocalDateTime.parse(fields[3]), Integer.parseInt(fields[4]), Integer.parseInt(fields[5]),
							fields[6], Double.parseDouble(fields[7]), Double.parseDouble(fields[8]),
							Double.parseDouble(fields[9]), Double.parseDouble(fields[10]));

					mList.add(reservation);

				}
			}
		} catch (Exception e) {
			System.out.println("File Not Found!!");
			e.printStackTrace();
		}

	}

	@Override
	public void viewReservations() {

		try {
			if (!mList.isEmpty()) {
//				System.out.println("Reservation Id|" + " Name         |" + "   Discription      |"
//						+ " Reservation Date           |" + "Adult|" + " Children|" + " Sub Total   |"
//						+ " Tax Amount   |" + "Total amount   |" + "    Status ");

				for (int i = 0; i < mList.size(); i++) {
					System.out.print(mList.get(i).getReservationId() + "  ");
					System.out.print(mList.get(i).getCustomerName() + "  ");
					System.out.print(mList.get(i).getReservationDes() + "  ");
					System.out.print(mList.get(i).getReservationDate() + "  ");
					System.out.print(mList.get(i).getAdult() + "  ");
					System.out.print(mList.get(i).getChildren() + "  ");
					System.out.print(mList.get(i).getSubTotalAmount() + "  ");
					System.out.print(mList.get(i).getDiscountAmount() + "  ");
					System.out.print(mList.get(i).getTaxAmount() + "  ");
					System.out.print(mList.get(i).getTotalAmount() + "  ");
					System.out.print(mList.get(i).getStatus() + "  " + "\n");

				}
			} else {
				System.out.println("\n>>>>>>>>>> No Reservation Available!! <<<<<<<<<<\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int viewReservations(int id) {

		try {
			if (!mList.isEmpty()) {

				for (int i = 0; i < mList.size(); i++) {
					if (mList.get(i).getReservationId() == id) {

						DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
						String formatedDateTime = mList.get(i).getReservationDate().format(format);

						System.out.println(
								"\n------------------------------------------------------------------------------------------------------");
						System.out.println("Reservation Deatils:");
						System.out.println(
								"------------------------------------------------------------------------------------------------------");

						System.out.println("Name :" + mList.get(i).getCustomerName());
						System.out.println("ReservationId :" + mList.get(i).getReservationId());
						System.out.println("ReservationDesc :" + mList.get(i).getReservationDes());
						// System.out.println("ReservationDate :" + mList.get(i).getReservationDate());
						System.out.println("ReservationDate :" + formatedDateTime);
						System.out.println("NoOfAdult :" + mList.get(i).getAdult());
						System.out.println("NoOfChildren :" + mList.get(i).getChildren());
						System.out.println("SubTotal :" + mList.get(i).getSubTotalAmount());
						System.out.println("Discount :" + mList.get(i).getDiscountAmount());
						System.out.println("Tax :" + mList.get(i).getTaxAmount());
						System.out.println("Total :" + mList.get(i).getTotalAmount() + "\n");
						// return 0;
						break;
					} else {
						if (i + 1 == mList.size()) {
							System.out.println("\n>>>>>>>>>> Reservation Id is not available. <<<<<<<<<<\n");
							return 0;
						}
					}
				}
			} else {
				System.out.println("No Reservations Available....");
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want to show more Reservation details(Y/N)");
		String ans = scan.next();

		if (ans.equalsIgnoreCase("y")) {
			return 1;

		} else if (ans.equalsIgnoreCase("n")) {
			return 0;
		} else {
			System.out.println("Please give correct answer!!");
		}

		return 0;
	}

	public void assSortId() {
		class SortByIdAss implements Comparator<Reservation> {
			public int compare(Reservation obj1, Reservation obj2) {
				return obj1.getReservationId() - obj2.getReservationId();
			}
		}

		Collections.sort(mList, new SortByIdAss());

		for (int i = 0; i < mList.size(); i++) {
			System.out.println(mList.get(i) + "\t");
		}
		System.out.println("\nSuccessfully Sorted by Reservation Id in Ascending Order.\n");
	}

	public void dscSortId() {
		class SortByIdDsc implements Comparator<Reservation> {
			public int compare(Reservation obj1, Reservation obj2) {
				return obj2.getReservationId() - obj1.getReservationId();
			}
		}

		Collections.sort(mList, new SortByIdDsc());

		for (int i = 0; i < mList.size(); i++) {
			System.out.println(mList.get(i) + "\t");
		}
		System.out.println("\nSuccessfully Sorted by Reservation Id in Descending Order.\n");
	}

	public void assSortDes() {
		class SortByDesAss implements Comparator<Reservation> {
			public int compare(Reservation obj1, Reservation obj2) {
				return obj1.getReservationDes().compareTo(obj2.getReservationDes());
			}
		}

		Collections.sort(mList, new SortByDesAss());

		for (int i = 0; i < mList.size(); i++) {
			System.out.println(mList.get(i) + "\t");
		}
		System.out.println("\nSuccessfully Sorted by Reservation Description in Ascending Order.\n");
	}

	public void dscSortDes() {
		class SortByDesDsc implements Comparator<Reservation> {
			public int compare(Reservation obj1, Reservation obj2) {
				return obj2.getReservationDes().compareTo(obj1.getReservationDes());
			}
		}

		Collections.sort(mList, new SortByDesDsc());

		for (int i = 0; i < mList.size(); i++) {
			System.out.println(mList.get(i) + "\t");
		}
		System.out.println("\nSuccessfully Sorted by Description in Descending Order.\n");
	}

	public void assSortAmnt() {
		class SortByAmntAss implements Comparator<Reservation> {
			public int compare(Reservation obj1, Reservation obj2) {
				return (int) (obj1.getTotalAmount() - obj2.getTotalAmount());
			}
		}

		Collections.sort(mList, new SortByAmntAss());

		for (int i = 0; i < mList.size(); i++) {
			System.out.println(mList.get(i) + "\t");
		}
		System.out.println("\nSuccessfully Sorted by Amount in Ascending Order.\n");
	}

	public void dscSortAmnt() {
		class SortByAmntDsc implements Comparator<Reservation> {
			public int compare(Reservation obj1, Reservation obj2) {
				return (int) (obj2.getTotalAmount() - obj1.getTotalAmount());
			}
		}

		Collections.sort(mList, new SortByAmntDsc());

		for (int i = 0; i < mList.size(); i++) {
			System.out.println(mList.get(i) + "\t");
		}
		System.out.println("\nSuccessfully Sorted by Amount in Descending Order.\n");
	}

	public void assSortDate() {
		class SortByDateAss implements Comparator<Reservation> {
			public int compare(Reservation obj1, Reservation obj2) {
				return obj1.getReservationDate().compareTo(obj2.getReservationDate());
			}
		}

		Collections.sort(mList, new SortByDateAss());

		for (int i = 0; i < mList.size(); i++) {
			System.out.println(mList.get(i) + "\t");
		}
		System.out.println("\nSuccessfully Sorted by Date in Ascending Order.\n");
	}

	public void dscSortDate() {
		class SortByDateDsc implements Comparator<Reservation> {
			public int compare(Reservation obj1, Reservation obj2) {
				return obj2.getReservationDate().compareTo(obj1.getReservationDate());
			}
		}

		Collections.sort(mList, new SortByDateDsc());

		for (int i = 0; i < mList.size(); i++) {
			System.out.println(mList.get(i) + "\t");
		}
		System.out.println("\nSuccessfully Sorted by Date in Dscending Order.\n");
	}

	public void sortByResDate() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("******* Choose Sort Orders *******");

			System.out.println("1. Ascending");
			System.out.println("2. Descending");
			System.out.println("0. Go Back...");

			System.out.println("Please choose status : ");
			int ch = input.nextInt();

			switch (ch) {
			case 1:
				assSortDate();
				break;
			case 2:
				dscSortDate();
				break;
			case 0:
				return;
			default:
				System.out.println("Please enter valid choice!!");
				break;
			}
		}
	}

	public void sortResById() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("******* Choose Sort Orders *******");

			System.out.println("1. Ascending");
			System.out.println("2. Descending");
			System.out.println("0. Go Back...");

			System.out.println("Please choose status : ");
			int ch = input.nextInt();

			switch (ch) {
			case 1:
				assSortId();
				break;
			case 2:
				dscSortId();
				break;
			case 0:
				return;
			default:
				System.out.println("Please enter valid choice!!");
				break;

			}
		}
	}

	public void sortByTotalAmt() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("******* Choose Sort Orders *******");

			System.out.println("1. Ascending");
			System.out.println("2. Descending");
			System.out.println("0. Go Back...");

			System.out.println("Please choose status : ");
			int ch = input.nextInt();

			switch (ch) {
			case 1:
				assSortAmnt();
				break;
			case 2:
				dscSortAmnt();
				break;
			case 0:
				return;
			default:
				System.out.println("Please enter valid choice!!");
				break;

			}
		}
	}

	public void sortByResDes() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("******* Choose Sort Orders *******");

			System.out.println("1. Ascending");
			System.out.println("2. Descending");
			System.out.println("0. Go Back...");

			System.out.println("Please choose status : ");
			int ch = input.nextInt();

			switch (ch) {
			case 1:
				assSortDes();
				break;
			case 2:
				dscSortDes();
				break;
			case 0:
				return;
			default:
				System.out.println("Please enter valid choice!!");
				break;

			}
		}
	}

	@Override
	public void sortReservation() {

		int choose;
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("******** Choose Sort Reservation Property *******");
			System.out.println("1. Reservation Id");
			System.out.println("2. Reservation Description");
			System.out.println("3. Reservation Date");
			System.out.println("4. Total Amount");
			System.out.println("0. Exit..");
			System.out.println("Enter your choice");
			choose = input.nextInt();
			switch (choose) {
			case 1:
				sortResById();
				break;
			case 2:
				sortByResDes();
				break;
			case 3:
				sortByResDate();
				break;
			case 4:
				sortByTotalAmt();
				break;
			case 0:
				return;
			default:
				System.out.println("Please enter valid choice!!");
				break;
			}
		}
	}

	@Override
	public int deleteReservationById(int id) {
		Reservation reservationDetail;
		try {
			if (!mList.isEmpty()) {
				for (int i = 0; i < mList.size(); i++) {
					reservationDetail = (Reservation) mList.get(i);
					if (id == reservationDetail.getReservationId()) {
						mList.remove(reservationDetail);
						cleanFile();
						writeToFile();
						System.out.println("\nReservation deleted successfully\n");
						break;
					} else {
						if (i + 1 == mList.size()) {
							System.out.println("\n>>>>>>>>>> Reservation Id is not available. <<<<<<<<<<\n");
							return 0;
						}
					}
				}
			} else {
				System.out.println("Sorry, No Reservations Available!!");
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scanner scan2 = new Scanner(System.in);
		System.out.println("\nDo you want to delete another Reservation (Y/N):");
		String ans2 = scan2.next();

		if (ans2.equalsIgnoreCase("y")) {
			return 1;

		} else if (ans2.equalsIgnoreCase("n")) {
			return 0;
		} else {
			System.out.println("Please give correct answer!!");
		}

		return 0;

	}

	@Override
	public int confirmedResById(int resId) {
		Reservation reservationDetail;
		try {
			if (!mList.isEmpty()) {
				for (int i = 0; i < mList.size(); i++) {
					reservationDetail = (Reservation) mList.get(i);

					if (resId == reservationDetail.getReservationId()) {
						if (!(reservationDetail.getStatus() == "Confirmed")) {
							reservationDetail.setStatus("Confirmed");
							System.out.println("\nReservation " + resId + " confirmed\n");
							break;
						} else {
							System.out.println("\nReservation already confirmed!!\n");
							return 0;
						}
					} else {
						if (i + 1 == mList.size()) {
							System.out.println("\n>>>>>>>>>> Reservation Id is not available. <<<<<<<<<<\n");
							return 0;
						}
					}
				}
			} else {
				System.out.println("Sorry, No Reservations Available!!");
				return 0;
			}

			Scanner scan3 = new Scanner(System.in);
			System.out.println("\nDo you want to confirm other Reservation (Y/N):");
			String ans3 = scan3.next();

			if (ans3.equalsIgnoreCase("y")) {
				return 1;

			} else if (ans3.equalsIgnoreCase("n")) {
				return 0;
			} else {
				System.out.println("Please give correct answer!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int cancelResById(int resId) {
		Reservation reservationDetail;
		try {
			if (!mList.isEmpty()) {
				for (int i = 0; i < mList.size(); i++) {
					reservationDetail = (Reservation) mList.get(i);

					if (resId == reservationDetail.getReservationId()) {
						if (!(reservationDetail.getStatus() == "Cancelled")) {
							reservationDetail.setStatus("Cancelled");
							System.out.println("\nReservation " + resId + " Cancelled\n");
							System.out.println("\nAmount " + reservationDetail.getTotalAmount()
									+ " will refund within 24 hours\n");
							break;
						} else {
							System.out.println("\nReservation already Cancelled!!\n");
							return 0;
						}
					} else {
						if (i + 1 == mList.size()) {
							System.out.println("\n>>>>>>>>>> Reservation Id is not available. <<<<<<<<<<\n");
							return 0;
						}
					}
				}
			} else {
				System.out.println("\nSorry, No Reservations Available!!\n");
				return 0;
			}

			Scanner scan4 = new Scanner(System.in);
			System.out.println("\nDo you want to cancelled other Reservation (Y/N):");
			String ans4 = scan4.next();

			if (ans4.equalsIgnoreCase("y")) {
				return 1;

			} else if (ans4.equalsIgnoreCase("n")) {
				return 0;
			} else {
				System.out.println("Please give correct answer!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void cleanReportFile() {
		try {

			PrintWriter pw = new PrintWriter(new File("C:/Users/Jenish Kanani/Desktop/AllReportFile.txt"));
			pw.print("");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

//	public static void cleanReportFileThread() {
//		try {
//
//			PrintWriter pw = new PrintWriter(new File("C:/Users/Jenish Kanani/Desktop/AllReportFile1.txt"));
//			pw.print("");
//			pw.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

//	public static void writeReportFileThread() {
//		
//		try {
//			FileWriter fw = new FileWriter("C:/Users/Jenish Kanani/Desktop/AllReportFile1.txt", true);
//			cleanReportFileThread();
//			for (int i = 0; i < mList.size(); i++) {
//
//				fw.write(mList.get(i) + "");
//				fw.write("\n");
//			}
//			fw.close();
//		} catch (IOException e) {
//			System.out.println("File not found!!");
//		}
//	}

	public String genrateFileName() {
		String path = "";

		try {

			String flName, dateFormat;
			dateFormat = new SimpleDateFormat("yyyy-MMdd-HHmm-ss'.txt'").format(new Date());

			flName = "Reservation_Report_" + dateFormat;
			File file = new File("C:/Users/Jenish Kanani/Desktop/Reports" + flName);
			boolean result = file.createNewFile();
			System.out.println(file.getAbsolutePath());
			path = file.getAbsolutePath();
			if (result)
				System.out.println("file created");
			else
				System.out.println("file exist");

		} catch (Exception e) {
			System.out.println(e);
		}
		return path;
	}

	public void bookedStatusReport() {
		ArrayList<Reservation> bookedTempList = new ArrayList<>();
		for (int i = 0; i < mList.size(); i++) {
			if (mList.get(i).getStatus().equalsIgnoreCase("Booked")) {
				bookedTempList.add(mList.get(i));
			}
		}

		if (bookedTempList.size() > 0) {
			try {
				FileWriter fw = new FileWriter(genrateFileName(), true);

				for (int i = 0; i < bookedTempList.size(); i++) {
					fw.write(bookedTempList.get(i) + "	");
					fw.write("\n");
				}

				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				System.out.println("Can not write to File!!");
			}
		} else {
			System.out.println("\nNo Reservation found with Booked status..\n");
			return;
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("Reservation Report of Booked status Genrated Successfully...");
		System.out.println("---------------------------------------------------------------");

	}

	public void cancelledStatusReport() {
		ArrayList<Reservation> cancelledTempList = new ArrayList<>();
		for (int i = 0; i < mList.size(); i++) {
			if (mList.get(i).getStatus().equalsIgnoreCase("Cancelled")) {
				cancelledTempList.add(mList.get(i));
			}
		}

		if (cancelledTempList.size() > 0) {
			try {
				FileWriter fw = new FileWriter(genrateFileName(), true);

				for (int i = 0; i < cancelledTempList.size(); i++) {
					fw.write(cancelledTempList.get(i) + "	");
					fw.write("\n");
				}

				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				System.out.println("Can not write to File!!");
			}
		} else {
			System.out.println("\nNo Reservation found with Cancelled status..\n");
			return;
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("Reservation Report of Cancelled status Genrated Successfully...");
		System.out.println("---------------------------------------------------------------");

	}

	public void confirmedStatusReport() {
		ArrayList<Reservation> confirmTempList = new ArrayList<>();
		for (int i = 0; i < mList.size(); i++) {
			if (mList.get(i).getStatus().equalsIgnoreCase("Confirmed")) {
				confirmTempList.add(mList.get(i));
			}
		}

		if (confirmTempList.size() > 0) {
			try {
				FileWriter fw = new FileWriter(genrateFileName(), true);

				for (int i = 0; i < confirmTempList.size(); i++) {
					fw.write(confirmTempList.get(i) + "	");
					fw.write("\n");
				}

				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				System.out.println("Can not write to File!!");
			}
		} else {
			System.out.println("\nNo Reservation found with Confirmed status..\n");
			return;
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("Reservation Report of Confirmed status Genrated Successfully...");
		System.out.println("---------------------------------------------------------------");

	}

	public void exportByStatus() {
		int choice;
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("******* Choose Status *******");

			System.out.println("1. Booked");
			System.out.println("2. Cancelled");
			System.out.println("3. Confirmed");
			System.out.println("0. Go Back...");
			System.out.println("Please choose status : ");
			choice = input.nextInt();

			switch (choice) {
			case 1:
				bookedStatusReport();
				break;
			case 2:
				cancelledStatusReport();
				break;
			case 3:
				confirmedStatusReport();
				break;
			case 0:
				return;
			default:
				System.out.println("Please enter valid choice!!");
				break;
			}
		}
	}

	@Override
	public void generateResReport() {
		int ch;
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("************ Choose Report Type ************");
			System.out.println("1. Export All");
			System.out.println("2. Export By Status");
			System.out.println("0. Exit.");

			System.out.println("Enter your choice");
			ch = input.nextInt();
			switch (ch) {
			case 1:
				// thread part start
				ArrayList<Reservation> exportAllList = new ArrayList<Reservation>();
				for(int i=0; i<mList.size(); i++)
				{
					exportAllList.add(mList.get(i));
				}
				
				cleanReportFile();
				
				Runnable obj1 = new Th1(exportAllList);
				Runnable obj2 = new Th1(exportAllList);
				
				Thread objt1 = new Thread(obj1);
				Thread objt2 = new Thread(obj2);
				
				System.out.println("Starting to writing in file...");
				objt1.start();
				
				System.out.println("Wait still writing... ");
				try {
					Thread.sleep(1000);
				} catch(Exception e) {
					System.out.println(e);
				}		
				objt2.start();
				System.out.println("Finished writing.");
				// end

				System.out.println("--------------------------------------------------------");
				System.out.println("Export All Reservation Report Genrated Successfully...");
				System.out.println("--------------------------------------------------------");

				break;
			case 2:
				exportByStatus();
				break;
			case 0:
				return;
			default:
				System.out.println("\nPlease Enter valid choice!!\n");
				break;
			}
		}
	}

	// innerclass for thread start.
	class Th1 implements Runnable {
		ArrayList<Reservation> tempList1 = new ArrayList<Reservation>();
		Th1() {

		}

		public Th1(ArrayList<Reservation> exportAllList) {

			for (int i = 0; i < exportAllList.size(); i++) {
				tempList1.add(exportAllList.get(i));

			}
		}

		public void run() {
			try {
				System.out.println("Th1 working...");
				FileWriter fw = new FileWriter("C:/Users/Jenish Kanani/Desktop/AllReportFile.txt", true);
				for (int i = 0; i < tempList1.size() / 2; i++) {

					fw.write(tempList1.get(i) + "");
					fw.write("\n");

					Thread.sleep(1000);

				}
				
				for (int j = tempList1.size() / 2; j < tempList1.size(); j++) {
					fw.write(tempList1.get(j) + "");
					fw.write("\n");

					Thread.sleep(1000);

				}
				fw.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
