package com.main.repository;

import java.util.Optional;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Page<Product> findByCategoryId(Long categoryId, Pageable pageable);
	Optional<Product> findById(Long id);
}
