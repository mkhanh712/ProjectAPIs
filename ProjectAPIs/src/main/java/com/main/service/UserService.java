package com.main.service;

import com.main.DTO.RegisterRequestDTO;
import com.main.DTO.UserDTO;
import com.main.DTO.UserUpdateDTO;
import com.main.entity.User;

public interface UserService {
	User registerUser(RegisterRequestDTO dto);
	UserDTO getCurrentUser(String username);
	UserDTO updateCurrentUser(String username, UserUpdateDTO dto);
}
