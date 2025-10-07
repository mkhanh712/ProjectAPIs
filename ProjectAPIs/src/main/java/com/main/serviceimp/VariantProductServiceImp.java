package com.main.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.main.DTO.VariantRequestDTO;
import com.main.entity.Product;
import com.main.entity.VariantProduct;
import com.main.repository.ProductRepository;
import com.main.repository.VariantProductRepository;
import com.main.service.VariantProductService;

@Service
public class VariantProductServiceImp implements VariantProductService {
	@Autowired
	private VariantProductRepository variantProductRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public VariantProduct createVProduct(VariantRequestDTO dto) {
		Product product = productRepository.findById(dto.getProductId())
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND, "Product not found" ));
		VariantProduct vproduct = new VariantProduct();
		vproduct.setSku(dto.getSku());
		vproduct.setColor(dto.getColor());
		vproduct.setSize(dto.getSize());
		vproduct.setPrice(dto.getPrice());
		vproduct.setStockQuantity(dto.getStockQuantity());
		vproduct.setProduct(product);
		return variantProductRepository.save(vproduct);
	}
	
	@Override
	public VariantProduct updateVProduct(Long id, VariantRequestDTO dto) {
		VariantProduct vproduct = variantProductRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND, "Variant Product not found"));
		Product product = productRepository.findById(dto.getProductId())
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND, "Product not found" ));
		vproduct.setSku(dto.getSku());
		vproduct.setColor(dto.getColor());
		vproduct.setSize(dto.getSize());
		vproduct.setPrice(dto.getPrice());
		vproduct.setStockQuantity(dto.getStockQuantity());
		vproduct.setProduct(product);
		return variantProductRepository.save(vproduct);
	}	
}
