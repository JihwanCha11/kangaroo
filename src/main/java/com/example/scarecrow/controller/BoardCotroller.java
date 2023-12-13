package com.example.scarecrow.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.scarecrow.dto.Board;
import com.example.scarecrow.dto.BoardForm;
import com.example.scarecrow.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class BoardCotroller {
	
	private final BoardService boardService;
	//문의 목록
	 @GetMapping("/list")
	 public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
		 Page<Board> paging = this.boardService.getList(page);
	     model.addAttribute("paging", paging);
	     return "board/board_list";
	 }
	 //문의 상세
	 @GetMapping(value = "/detail/{id}")
	    public String detail(Model model, @PathVariable("id") Integer id) {
		 	Board board = this.boardService.getBoard(id);
	        model.addAttribute("board", board);
	        return "board/board_detail";
	    }
	 //문의 등록
	 @GetMapping("/create")
	    public String boardCreate(BoardForm boardForm) {
	        return "board/contact";
	    }
	 //문의 등록
	 @PostMapping("/create")
	    public String boardCreate(@Valid BoardForm boardForm, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "board/contact";
	        }
	     this.boardService.create(boardForm.getSubject(), boardForm.getContent());
		 return "redirect:/board/list"; // 질문 저장후 질문목록으로 이동
	    }

}
