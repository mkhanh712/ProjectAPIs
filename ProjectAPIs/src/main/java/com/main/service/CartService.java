package com.main.service;

import com.main.DTO.AddToCartRequest;
import com.main.DTO.CartResponseDTO;

public interface CartService {
	CartResponseDTO addProductToCart(String username, AddToCartRequest request);
}
