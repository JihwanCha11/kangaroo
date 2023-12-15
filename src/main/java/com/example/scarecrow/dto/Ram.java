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
public class Ram {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // 모델 이름
    private String modelName;

    // RAM 용량 (GB)
    private Integer sizeInGB;

    // RAM 주파수 (MHz)
    private Integer frequency;

    // RAM 유형 (DDR5, DDR4 등)
    private String type;

    // 방열판의 여부
    private Boolean heatSpreader;

    // RAM 사용 용도 (PC, 노트북 등)
    private String usageDescription;

    // 메모리 타이밍 값들
    private Integer timingCAS; // CAS 지연 시간
    private Integer timingTRCD; // TRCD (RAS to CAS Delay) 시간
    private Integer timingTRP;  // TRP (Row Precharge Time) 시간
    private Integer timingTRAS; // TRAS (Active to Precharge Delay) 시간

}
