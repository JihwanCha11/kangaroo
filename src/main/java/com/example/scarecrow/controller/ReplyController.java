package com.example.scarecrow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.scarecrow.dto.Board;
import com.example.scarecrow.service.BoardService;
import com.example.scarecrow.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/reply")
@RequiredArgsConstructor
@Controller
public class ReplyController {
		
	private final BoardService boardService;
	private final ReplyService replyService;
	
	//답변 등록
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content) {
        Board board = this.boardService.getBoard(id);
        this.replyService.create(board, content);
        return String.format("redirect:/board/detail/%s", id);
    }
}
