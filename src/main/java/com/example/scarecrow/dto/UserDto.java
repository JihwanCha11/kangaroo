package com.example.scarecrow.dto;

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
public class UserDto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	//중복방지
    @Column(unique = true)
    private String username;

    
    private String password;
    
	/*
	 * @Column(unique = true) private String phone;
	 */
    @Column(unique = true)
    private String email;
    
}
