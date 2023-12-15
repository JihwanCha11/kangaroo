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
public class PcCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String modelName;

    // 케이스 속성
    private String type;  // PC 케이스 유형 (예: "미들타워", "풀타워" 등)
    private String formFactor;  // PC 케이스 폼 팩터 (예: "ATX", "Micro-ATX", "Mini-ITX" 등)
    private Boolean includesPowerSupply;  // 파워 포함 여부 (예: true, false 등)
    private String motherboardCompatibility;  // 호환 가능한 마더보드 종류 (예: "Extended-ATX", "표준-ATX" 등)
    private Integer totalCoolingFans;  // 설치 가능한 전체 쿨링 팬 개수
    private Integer ledFans;  // LED 팬 개수
    private String sidePanel;  // 측면 패널 재질 (예: "강화유리")
    private String rearFan;  // 후면 팬 정보 (예: "140mm LED x1")
    private String frontFans;  // 전면 팬 정보 (예: "140mm LED x3")
    private Integer width;  // 케이스 너비 (mm)
    private Integer depth;  // 케이스 깊이 (mm)
    private Integer height;  // 케이스 높이 (mm)
    private Integer powerSupplyLength;  // 파워 장착 가능 길이 (mm)
    private String powerSupplyLocation;  // 파워 위치 (예: "하단후면")
    private Integer gpuLength;  // GPU 장착 가능 길이 (mm)
    private Integer cpuCoolerHeight;  // CPU 쿨러 장착 가능 높이 (mm)
    private Boolean rgbSupport;  // RGB 지원 여부
	
}
