package com.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.main.DTO.LoginRequestDTO;
import com.main.repository.UserRepository;
import com.main.security.JwtTokenProvider;
import com.main.entity.Role;
import com.main.entity.User;

@RestController
@RequestMapping("/api/public")
public class AuthController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDTO request){
		Optional<User> userOpt = userRepository.findByUsername(request.getUsername());
		if(userOpt.isEmpty() ||
			!passwordEncoder.matches(request.getPassword(), userOpt.get().getPassword())) {
			return ResponseEntity.badRequest().body(Map.of("error", "Invalid username or password"));
		}
		User user = userOpt.get();
		List<String> roleNames = user.getRoles()
				.stream()
				.map(Role::getName)
				.collect(Collectors.toList());
		String token = jwtTokenProvider.generateToken(user.getUsername(), roleNames);
		Map<String, Object> response = new HashMap<>();
		response.put("token", token);
		response.put("username", user.getUsername());
		response.put("roles", roleNames);
		return ResponseEntity.ok(response);
		
	}
	
}
