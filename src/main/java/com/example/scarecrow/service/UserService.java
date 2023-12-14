package com.example.scarecrow.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.scarecrow.dto.UserDto;
import com.example.scarecrow.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
    
	//사용자 생성
	public UserDto create(String username, String email, String password) {
	UserDto user = new UserDto();
    user.setUsername(username);
    user.setEmail(email);
    user.setPassword(passwordEncoder.encode(password));
    this.userRepository.save(user);
    return user;
	 }
}