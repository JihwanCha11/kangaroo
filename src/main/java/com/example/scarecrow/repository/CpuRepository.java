package com.example.scarecrow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.Cpu;


public interface CpuRepository extends JpaRepository<Cpu, Long>{
	
	Page<Cpu> findAll(Specification<Cpu> spec, Pageable pageable);
	
}
