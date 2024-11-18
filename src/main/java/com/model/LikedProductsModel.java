package com.model;

public class LikedProductsModel {
	
	private String firstName;
	private String userName;
	private String productName;
	private int price;
	private int productId;
	private String action;
	
	public LikedProductsModel() {
		
	}
	
	public LikedProductsModel(String firstName, String userName, String productName, int price, int productId, String action) {
		this.firstName = firstName;
		this.userName = userName;
		this.productName = productName;
		this.price = price;
		this.productId = productId;
		this.action = action;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + ", userName=" + userName + ", productName=" + productName
				+ ", price=" + price + ", productId=" + productId + ", action=" + action;
	}
	
	
	
}
