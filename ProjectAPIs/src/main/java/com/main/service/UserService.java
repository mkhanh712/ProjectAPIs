package com.main.service;

import com.main.DTO.RegisterRequestDTO;
import com.main.entity.User;

public interface UserService {
	User registerUser(RegisterRequestDTO dto);
}
