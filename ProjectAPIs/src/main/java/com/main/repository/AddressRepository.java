package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
