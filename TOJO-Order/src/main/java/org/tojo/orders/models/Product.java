package org.tojo.orders.models;

public class Product {
	private Integer id;
	private String title;
	private String description;
	private float price;
	
	public Product() {
		
	}
	
	public Product(int id, String title, String description, float price) {
		this.setId(id);
		this.title = title;
		this.description = description;
		this.price = price;
	}
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
