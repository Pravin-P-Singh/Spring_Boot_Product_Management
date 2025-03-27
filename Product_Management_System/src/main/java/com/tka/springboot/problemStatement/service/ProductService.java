package com.tka.springboot.problemStatement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.springboot.problemStatement.dao.ProductDao;
import com.tka.springboot.problemStatement.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public String addProduct(Product product) {
		return productDao.addProduct(product);
	}
	
	public String deleteProductById(String productId) {
		return productDao.deleteProductById(productId);
	}
	public String deleteProductByName(String productName) {
		return productDao.deleteProductByName(productName);
	}
	public Object getProductByName(String productName) {
		return productDao.getProductByName(productName);
	}
	
	public String updateProduct(Product product) {
		return productDao.updateProduct(product);
	}
	
	public Object getAllProducts() {
		return productDao.getAllProducts();
	}
	
	public Object getAllProductsInAscOrder(String parameter) {
		return productDao.getAllProductsInAscOrder(parameter);
	}
	
	public Object getProductById(String productId) {
		return productDao.getProductById(productId);
	}
	
	public Object getAllProductsAboveSpecifiedPrice(double productPrice) {
		return productDao.getProductsAboveSpecifiedPrice(productPrice);
	}
	
	public Object getProductsByNamePattern(String pattern) {
		return productDao.getProductsByNamePattern(pattern);
	}
	
	public Object getProductsWithinPriceRange(double initialPrice, double maxPrice) {
		return productDao.getProductsWithinPriceRange(initialPrice, maxPrice);
	}
	
	public Object getMaxPriceProduct() {
		return productDao.getMaxPriceProduct();
	}
	
}
