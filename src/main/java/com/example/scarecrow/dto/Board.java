package com.example.scarecrow.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //게시판 주식별자
	
	@Column(length = 200)
    private String subject; //제목

    @Column(columnDefinition = "TEXT")
    private String content; //내용

    private LocalDateTime createDate; //작성시간
    
    @ManyToOne
    private UserDto user;
    
    private LocalDateTime modifyDate;
}
