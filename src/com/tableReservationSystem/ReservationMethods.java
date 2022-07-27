package com.tableReservationSystem;

public interface ReservationMethods {
	public void createReservation();
	public void viewReservations();
	public int viewReservations(int id);
	public void sortReservation();
	public int deleteReservationById(int id);
	public int confirmedResById(int resId);
	public int cancelResById(int resId);
	public void generateResReport();
}
