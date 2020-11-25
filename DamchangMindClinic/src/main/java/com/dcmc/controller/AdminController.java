package com.dcmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcmc.domain.Criteria;
import com.dcmc.domain.PageDTO;
import com.dcmc.service.BoardService;
import com.dcmc.service.NoticeService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	NoticeService ns;

	@Autowired
	BoardService bs;
	
	@GetMapping("/notice") 
	public String getNotice(Criteria cri, Model model) {
		model.addAttribute("list", ns.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(cri, 123));
		return "admin_notice";
	}
	
	@GetMapping("/board") 
	public String getBoard(Criteria cri, Model model) {
		model.addAttribute("list", bs.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
		return "admin_board";
	}
}
