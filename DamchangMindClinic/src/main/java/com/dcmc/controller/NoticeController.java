package com.dcmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcmc.domain.Criteria;
import com.dcmc.domain.NoticeDAO;
import com.dcmc.domain.PageDTO;
import com.dcmc.service.NoticeService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	NoticeService ns;
	
	@GetMapping("/list") 
	public String getList(Criteria cri, Model model) {
		model.addAttribute("list", ns.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(cri, 123));
		return "notice";
	}
	
	@GetMapping("/view") 
	public String viewBoard(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", ns.get(bno));
		return "notice_view";
	}
	
	@PostMapping("/register") 
	public void register(NoticeDAO notice) {
		System.out.println("notice: " + notice.getContent());
		notice.setShowYn("y");
		ns.register(notice);
	}
	
	@GetMapping("/remove") 
	public void remove(int bno) {
		log.info("noticeController remove(): "+ns.remove(bno));
	}
	
	@PostMapping("/modify")
	public void modify(NoticeDAO notice) {
		log.info("noticeController modify(): "+ns.modify(notice));
	}
}
