package com.main.serviceimp;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.main.DTO.ProductDTO;
import com.main.entity.Product;
import com.main.repository.ProductRepository;
import com.main.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Page<ProductDTO> getProductsByCategory(Long categoryId, Pageable pageable){
		Page<Product> products = productRepository.findByCategoryId(categoryId, pageable);
		return products.map(p -> new ProductDTO(
				p.getId(),
				p.getName(),
				p.getDescription(),
				p.getCategory().getName()
		));
	}
}
