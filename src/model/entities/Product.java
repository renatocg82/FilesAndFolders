package model.entities;

public class Product {
	
	protected String name;
	protected double unitPrice;
	protected double quantity;
	
	public Product() {
		
	}

	public Product(String name, double unitPrice, double quantity) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public double getQuantity() {
		return quantity;
	}

	public double getTotal() {
		return quantity*unitPrice;
	}
	
}
