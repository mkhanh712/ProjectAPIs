package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.main.DTO.*;
import com.main.service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/user/cart/add")
    /**
	{
	  "variantProductId": x,
	  "quantity": x
	}
     */
    public CartResponseDTO addToCart(@RequestBody AddToCartRequest request, Authentication authentication) {
        String username = authentication.getName();
        return cartService.addProductToCart(username, request);
    }
}
