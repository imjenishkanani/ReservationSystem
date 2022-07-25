package com.tableReservationSystem;
import java.time.LocalDateTime;

public class Reservation {

	private int reservationId;
	private String customerName, reservationDes, status;
	private LocalDateTime reservationDate;
	private int adult;
	private int children;
	private double subTotalAmount, discountAmount, taxAmount, totalAmount;

	public Reservation() {};

	public Reservation(int reservationId,
			String customerName,
			String reservationDes,
			LocalDateTime reservationDate,
			int adult,
			int children,
			String status,
			double subTotalAmount,
			double discountAmount,
			double taxAmount,
			double totalAmount) {

		this.reservationId = reservationId;
		this.customerName = customerName;
		this.reservationDes = reservationDes;
		this.reservationDate = reservationDate;
		this.adult = adult;
		this.children = children;
		this.status = status;
		this.subTotalAmount = subTotalAmount;
		this.discountAmount = discountAmount;
		this.taxAmount = taxAmount;
		this.totalAmount = totalAmount;
	}

	public String toString() {
		return reservationId + "," + 
				customerName + "," + 
				reservationDes + "," + 
				reservationDate + "," + 
				adult + "," + 
				children + "," + 
				status + "," + 
				subTotalAmount + "," + 
				discountAmount + "," + 
				taxAmount + "," + 
				totalAmount;
	}

	public int getReservationId() {
		return reservationId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getReservationDes() {
		return reservationDes;
	}

	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public int getAdult() {
		return adult;
	}

	public int getChildren() {
		return children;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getSubTotalAmount() {
		return subTotalAmount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
}
