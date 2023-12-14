package com.example.scarecrow.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.scarecrow.DataNotFoundException;
import com.example.scarecrow.dto.UserDto;
import com.example.scarecrow.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	// 사용자 생성
	public UserDto create(String username, String email, String password) {
		UserDto user = new UserDto();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		this.userRepository.save(user);
		return user;
	}
	// 사용자 이름 가져오기
	public UserDto getUser(String username) {
		Optional<UserDto> user = this.userRepository.findByusername(username);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new DataNotFoundException("user not found");
		}
	}
}