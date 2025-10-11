package com.main.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
	private String username;
	private String password;
	private String email;
}
