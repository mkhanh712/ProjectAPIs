package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.main.DTO.ProductDTO;
import com.main.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	// GET /products?categoryId=1&page=0&size=5
	@GetMapping("/get/products")
	public Page<ProductDTO> getProductsByCategory(
			@RequestParam Long categoryId,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size){
		return productService.getProductsByCategory(categoryId, PageRequest.of(page, size));
	}
	
	@GetMapping("/get/product/id={id}")
	public ProductDTO getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
}
