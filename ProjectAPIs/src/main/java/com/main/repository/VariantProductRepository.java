package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.VariantProduct;

@Repository
public interface VariantProductRepository extends JpaRepository<VariantProduct, Long> {
}
