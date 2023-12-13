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
public class Mainboard implements Serializable {

	// 엔티티의 식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 메인보드 모델명
    @Column(nullable = true)
    private String modelName; // 예: "MAG B760M 박격포"

    // 소켓 타입 (예: 소켓1700)
    @Column(nullable = true)
    private String socketType; // 예: "소켓1700"

    // 칩셋 정보
    @Column(nullable = true)
    private String chipset; // 예: "인텔 B760"

    // 폼 팩터 (예: M-ATX)
    @Column(nullable = true)
    private String formFactor; // 예: "M-ATX"

    // 전원 공급 부분
    @Column(nullable = true)
    private int powerPhase; // 예: 14

    // 페이즈당 전류
    @Column(nullable = true)
    private int phaseAmperage; // 예: 75

    // 총 Vcore 출력 전류
    @Column(nullable = true)
    private int totalVcoreAmperage; // 예: 900

    // 메모리 타입 (예: DDR5)
    @Column(nullable = true)
    private String memoryType; // 예: "DDR5"

    // 메모리 속도
    @Column(nullable = true)
    private int memorySpeed; // 예: 7000

    // 메모리 슬롯 개수
    @Column(nullable = true)
    private int memorySlotCount; // 예: 4

    // 최대 메모리 용량
    @Column(nullable = true)
    private int maxMemoryCapacity; // 예: 192

    // XMP 버전
    @Column(nullable = true)
    private String xmpVersion; // 예: "XMP3.0"

    // 옵테인 지원 여부
    @Column(nullable = true)
    private boolean optaneSupport; // 예: true 또는 false

    // VGA 연결 정보
    @Column(nullable = true)
    private String vgaConnection; // 예: "PCIe5.0 x16"

    // PCIe 버전 정보
    @Column(nullable = true)
    private String pciExpressVersion; // 예: "PCIe5.0"

    // PCIe x16 슬롯 개수
    @Column(nullable = true)
    private int pciEx16Count; // 예: 1

    // PCIe x4 슬롯 개수
    @Column(nullable = true)
    private int pciEx4Count; // 예: 1

    // PCIe x1 슬롯 개수
    @Column(nullable = true)
    private int pciEx1Count; // 예: 1

    // M.2 슬롯 개수
    @Column(nullable = true)
    private int m2Count; // 예: 2

    // SATA3 포트 개수
    @Column(nullable = true)
    private int sata3Count; // 예: 4

    // 후면 패널 정보
    @Column(nullable = true)
    private String rearPanel; // 예: "HDMI / DP / USB 3.2 / USB 3.1 / USB 2.0 / RJ-45 / S/PDIF / 오디오잭"

    // LAN 칩셋 정보
    @Column(nullable = true)
    private String lanChipset; // 예: "Realtek 8125BG"

    // LAN 속도
    @Column(nullable = true)
    private int lanSpeed; // 예: 2.5 (단위: 기가비트)

    // 오디오 칩셋 정보
    @Column(nullable = true)
    private String audioChipset; // 예: "Realtek ALC897"

    // 오디오 채널 수
    @Column(nullable = true)
    private int audioChannels; // 예: 7.1

    // 내부 I/O 정보
    @Column(nullable = true)
    private String internalIO; // 예: "USB 3.0 헤더 , USB 2.0 헤더 , USB3.1 Type C 헤더, RGB 12V 4핀 헤더 , ARGB 5V 3핀 헤더"

    // USB 3.0 헤더 개수
    @Column(nullable = true)
    private int usb30HeaderCount; // 예: 1

    // USB 2.0 헤더 개수
    @Column(nullable = true)
    private int usb20HeaderCount; // 예: 1

    // 시스템 팬 4핀 개수
    @Column(nullable = true)
    private int systemFan4PinCount; // 예: 4

}
