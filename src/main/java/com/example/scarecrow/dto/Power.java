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
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 파워 속성
    private String type;  // ATX 파워인지 등 파워의 유형을 나타냄 (예: "ATX", "MicroATX" 등)
    private Integer ratedOutput;  // 정격 출력 (W) (예: 500, 600 등)
    private String etaCertification;  // ETA 인증 등급 (BRONZE, GOLD 등) (예: "BRONZE", "GOLD" 등)
    private String lambdaCertification;  // LAMBDA 인증 등급 (예: "STANDARD+", "PLATINUM" 등)
    private String railType;  // +12V 레일 타입 (싱글 레일 등) (예: "싱글레일", "멀티레일" 등)
    private Integer available12VPercentage;  // +12V 가용률 (%) (예: 90, 100 등)
    private Boolean activePFC;  // 액티브 PFC 지원 여부 (예: true, false 등)
    private Integer powerFactor;  // 역률 (PF, %) (예: 95, 99 등)
    private Integer fanSize;  // 팬 크기 (mm) (예: 120, 140 등)
    private Integer depth;  // 깊이 (mm) (예: 120, 140 등)
    private Integer warranty;  // 보증 기간 (년) (예: 3, 5, 7 등)

    // 커넥터 정보
    private String mainPowerConnector;  // 메인 전원 커넥터 (예: "24핀(20+4)", "20핀" 등)
    private Integer auxiliaryPowerConnector;  // 보조 전원 커넥터 개수 (예: 1, 2 등)
    private Integer pcie8PinConnector;  // PCIe 8핀(6+2) 커넥터 개수 (예: 1, 2 등)
    private Integer sataConnector;  // SATA 커넥터 개수 (예: 4, 6 등)
    private Integer ide4PinConnector;  // IDE 4핀 커넥터 개수 (예: 2, 4 등)
	
}
