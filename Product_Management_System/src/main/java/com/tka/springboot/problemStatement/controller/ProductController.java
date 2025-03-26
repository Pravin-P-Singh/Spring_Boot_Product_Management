package com.tka.springboot.problemStatement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.springboot.problemStatement.entity.Product;
import com.tka.springboot.problemStatement.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add-product")
	public String addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	//delete by id using path variable
	@DeleteMapping("/delete-product-by-id/{id}")
	public String deleteProductById(@PathVariable String id ) {
		return productService.deleteProductById(id);
	}
	
	//delete by name using request params
	@DeleteMapping("/delete-product-by-name")
	public String deleteProductByName(@RequestParam String productName) {
		return productService.deleteProductByName(productName);
	}
	
	//Get a particular product by name
	@GetMapping("/get-product-by-name")
	public Object getProductByName(@RequestParam String productName) {
		return productService.getProductByName(productName);
	}
	
	//Update a particular product
	@PutMapping("/update-product")
	public String updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
}
