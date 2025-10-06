package com.main.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.main.DTO.ProductDTO;
import com.main.DTO.ProductRequestDTO;
import com.main.entity.Product;

public interface ProductService {
	Page<ProductDTO> getProductsByCategory(Long categoryId, Pageable pageable);
	ProductDTO getProductById(Long id);
	Product createProduct(ProductRequestDTO dto);
	Product updateProduct(Long id, ProductRequestDTO dto);
}
