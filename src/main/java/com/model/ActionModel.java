package com.model;

public class ActionModel {
	private int productId;
	private int customerId;
	private String likesDislikes;
	
	public ActionModel() {
		
	}
	
	public ActionModel(int productId, int customerId, String likesDislikes) {
		this.productId = productId;
		this.customerId = customerId;
		this.likesDislikes = likesDislikes;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getLikesDislikes() {
		return likesDislikes;
	}
	public void setLikesDislikes(String likesDislikes) {
		this.likesDislikes = likesDislikes;
	}
	@Override
	public String toString() {
		return "ActionModel [productId=" + productId + ", customerId=" + customerId + ", likesDislikes=" + likesDislikes
				+ "]";
	}
	
	
}
