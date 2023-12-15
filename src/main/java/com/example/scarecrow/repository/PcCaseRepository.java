package com.example.scarecrow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.PcCase;
import com.example.scarecrow.dto.Cpu;


public interface PcCaseRepository extends JpaRepository<PcCase, Long>{
	
	Page<PcCase> findAll(Specification<PcCase> spec, Pageable pageable);
	
}
