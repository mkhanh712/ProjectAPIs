package com.main.service;

import com.main.DTO.VariantRequestDTO;
import com.main.entity.VariantProduct;

public interface VariantProductService {
	VariantProduct createVProduct(VariantRequestDTO dto);
	VariantProduct updateVProduct(Long id, VariantRequestDTO dto);
}
