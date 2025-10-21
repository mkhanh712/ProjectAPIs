package com.main.DTO;

import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Long id;
	private String username;
	private String email;
	private List<AddressDTO> addresses;
}
