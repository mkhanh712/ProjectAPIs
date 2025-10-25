package com.main.service;

import java.util.List;

import com.main.DTO.AddressDTO;

public interface AddressService {
	List<AddressDTO> getAddressesOfUser(String username);
	AddressDTO addAddressUser(String username, AddressDTO dto);
	AddressDTO updateAddressUser(String username, Long addressId, AddressDTO dto);
	void deleteAddress(String username, Long addressId);
}
