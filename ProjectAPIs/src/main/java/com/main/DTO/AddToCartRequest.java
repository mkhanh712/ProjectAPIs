package com.main.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartRequest {
	private Long variantProductId;
	private int quantity;
}
