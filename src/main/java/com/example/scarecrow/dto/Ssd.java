package com.example.scarecrow.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ssd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // SSD 속성
    private String modelName;  // 모델명 (예: "MTE220S M.2 NVMe 2280 [512GB TLC]")
    private String brand;  // 브랜드 (예: "Transcend")
    private String usageDescription;  // 사용 용도 (예: "PC/노트북용")
    private String formFactor;  // SSD 포맷 (예: "M.2(NVMe)")
    private String interfaceType;  // 인터페이스 타입 (예: "PCIeGen3")
    private String capacity;  // 저장 용량 (예: "512GB")
    private String nandType;  // NAND 타입 (예: "TLC(3DNAND)")
    private String readSpeed;  // 읽기 속도 범위 (예: "3000~3990M")
    private String writeSpeed;  // 쓰기 속도 범위 (예: "2500~2990M")
    private String controller;  // SSD 컨트롤러 (예: "컨트롤러고정")
    private Boolean dramCache;  // DRAM 탑재 여부
    private Integer warranty;  // 보증 기간 (5년)
    private Integer length;  // SSD 길이 (예: 80mm)
	
}
