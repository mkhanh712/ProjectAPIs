package com.main.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	
}
