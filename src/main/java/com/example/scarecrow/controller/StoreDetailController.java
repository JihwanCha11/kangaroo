package com.example.scarecrow.controller;

import com.example.scarecrow.DataNotFoundException;
import com.example.scarecrow.dto.Cpu;
import com.example.scarecrow.dto.Gpu;
import com.example.scarecrow.dto.Mainboard;
import com.example.scarecrow.service.CpuService;
import com.example.scarecrow.service.GpuService;
import com.example.scarecrow.service.MainboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/storedetail")
@Controller
public class StoreDetailController {

    private CpuService cpuService;
    private GpuService gpuService;
    private MainboardService mainboardService;

    // 생성자주입
    @Autowired
    public StoreDetailController(
            CpuService cpuService,
            GpuService gpuService,
            MainboardService mainboardService
    ) {
        this.cpuService = cpuService;
        this.gpuService = gpuService;
        this.mainboardService = mainboardService;
    }

    // 임시로 getMapping part로 부품 이름을 받아서 특정DB와 연결.
    // @GetMapping("/{받는 목록 이름}/{id}")
    @GetMapping("/{partName}/{id}")
    public ModelAndView storeDetail(@PathVariable("id") Long id, @PathVariable("partName") String partName){

        ModelAndView modelAndView = new ModelAndView();

        switch (partName){
            case "cpu":
                Cpu cpu = cpuService.getDetail(id);
                modelAndView.addObject("partsData",cpu);
                break;
            case "gpu":
                Gpu gpu = gpuService.getDetail(id);
                modelAndView.addObject("partsData",gpu);
                break;
            case "mainboard":
                Mainboard mainboard = mainboardService.getDetail(id);
                modelAndView.addObject("partsData",mainboard);
                break;
            default:
                String error = "에러페이지 만들면 그걸로 대체해야됨";
                modelAndView.addObject("error","해당 상품은 존재하지 않습니다.");
        }

        modelAndView.setViewName("storeDetail/storeDetail");
        return modelAndView;
    }

    //partName으로 받은
    protected String partData(String partName){
        return partName;
    }


}
