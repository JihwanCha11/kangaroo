package com.example.scarecrow.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hdd {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // HDD 속성
    private String modelName;  // 모델명 (예: "BARRACUDA HDD 4TB ST4000DM004")
    private String brand;  // 브랜드 (예: "SEAGATE")
    private String type;  // HDD 유형 (PC용)
    private String formFactor;  // HDD 포맷 (8.9cm(3.5인치))
    private String capacity;  // 저장 용량 (4TB)
    private String interfaceType;  // 인터페이스 타입 (SATA3 (6Gb/s))
    private Integer rotationalSpeed;  // 회전 속도 (5,400RPM)
    private Integer cacheSize;  // 캐시 크기 (메모리 256MB)
    private Integer maxTransferRate;  // 최대 전송 속도 (최대 190MB/s)
    private Double thickness;  // 두께 (20.2mm)
    private Integer idleNoise;  // 소음(유휴) (22dB)
    private Integer seekNoise;  // 소음(탐색) (24dB)
    private Integer warranty;  // 보증 기간 (2년)
    private Boolean multiLayerCaching;  // 다층 캐싱(MTC) 지원 여부
    private Integer weight;  // 무게 (최대 490g)

}
