package com.example.scarecrow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.scarecrow.dto.Gpu;
import com.example.scarecrow.repository.GpuRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GpuService {
	
	private final GpuRepository gpuRepository;
	
	public List<Gpu> getList() {
		return this.gpuRepository.findAll();
	}

	public Gpu getDetail(Long id){return this.gpuRepository.findById(id).get();}

}
