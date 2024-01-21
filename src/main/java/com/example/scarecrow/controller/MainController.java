package com.example.scarecrow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.scarecrow.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/scarecrow")
@Controller
public class MainController {
	
	
	@GetMapping("/")
    public String root() {
        return "/scarecrow_main";
    }
	
	@GetMapping("/main")
    public String scare() {
        return "/scarecrow_main";
    }
	
	
	@GetMapping("/a")
    public String a() {
        return "/a";
    }
}