package com.main.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cart_line_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class CartLineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "variant_product_id")
	private VariantProduct variantProduct;
}
