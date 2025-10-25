package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Address;
import com.main.entity.User;

public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findByUser(User user);
}
