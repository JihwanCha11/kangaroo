package com.example.scarecrow.controller;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.example.scarecrow.dto.Board;
import com.example.scarecrow.dto.BoardForm;
import com.example.scarecrow.dto.UserDto;
import com.example.scarecrow.service.BoardService;
import com.example.scarecrow.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class BoardCotroller {

	private final BoardService boardService;
	private final UserService userService;

	// 문의 목록
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
		Page<Board> paging = this.boardService.getList(page);
		model.addAttribute("paging", paging);
		return "board/board_list";
	}

	// 문의 상세
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Board board = this.boardService.getBoard(id);
		model.addAttribute("board", board);
		return "board/board_detail";
	}

	// 문의 등록
	@PreAuthorize("isAuthenticated()") // 로그인필요함
	@GetMapping("/create")
	public String boardCreate(BoardForm boardForm) {
		return "board/board_form";
	}

	// 문의 등록
	@PreAuthorize("isAuthenticated()") // 로그인필요함
	@PostMapping("/create")
	public String boardCreate(@Valid BoardForm boardForm, BindingResult bindingResult, Principal principal) {
		UserDto user = this.userService.getUser(principal.getName());
		if (bindingResult.hasErrors()) {
			return "board/board_form";
		}
		this.boardService.create(boardForm.getSubject(), boardForm.getContent(), user);
		return "redirect:/board/list"; // 질문 저장후 질문목록으로 이동
	}
	//문의 수정
	@PreAuthorize("isAuthenticated()")// 로그인필요함
	@GetMapping("/modify/{id}")
	public String boardModify(BoardForm boardForm, @PathVariable("id") Integer id, Principal principal) {
		Board board = this.boardService.getBoard(id);
		if (!board.getUser().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
		}
		boardForm.setSubject(board.getSubject());
		boardForm.setContent(board.getContent());
		return "board/board_form";
	}
	//문의 수정 
	@PreAuthorize("isAuthenticated()")// 로그인필요함
    @PostMapping("/modify/{id}")
    public String boardModify(@Valid BoardForm boardForm, BindingResult bindingResult, 
            Principal principal, @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "board/board_form";
        }
        Board board = this.boardService.getBoard(id);
        if (!board.getUser().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.boardService.modify(board, boardForm.getSubject(), boardForm.getContent());
        return String.format("redirect:/board/detail/%s", id);
    }
	//문의 삭제
	@PreAuthorize("isAuthenticated()")// 로그인필요함
    @GetMapping("/delete/{id}")
    public String boardDelete(Principal principal, @PathVariable("id") Integer id) {
		Board board = this.boardService.getBoard(id);
        if (!board.getUser().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.boardService.delete(board);
        return "redirect:/board/list";
    }
}
