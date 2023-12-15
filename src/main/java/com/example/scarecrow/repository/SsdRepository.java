package com.example.scarecrow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.Cpu;
import com.example.scarecrow.dto.Ssd;


public interface SsdRepository extends JpaRepository<Ssd, Long>{
	
	Page<Ssd> findAll(Specification<Ssd> spec, Pageable pageable);
	
}
