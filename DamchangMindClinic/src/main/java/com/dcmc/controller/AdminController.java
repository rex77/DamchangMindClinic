package com.dcmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcmc.domain.Criteria;
import com.dcmc.domain.PageDTO;
import com.dcmc.domain.ReplyDAO;
import com.dcmc.service.BoardService;
import com.dcmc.service.NoticeService;
import com.dcmc.service.ReplyService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	NoticeService ns;

	@Autowired
	BoardService bs;
	
	@Autowired
	ReplyService rs;
	
	@GetMapping("/notice/list") 
	public String getNotice(Criteria cri, Model model) {
		model.addAttribute("list", ns.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(cri, 123));
		return "admin_notice";
	}
	
	@GetMapping("/board/list") 
	public String getBoard(Criteria cri, Model model) {
		model.addAttribute("list", bs.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
		return "admin_board";
	}
	
	@GetMapping("/notice/view")
	public String viewNotice(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", ns.get(bno));
		return "admin_notice_view";
	}
	
	@GetMapping("/board/view") 
	public String viewBoard(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", bs.get(bno));
		return "admin_board_view";
	}
	
	@GetMapping("/board/remove")
	public String removeBoard(@RequestParam("bno") int bno, Model model) {
		bs.remove(bno);
		return "redirect:/admin/board/list";
	}
	
	@GetMapping("/reply/register")
	public String ViewRegisterReply(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", bs.get(bno));
		return "admin_reply_register";	
	}
	
	@PostMapping("/reply/register")
	public String registerReply(ReplyDAO reply, Model model) {
		System.out.println("reply : " + reply.toString());
		rs.register(reply);
		String redirectUrl = "redirect:/admin/board/view?bno=" + reply.getBno();
		return redirectUrl;	
	}
	
	public String ViewModifyReply(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", ns.get(bno));
		model.addAttribute("reply", null);
		return "admin_reply_register";	
	}
}
