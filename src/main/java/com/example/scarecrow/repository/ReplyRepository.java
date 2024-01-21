package com.example.scarecrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scarecrow.dto.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{
	
}
