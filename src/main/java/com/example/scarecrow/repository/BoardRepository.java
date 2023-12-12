package com.example.scarecrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	
}
