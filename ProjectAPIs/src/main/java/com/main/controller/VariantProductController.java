package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.main.DTO.VariantProductDTO;
import com.main.DTO.VariantRequestDTO;
import com.main.entity.VariantProduct;
import com.main.service.VariantProductService;

@RestController
@RequestMapping("/vproducts")
public class VariantProductController {
	@Autowired
	private VariantProductService variantProductService;
	
	@PostMapping
	public VariantProduct createVProduct(@RequestBody VariantRequestDTO dto) {
		return variantProductService.createVProduct(dto);
	}
	
	@PutMapping("/vproductid={id}")
	public VariantProduct updateVProduct(@PathVariable long id, @RequestBody VariantRequestDTO dto) {
		return variantProductService.updateVProduct(id, dto);
	}
	
	@GetMapping("/getByProductId={productId}")
	public VariantProductDTO getByProductId(@PathVariable Long productId) {
		return variantProductService.getByProductId(productId);
	}
}
