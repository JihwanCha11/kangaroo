package com.example.scarecrow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.scarecrow.dto.Mainboard;
import com.example.scarecrow.service.CpuService;
import com.example.scarecrow.service.GpuService;
import com.example.scarecrow.service.MainboardService;

import lombok.RequiredArgsConstructor;

// 견적서 페이지 컨트롤러
@RequiredArgsConstructor
@Controller
public class EstimationController {
	
	private final CpuService cpuService;
	private final GpuService gpuService;
	private final MainboardService mainboardService;
	
	@GetMapping("/estimation")
	public String estimation() {
		return "test";
	}

	@GetMapping("/estimation/rest")
	@ResponseBody
	public Object estimationRest(@RequestParam String component, @RequestParam(value="page", defaultValue="0") int page, @RequestParam(value = "kw", defaultValue = "") String kw) {
		if (component.equals("cpu")) {
			return cpuService.getList(page, kw);
		} else {
			return component;
		}
	}
	
}
