package com.app.core;

import static com.app.core.Status.*;

public class Order {

	private int orderId;
	private int petId;
	private int quantity;
	private Status status;
	private static int count;

	static {
		count = 1;
	}

	public Order(int petId, int quantity, String status) {
		super();
		this.orderId = count;
		this.petId = petId;
		this.quantity = quantity;
		this.status = valueOf(status);
		count++;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getPetId() {
		return petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = valueOf(status);
	}

}
