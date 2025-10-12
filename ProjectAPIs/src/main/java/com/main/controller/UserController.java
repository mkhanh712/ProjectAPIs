package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.main.DTO.RegisterRequestDTO;
import com.main.entity.User;
import com.main.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody RegisterRequestDTO dto) {
		return userService.registerUser(dto);
	}
}
