package com.app.core;

import static com.app.core.Category.*;

public class Pet {

	private int petId;
	private String name;
	private Category category;
	private double unitPrice;
	private int stock;
	private static int count;

	static {
		count = 100;
	}

	public Pet(String name, Category category, double unitPrice, int stock) {
		super();
		this.petId = count;
		this.name = name;
		this.category = category;
		this.unitPrice = unitPrice;
		this.stock = stock;
		count++;
	}

	public int getPetId() {
		return petId;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int getStock() {
		return stock;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = valueOf(category);
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", category=" + category + ", unitPrice=" + unitPrice
				+ ", stock=" + stock + "]";
	}

}
