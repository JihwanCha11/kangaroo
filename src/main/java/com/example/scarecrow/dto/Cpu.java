package com.example.scarecrow.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cpu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // CPU의 고유 식별자

    @Column(nullable = true)
    private String modelName; // CPU 모델명 (예: "코어13세대 i5-13400F 정품박스")

    @Column(nullable = true)
    private String manufacturer; // 제조사 (예: "INTEL")

    @Column(nullable = true)
    private String socketType; // 소켓 타입 (예: "소켓1700")

    @Column(nullable = true)
    private Integer coreCount; // 코어 수 (예: 10)

    @Column(nullable = true)
    private Integer threadCount; // 스레드 수 (예: 16)

    @Column(nullable = true)
    private Double baseClock; // 기본 클럭 (예: 2.5)

    @Column(nullable = true)
    private Double boostClock; // 부스트 클럭 (예: 4.6)

    @Column(nullable = true)
    private Integer cacheSize; // 캐시 크기 (예: 20)

    @Column(nullable = true)
    private Double tdp; // 열 전력 (예: 65)

    @Column(nullable = true)
    private Boolean integratedGraphics; // 내장 그래픽 지원 여부

    @Column(nullable = true)
    private String architecture; // 아키텍처 (예: "랩터레이크")

    @Column(nullable = true)
    private String memorySpecification; // 메모리 규격 (예: "DDR5")

    @Column(nullable = true)
    private Integer memorySpeed; // 메모리 속도 (예: 4800)

}
