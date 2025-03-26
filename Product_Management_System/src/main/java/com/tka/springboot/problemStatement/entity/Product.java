package com.tka.springboot.problemStatement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@Column(name="product_id", unique = true, nullable = false)
	private String productId;
	
	@Column(name="product_name", unique = true, nullable = false)
	private String productName;
	
	@Column(name="product_quantity", nullable = false)
	private int productQuantity;
	
	@Column(name="product_price", nullable = false)
	private double productPrice;
	
	@Column(name="product_mfg_date", nullable = false)
	private String productManufacturingDate;
	
	@Column(name="product_exp_date")
	private String productExpiryDate;
	
	public Product() {
		super();
	}

	public Product(String productId, String productName, int productQuantity, double productPrice, String productManufacturingDate, String productExpiryDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productManufacturingDate = productManufacturingDate;
		this.productExpiryDate = productExpiryDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductManufacturingDate() {
		return productManufacturingDate;
	}

	public void setProductManufacturingDate(String productManufacturingDate) {
		this.productManufacturingDate = productManufacturingDate;
	}

	public String getProductExpiryDate() {
		return productExpiryDate;
	}

	public void setProductExpiryDate(String productExpiryDate) {
		this.productExpiryDate = productExpiryDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productPrice=" + productPrice + ", productManufacturingDate="
				+ productManufacturingDate + ", productExpiryDate=" + productExpiryDate + "]";
	}
	
}
