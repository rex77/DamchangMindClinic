package com.dcmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcmc.domain.BoardDAO;
import com.dcmc.domain.Criteria;
import com.dcmc.domain.PageDTO;
import com.dcmc.service.BoardService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService bs;

	@GetMapping("/list")
	public String getList(Criteria cri, Model model) {
		model.addAttribute("list", bs.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(cri, 123));
		return "board";
	}

	@GetMapping("/view")
	public String viewBoard(@RequestParam("bno") int bno, Model model) {
		// secret board
		BoardDAO board = bs.get(bno);
		if (board.getSecretYn().equals("y")) {
			return "password_view";
		} else {
			model.addAttribute("board", bs.get(bno));
			return "board_view";
		}
	}

	@PostMapping("/view")
	public String passwordCheck(@RequestParam("password") String password, @RequestParam("bno") int bno, Model model) {
	
		BoardDAO board = bs.get(bno);
		if (board.getPassword().equals(password)) {
			model.addAttribute("board", bs.get(bno));
			return "board_view";
		}
		else
		{
			return "wrong_password";
		}
		
	}
	
	@PostMapping("/register")
	public void register(BoardDAO board) {
		System.out.println("board: " + board.getContent());
		log.info("boardController register(): ");
		board.setShowYn("y");
		bs.register(board);
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno, @RequestParam("password") String password) {
		log.info("boardController remove(): " + bs.remove(bno, password));
		return "redirect:/board/list";
	}

	@PostMapping("/modify")
	public String modify(BoardDAO board) {
		log.info("boardController modify(): " + bs.modify(board));
		return "redirect:/board/list";
	}
}
