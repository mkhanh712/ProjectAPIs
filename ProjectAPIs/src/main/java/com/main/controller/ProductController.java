package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.main.DTO.ProductDTO;
import com.main.DTO.ProductRequestDTO;
import com.main.entity.Product;
import com.main.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	// GET /products?categoryId=1&page=0&size=5
	@GetMapping("/public/get/products")
	public Page<ProductDTO> getProductsByCategory(
			@RequestParam Long categoryId,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size){
		return productService.getProductsByCategory(categoryId, PageRequest.of(page, size));
	}
	
	@GetMapping("/public/get/productid={id}")
	public ProductDTO getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@PostMapping("/admin/createProduct")
		/**
		{
		  "name": "xxx",
		  "description": "xxx",
		  "categoryId": x
		}
		*/
	public Product createProduct(@RequestBody ProductRequestDTO dto) {
		return productService.createProduct(dto);
	}
	
	@PutMapping("/admin/updateProduct/productid={id}")
	/**
	{
	  "name": "xxx",
	  "description": "xxx",
	  "categoryId": x
	}
	*/
	public Product updateProduct(@PathVariable long id, @RequestBody ProductRequestDTO dto) {
		return productService.updateProduct(id , dto);
	}
}
