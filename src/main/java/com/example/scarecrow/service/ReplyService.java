package com.example.scarecrow.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.scarecrow.dto.Board;
import com.example.scarecrow.dto.Reply;
import com.example.scarecrow.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {
	
	private final ReplyRepository replyRepository;
	
	//답변 등록
	public void create(Board board, String content) {
        Reply reply = new Reply();
        reply.setContent(content);
        reply.setCreateDate(LocalDateTime.now());
        reply.setBoard(board);
        this.replyRepository.save(reply);
    }
}
