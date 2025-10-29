package com.main.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.main.DTO.AddToCartRequest;
import com.main.DTO.CartLineItemDTO;
import com.main.DTO.CartResponseDTO;
import com.main.entity.Cart;
import com.main.entity.CartLineItem;
import com.main.entity.User;
import com.main.entity.VariantProduct;
import com.main.repository.CartLineItemRepository;
import com.main.repository.CartRepository;
import com.main.repository.UserRepository;
import com.main.repository.VariantProductRepository;
import com.main.service.CartService;

@Service
public class CartServiceImp implements CartService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartLineItemRepository cartLineItemRepository;
	@Autowired
	private VariantProductRepository variantProductRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public CartResponseDTO addProductToCart(String username, AddToCartRequest request) {
		User user = userRepository.findByUsername(username)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
		Cart cart = cartRepository.findByUser(user)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));
		VariantProduct variant = variantProductRepository.findById(request.getVariantProductId())
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Variant product not found"));
		CartLineItem item = cartLineItemRepository.findByCartAndVariantProduct(cart, variant)
	                .orElse(null);
		
		if (item == null) {
			item = new CartLineItem();
			item.setCart(cart);
			item.setVariantProduct(variant);
			item.setQuantity(request.getQuantity());
			item.setUnitPrice(variant.getPrice());
		} else {
			item.setQuantity(item.getQuantity() + request.getQuantity());
		}
		
		item.setTotalPrice(item.getQuantity() * item.getUnitPrice());
		cartLineItemRepository.save(item);
		
		List<CartLineItem> items = cart.getItems();
		if(!items.contains(item)){
			items.add(item);
		}
		
		items.forEach(i -> {
			VariantProduct v = i.getVariantProduct();
			if(i.getUnitPrice() != v.getPrice()) {
				i.setUnitPrice(v.getPrice());
				i.setTotalPrice(i.getQuantity() * v.getPrice());
				cartLineItemRepository.save(i);
			}
		});
		
		double totalPrice = items.stream()
				.mapToDouble(CartLineItem::getTotalPrice)
				.sum();
		
		return CartResponseDTO.builder()
				.cartId(cart.getId())
				.username(user.getUsername())
				.totalPrice(totalPrice)
				.items(items.stream()
						.map(i -> CartLineItemDTO.builder()
								.id(i.getId())
								.variantName(i.getVariantProduct().getProduct().getName())
		                        .color(i.getVariantProduct().getColor())
		                        .size(i.getVariantProduct().getSize())
		                        .quantity(i.getQuantity())
		                        .unitPrice(i.getUnitPrice())
		                        .totalPrice(i.getTotalPrice())
		                        .build())
						.collect(Collectors.toList()))
		                .build();
	}
}
