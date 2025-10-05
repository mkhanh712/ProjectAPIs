package com.main.serviceimp;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.main.DTO.ProductDTO;
import com.main.entity.Product;
import com.main.repository.ProductRepository;
import com.main.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Page<ProductDTO> getProductsByCategory(Long categoryId, Pageable pageable){
		Page<Product> products = productRepository.findByCategoryId(categoryId, pageable);
		return products.map(p -> new ProductDTO(
				p.getId(),
				p.getName(),
				p.getDescription(),
				p.getCreatedAt(),
				p.getCategory().getId(),
				p.getCategory().getName()
		));
	}
	
	@Override
	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(
			        HttpStatus.NOT_FOUND, "Product not found with id: " + id
			    ));
		return new ProductDTO(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getCreatedAt(),
				product.getCategory().getId(),
				product.getCategory().getName()
		);
	}
}
