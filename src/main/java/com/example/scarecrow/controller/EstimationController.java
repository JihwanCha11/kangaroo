package com.example.scarecrow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.scarecrow.dto.Mainboard;
import com.example.scarecrow.service.CpuService;
import com.example.scarecrow.service.GpuService;
import com.example.scarecrow.service.HddService;
import com.example.scarecrow.service.MainboardService;
import com.example.scarecrow.service.PcCaseService;
import com.example.scarecrow.service.PowerService;
import com.example.scarecrow.service.RamService;
import com.example.scarecrow.service.SsdService;

import lombok.RequiredArgsConstructor;

// 견적서 페이지 컨트롤러
@RequiredArgsConstructor
@Controller
public class EstimationController {
	
	private final CpuService cpuService;
	private final GpuService gpuService;
	private final HddService hddService;
	private final MainboardService mainboardService;
	private final PcCaseService pcCaseService;
	private final PowerService powerService;
	private final RamService ramService;
	private final SsdService ssdService;
	
	@GetMapping("/estimation")
	public String estimation() {
		return "estimation/estimation";
	}
	
	@GetMapping("/estimation/services")
	public String services() {
		return "services";
	}
	
	@GetMapping("/estimation/main")
	public String main() {
		return "scarecrow_main";
	}

	@GetMapping("/estimation/rest")
	@ResponseBody
	public Object estimationRest(@RequestParam String component, @RequestParam(value="page", defaultValue="0") int page, @RequestParam(value = "kw", defaultValue = "") String kw) {
		if (component.equals("cpu")) {
			return cpuService.getList(page, kw);
		} else if (component.equals("gpu")) {
			return gpuService.getList(page, kw);
		}else if (component.equals("hdd")) {
			return hddService.getList(page, kw);
		}else if (component.equals("mainboard")) {
			return mainboardService.getList(page, kw);
		}else if (component.equals("pcCase")) {
			return pcCaseService.getList(page, kw);
		}else if (component.equals("power")) {
			return powerService.getList(page, kw);
		}else if (component.equals("ram")) {
			return ramService.getList(page, kw);
		}else if (component.equals("ssd")) {
			return ssdService.getList(page, kw);
		} else {
			return component;
		}
	}
	
}
