package com.example.scarecrow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.Cpu;
import com.example.scarecrow.dto.Ram;


public interface RamRepository extends JpaRepository<Ram, Long>{
	
	Page<Ram> findAll(Specification<Ram> spec, Pageable pageable);
	
}
