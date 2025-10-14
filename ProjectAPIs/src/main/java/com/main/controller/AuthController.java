package com.main.controller;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
}
