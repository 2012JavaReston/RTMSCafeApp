package com.cafe.model;

public class CafeMenu {
	
	private String itemName;
	private double itemPrice;
	
		
	public CafeMenu() {
		super();
	}
	
	
	public CafeMenu(String itemName, double itemPrice) {
		this();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}


	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	@Override
	public String toString() {
		return "CafeMenu [itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}
	
}
