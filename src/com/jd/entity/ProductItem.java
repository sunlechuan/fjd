package com.jd.entity;

public class ProductItem {
	private Product product;
	private int quantity;//数量
	private int price;//商品小计
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		int price = (int) (product.getPprice() * this.getQuantity());
		
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
//	@Override
//	public String toString() {
//		return "ProductItem [product=" + product + ", quantity=" + quantity + ", price=" + price + "]";
//	}
	
	@Override
	public String toString() {
		return "{product:\"" + product + "\",quantity:\"" + quantity + "\",price:\"" + price + "\"}";
	}
	
}
