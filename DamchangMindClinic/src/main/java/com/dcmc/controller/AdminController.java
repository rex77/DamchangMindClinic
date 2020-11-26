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
import com.dcmc.domain.NoticeDAO;
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
		model.addAttribute("pageMaker",new PageDTO(cri, ns.getTotalCount()));
		return "admin_notice";
	}
	
	@GetMapping("/board/list") 
	public String getBoard(Criteria cri, Model model) {
		model.addAttribute("list", bs.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, bs.getTotalCount()));
		return "admin_board";
	}
	
	@GetMapping("/notice/view")
	public String viewNotice(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", ns.get(bno));
		return "admin_notice_view";
	}
	
	@GetMapping("/board/view") 
	public String viewBoard(@RequestParam("bno") int bno, Model model) {
		BoardDAO board = bs.get(bno);
		model.addAttribute("board", board);
		if(board.getReplyYn().equals("y"))
			model.addAttribute("reply", rs.get(bno));
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
	
	@GetMapping("/reply/modify")
	public String ViewModifyReply(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", bs.get(bno));
		model.addAttribute("reply", rs.get(bno));
		return "admin_reply_register";	
	}
	
	@PostMapping("/reply/modify")
	public String ModifyReply(ReplyDAO reply, Model model) {
		rs.modify(reply);
		String redirectUrl = "redirect:/admin/board/view?bno=" + reply.getBno();
		return redirectUrl;	
	}
	

	@GetMapping("/notice/register")
	public String ViewRegisterNotice(Model model) {
		return "admin_notice_register";	
	}
	
	@PostMapping("/notice/register") 
	public String registerNotice(NoticeDAO notice) {
		System.out.println(notice);
		notice.setShowYn("y");
		ns.register(notice);
		return "redirect:/admin/notice/list";
	}
	
	@GetMapping("/notice/remove") 
	public String remove(int bno) {
		ns.remove(bno);
		return "redirect:/admin/notice/list";
	}
	
	@GetMapping("/notice/modify")
	public String ViewModify(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", ns.get(bno));
		return "admin_notice_register";
	}
	
	@PostMapping("/notice/modify")
	public String modify(@RequestParam("origBno") int bno, NoticeDAO notice) {
		ns.modify(notice);
		String redirectUrl = "redirect:/admin/notice/view?bno=" + bno;
		return redirectUrl;
	}
}
