package com.example.scarecrow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.scarecrow.dto.Mainboard;
import com.example.scarecrow.repository.MainboardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MainboardService {
	
	private final MainboardRepository mainboardRepository;
	
	public List<Mainboard> getList() {
		return this.mainboardRepository.findAll();
	}

	public Mainboard getDetail(Long id) {return this.mainboardRepository.findById(id).get();}

}
