//package com.tableReservationSystem;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class MultithreadingReport implements Runnable {
//
//	@Override
//	public void run() {
//		Thread tread = Thread.currentThread();
//		String name = tread.getName();
//		ReservationHelper reservationHelper = new ReservationHelper();
//
//		if (name.equals("Booked") == true) {
//			String str = "Booked";
//			try {
//
//				reservationHelper.exportByStatus();
//
//				System.out.println("Generated Sucessfully By Status Booked");
//			} catch (Exception e) {
//
//				e.printStackTrace();
//			}
//		} else if (name.equals("Canceled") == true) {
//			String str = "Canceled";
//			reservationHelper.exportByStatus();
//			System.out.println("Generated Sucessfully By Status Canceled");
//		} else {
//			if (name.equals("Confirmed") == true) {
//
//				String str = "Confirmed";
//				try {
//					reservationHelper.exportByStatus();
//					System.out.println("Generated Sucessfully By Status Confirmed");
//
//				} catch (Exception e) {
//
//					e.printStackTrace();
//				}
//			}
//		}
//
//		System.out.println("Sucessfully Generated");
//
//	}
//
//	public static void main(String[] args) throws InterruptedException {
//
//		MultithreadingReport threadReport = new MultithreadingReport();
//
//		Thread thread1 = new Thread(threadReport);
//		Thread thread2 = new Thread(threadReport);
//		Thread thread3 = new Thread(threadReport);
//
//		thread1.setName("Booked");
//		thread2.setName("Canceled");
//		thread3.setName("Confirmed");
//
//		System.out.println(" Booked status report genrating..");
//		thread1.sleep(5000);
//		thread1.start();
//
//		thread2.sleep(10000);
//		System.out.println("Canceled status report genrating..");
//		thread2.start();
//
//		thread3.sleep(15000);
//		System.out.println("Confirmed status report genrating..");
//		thread3.start();
//	}
//
//}