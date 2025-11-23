package com.main.service;

import com.main.DTO.OrderRequestDTO;
import com.main.DTO.OrderResponseDTO;

public interface OrderService {
	OrderResponseDTO placeOrder(String username, OrderRequestDTO dto);
}
