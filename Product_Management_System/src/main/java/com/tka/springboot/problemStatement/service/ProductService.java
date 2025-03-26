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
	
}
