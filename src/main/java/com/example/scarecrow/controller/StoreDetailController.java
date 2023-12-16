package com.example.scarecrow.controller;

import com.example.scarecrow.service.BoardService;
import com.example.scarecrow.service.CpuService;
import com.example.scarecrow.service.GpuService;
import com.example.scarecrow.service.MainboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/storeDetail")
@Controller
public class StoreDetailController {

    private BoardService boardService;
    private CpuService cpuService;
    private GpuService gpuService;
    private MainboardService mainboardService;

    // 생성자주입
    @Autowired
    public StoreDetailController(
            BoardService boardService,
            CpuService cpuService,
            GpuService gpuService,
            MainboardService mainboardService
    ) {
        this.boardService = boardService;
        this.cpuService = cpuService;
        this.gpuService = gpuService;
        this.mainboardService = mainboardService;
    }




}
