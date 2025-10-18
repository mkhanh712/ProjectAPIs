package com.main.serviceimp;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.main.DTO.RegisterRequestDTO;
import com.main.entity.User;
import com.main.entity.Cart;
import com.main.entity.Role;
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
		if(userRepository.findByUsername(dto.getUsername()).isPresent()){
			throw new RuntimeException("Username existed!");
		}
		String encodedPassword = passwordEncoder.encode(dto.getPassword());
		Role roleUser = roleRepository.findByName("ROLE_USER")
				.orElseThrow(() -> new RuntimeException("Role ROLE_USER chưa tồn tại!"));
		List<Role> roles = new ArrayList<>();
		roles.add(roleUser);
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setPassword(encodedPassword);
		user.setEmail(dto.getEmail());
		user.setRoles(roles);
		User savedUser = userRepository.save(user); //lưu user vào db trước
		Cart cart = new Cart();  
		cart.setUser(savedUser); //object cart được set thông tin của user đã lưu trước đó
		Cart savedCart = cartRepository.save(cart); //lưu cart vào db sau khi đã có user 
		savedUser.setCart(savedCart); //gắn cart vào obj savedCart vừa tạo để trả ra bên dưới
		return savedUser;//trả ra file json sau khi đky chứa các thông tin ở trên trong obj savedUser
	}
	
}
