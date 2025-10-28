package com.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Cart;
import com.main.entity.CartLineItem;
import com.main.entity.VariantProduct;

public interface CartLineItemRepository extends JpaRepository<CartLineItem, Long> {
    Optional<CartLineItem> findByCartAndVariantProduct(Cart cart, VariantProduct variantProduct);
}
