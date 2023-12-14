package com.example.scarecrow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Long> {
	
	//사용자 조회
	Optional<UserDto> findByusername(String username);

}