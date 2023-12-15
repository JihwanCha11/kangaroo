package com.example.scarecrow.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.Mainboard;
import com.example.scarecrow.dto.Power;

public interface MainboardRepository extends JpaRepository<Mainboard, Long>{

	Page<Mainboard> findAll(Specification<Mainboard> spec, Pageable pageable);
	
}
