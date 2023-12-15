package com.example.scarecrow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.Cpu;
import com.example.scarecrow.dto.Hdd;


public interface HddRepository extends JpaRepository<Hdd, Long>{
	
	Page<Hdd> findAll(Specification<Hdd> spec, Pageable pageable);
	
}
