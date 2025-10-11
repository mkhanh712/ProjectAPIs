package com.main.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.main.DTO.RegisterRequestDTO;
import com.main.entity.User;
import com.main.repository.CartRepository;
import com.main.repository.RoleRepository;
import com.main.repository.UserRepository;
import com.main.service.UserService;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User registerUser(RegisterRequestDTO dto) {
		return dto;
	}
	
}
