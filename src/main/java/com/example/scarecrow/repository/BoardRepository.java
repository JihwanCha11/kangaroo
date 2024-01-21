package com.example.scarecrow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	//문의목록
	Page<Board> findAll(Pageable pageable);
	Page<Board> findAll(Specification<Board> spec, Pageable pageable);
}
