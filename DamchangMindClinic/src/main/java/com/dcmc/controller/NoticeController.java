package com.dcmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcmc.domain.Criteria;
import com.dcmc.domain.NoticeDTO;
import com.dcmc.domain.PageDTO;
import com.dcmc.service.NoticeService;

import lombok.extern.log4j.Log4j;


/*
 * 일반인용 공지게시판 컨트롤러
 * 관리자용 기능은 AdminController에 정의되어있음(URI상 문제로 인하여)
 */
@Log4j
@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	NoticeService ns;
	
	/*
	 * public String getList(Criteria cri, Model model)
	 * 공지사항 게시글 리스트를 불러온다
	 */
	@GetMapping("/list") 
	public String getList(Criteria cri, Model model) {
		model.addAttribute("list", ns.getList(cri));
		System.out.println("개수 : " + ns.getTotalCount());
		model.addAttribute("pageMaker",new PageDTO(cri, ns.getTotalCount()));
		return "notice";
	}
	
	/*
	 * public String viewBoard(@RequestParam("bno") int bno, Model model)
	 * 공지사항 게시글을 불러온다.
	 */
	@GetMapping("/view") 
	public String viewBoard(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", ns.get(bno));
		return "notice_view";
	}
	
	//일반인이 접근할 수 있는 공지사항은 여기까지이다.
}
