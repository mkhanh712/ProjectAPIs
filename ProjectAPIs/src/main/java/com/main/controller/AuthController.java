package com.main.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.main.DTO.LoginRequestDTO;
import com.main.repository.UserRepository;
import com.main.security.JwtTokenProvider;
import com.main.entity.User;

@RestController
@RequestMapping("/api/auth")
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
		String token = jwtTokenProvider.generateToken(userOpt.get().getUsername());
		Map<String, Object> response = new HashMap<>();
		response.put("token", token);
		response.put("username", userOpt.get().getUsername());
		return ResponseEntity.ok(response);
		
	}
	
}
