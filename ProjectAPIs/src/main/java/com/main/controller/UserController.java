package com.main.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.main.DTO.RegisterRequestDTO;
import com.main.DTO.UserDTO;
import com.main.DTO.UserUpdateDTO;
import com.main.entity.User;
import com.main.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/public/register")
	/**
	 {
	 	"username": "aaa",
	 	"password": "aaaaa",
	 	"email": "aaa@gmail.com"
	 }
	 */
	public User registerUser(@Valid @RequestBody RegisterRequestDTO dto) {
		return userService.registerUser(dto);
	}
	
	@GetMapping("/user/me")
    public ResponseEntity<UserDTO> getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(userService.getCurrentUser(username));
    }
	
	/**
	 {
	 	"email": "aaa@gmail.com",
	 	"password": "aaaaa"
	 }
	 */
    @PutMapping("/user/updateme")
    public ResponseEntity<UserDTO> updateCurrentUser(@RequestBody UserUpdateDTO dto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(userService.updateCurrentUser(username, dto));
    }
}
