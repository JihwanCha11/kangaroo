package com.example.scarecrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.Gpu;

public interface GpuRepository extends JpaRepository<Gpu, Long>{

}
