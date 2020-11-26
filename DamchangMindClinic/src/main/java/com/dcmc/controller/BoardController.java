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
import com.dcmc.service.ReplyService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService bs;
	
	@Autowired
	ReplyService rs;

	@GetMapping("/list")
	public String getList(Criteria cri, Model model) {
		model.addAttribute("list", bs.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, bs.getTotalCount()));
		System.out.println("개수 : " + bs.getTotalCount());
		return "board";
	}

	@GetMapping("/view")
	public String viewBoard(@RequestParam("bno") int bno, Model model) {
		// secret board
		BoardDAO board = bs.get(bno);
		if (board.getSecretYn().equals("y")) {
			model.addAttribute("bno", bno);
			return "password_view";
		} else {
			model.addAttribute("board", board);
			if(board.getReplyYn().equals("y"))
				model.addAttribute("reply", rs.get(bno));
			return "board_view";
		}
	}

	@PostMapping("/view")
	public String passwordCheck(@RequestParam("password") String password, @RequestParam("bno") int bno, Model model) {

		BoardDAO board = bs.get(bno);
		if (password == null)
			password = "";

		if (board.getPassword().equals(password)) {
			model.addAttribute("board", board);
			if(board.getReplyYn().equals("y"))
				model.addAttribute("reply", rs.get(bno));
			return "board_view";
		} else {
			return "wrong_password";
		}

	}

	@GetMapping("/register")
	public String registerView() {
		return "board_register";
	}

	@PostMapping("/register")
	public String register(BoardDAO board) {
		System.out.println("secretYn : " + board.getSecretYn());
		if (board.getSecretYn() == null)
			board.setSecretYn("n");
		board.setShowYn("y");
		board.setReplyYn("n");
		System.out.println(board);
		bs.register(board);
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno, @RequestParam("password") String password) {
		BoardDAO original = bs.get(bno);

		if (original.getPassword().equals(password)) {
			bs.remove(bno);
			return "redirect:/board/list";
		} else {
			return "wrong_password";
		}
	}

	@GetMapping("/modify")
	public String modifyView(@RequestParam("origBno") int bno, @RequestParam("password") String password, Model model) {
		BoardDAO original = bs.get(bno);
		if (original.getPassword().equals(password)) {
			System.out.println(original.getSecretYn());
			model.addAttribute("board", original);
			return "board_register";
		} else {
			return "wrong_password";
		}
	}

	@PostMapping("/modify")
	public String modify(@RequestParam("origBno") int bno, BoardDAO board) {
		board.setBno(bno);
		if(board.getSecretYn()==null)
			board.setSecretYn("n");
		bs.modify(board);
		//alert page 추가하기
		return "redirect:/board/list";
	}
}
