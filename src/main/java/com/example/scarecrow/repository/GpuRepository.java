package com.example.scarecrow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.Gpu;

public interface GpuRepository extends JpaRepository<Gpu, Long>{

	Page<Gpu> findAll(Specification<Gpu> spec, Pageable pageable);
	
}
