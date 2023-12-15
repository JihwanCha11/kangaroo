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
public class Gpu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // GPU의 고유 식별자

    @Column(nullable = true)
    private String modelName; // GPU 모델명 (예: "GeForce RTX 4060 Ti 벤투스 2X 블랙 OC D6 8GB")
    
    @Column(nullable = true)
    private String manufacturer; // 제조사 (예: "AMD")

    @Column(nullable = true)
    private String series; // GPU 시리즈 (예: "RTX 4060 Ti")

    @Column(nullable = true)
    private String architecture; // GPU 아키텍처 (예: "4nm")

    @Column(nullable = true)
    private Integer fabricationProcess; // 제조 공정 (예: 4)

    @Column(nullable = true)
    private Integer boostClock; // 부스트 클럭 속도 (예: 2580)

    @Column(nullable = true)
    private Integer streamProcessors; // 스트림 프로세서 개수 (예: 4352)

    @Column(nullable = true)
    private String memoryType; // 메모리 타입 (예: "GDDR6")

    @Column(nullable = true)
    private Integer memorySize; // 메모리 크기 (예: 8)

    @Column(nullable = true)
    private String pciExpressVersion; // PCI Express 버전 (예: "PCIe4.0x16(at x8)")

    @Column(nullable = true)
    private Integer powerConsumption; // 소비 전력 (예: 160)

    @Column(nullable = true)
    private Integer ratedPower; // 정격 전원 (예: 550)

    @Column(nullable = true)
    private Integer fanCount; // 팬 개수 (예: 2)

    @Column(nullable = true)
    private String outputConnectors; // 출력 단자 (예: "HDMI2.1, DP1.4")

    @Column(nullable = true)
    private Boolean zeroDbTechnology; // 제로 데시벨 기술 지원 여부

    @Column(nullable = true)
    private Boolean supports8KResolution; // 8K 해상도 지원 여부

    @Column(nullable = true)
    private Boolean supports4KResolution; // 4K 해상도 지원 여부

    @Column(nullable = true)
    private Boolean supportsHDR; // HDR 지원 여부

    @Column(nullable = true)
    private String hdcpVersion; // HDCP 버전 (예: "HDCP 2.3")

    @Column(nullable = true)
    private String powerConnector; // 전원 커넥터 (예: "8핀 x1개")

    @Column(nullable = true)
    private Integer length; // 가로 길이 (예: 199)

    @Column(nullable = true)
    private Integer thickness; // 두께 (예: 42)

}
