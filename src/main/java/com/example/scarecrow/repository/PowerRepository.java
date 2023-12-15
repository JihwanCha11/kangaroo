package com.example.scarecrow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.Cpu;
import com.example.scarecrow.dto.Power;


public interface PowerRepository extends JpaRepository<Power, Long>{
	
	Page<Power> findAll(Specification<Power> spec, Pageable pageable);
	
}
