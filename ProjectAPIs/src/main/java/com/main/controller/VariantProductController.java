package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	
	@GetMapping("/vproductid={id}")
	public VariantProduct updateVProduct(@PathVariable long id, @RequestBody VariantRequestDTO dto) {
		return variantProductService.updateVProduct(id, dto);
	}
}
