package com.main.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.main.DTO.ProductDTO;

public interface ProductService {
	Page<ProductDTO> getProductsByCategory(Long categoryId, Pageable pageable);
	ProductDTO getProductById(Long id);
}
