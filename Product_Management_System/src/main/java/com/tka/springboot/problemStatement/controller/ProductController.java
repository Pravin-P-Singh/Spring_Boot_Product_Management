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
	
	//Add a particular product
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
	
	//delete products by ids in list-->
	
	
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
	
	//Retrieve all products
	@GetMapping("/get-all-products")
	public Object getAllProducts() {
		return productService.getAllProducts();
	}
	
	//Retrieve all products in ascending order by given parameter
	@GetMapping("/get-all-products-in-ascending-order/{parameter}")
	public Object getAllProductsInAscOrder(@PathVariable String parameter) {
		return productService.getAllProductsInAscOrder(parameter);
	}
	
	//Retrieve a product by name
	@GetMapping("/get-product-by-id")
	public Object getProductById(@RequestParam String id) {
		return productService.getProductById(id);
	}
	
	//Retrieve products with price greater than specified price
	@GetMapping("/get-products-above-specified-price")
	public Object getProductsAboveSpecifiedPrice(@RequestParam double productPrice) {
		return productService.getAllProductsAboveSpecifiedPrice(productPrice);
	}
	
	//Retrieve products by name pattern
	@GetMapping("/get-product-by-name-pattern")
	public Object getProductsByNamePattern(@RequestParam String pattern) {
		return productService.getProductsByNamePattern(pattern);
	}
	
	//Get products within price range
	@GetMapping("/get-products-within-price-range")
	public Object getProductsWithinPriceRange(@RequestParam double initialPrice, @RequestParam double maxPrice) {
		return productService.getProductsWithinPriceRange(initialPrice, maxPrice);
	}
	
	//Retrieve maximum price product
	@GetMapping("/get-max-price-product")
	public Object getMaxPriceProduct() {
		return productService.getMaxPriceProduct();
	}
	
	
	
}
