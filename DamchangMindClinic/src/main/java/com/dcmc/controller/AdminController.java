package com.dcmc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcmc.domain.BoardDTO;
import com.dcmc.domain.Criteria;
import com.dcmc.domain.NoticeDTO;
import com.dcmc.domain.PageDTO;
import com.dcmc.domain.ReplyDTO;
import com.dcmc.service.BoardService;
import com.dcmc.service.NoticeService;
import com.dcmc.service.ReplyService;

import lombok.extern.log4j.Log4j;


/*
 * 관리자용 기능을 담당하는 컨트롤러
 */
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
	
	//admin - notice
	
	/*
	 * public String getNotice(Criteria cri, Model model)
	 * 공지사항 게시글 목록을 가져온다
	 */
	@GetMapping("/notice/list") 
	public String getNotice(Criteria cri, Model model) {
		model.addAttribute("list", ns.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(cri, ns.getTotalCount()));
		return "admin_notice";
	}
	
	/*
	 * public String viewNotice(@RequestParam("bno") int bno, Model model)
	 * 공지사항 게시글 하나를 가져와 읽는다 -> 관련 뷰로 넘겨줌
	 */
	@GetMapping("/notice/view")
	public String viewNotice(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", ns.get(bno));
		return "admin_notice_view";
	}
	
	//admin - board
	
	/*
	 * public String getBoard(Criteria cri, Model model)
	 * 질문게시판 게시글 목록을 가져온다
	 */
	@GetMapping("/board/list") 
	public String getBoard(Criteria cri, Model model) {
		model.addAttribute("list", bs.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, bs.getTotalCount()));
		return "admin_board";
	}
	
	/*
	 * public String viewBoard(@RequestParam("bno") int bno, Model model)
	 * 질문게시판 게시글 하나를 가져와 읽는다 -> 관련 뷰로 넘겨줌
	 */
	@GetMapping("/board/view") 
	public String viewBoard(@RequestParam("bno") int bno, Model model) {
		BoardDTO board = bs.get(bno);
		model.addAttribute("board", board);
		if(board.getReplyYn().equals("y"))
			model.addAttribute("reply", rs.get(bno));
		return "admin_board_view";
	}
	
	/*
	 * public String removeBoard(@RequestParam("bno") int bno, Model model)
	 * 질문게시판 게시글을 삭제한다
	 * 부적절한 게시글일 경우 사용하는 기능이다
	 */
	@GetMapping("/board/remove")
	public String removeBoard(@RequestParam("bno") int bno, Model model) {
		bs.remove(bno);
		return "redirect:/admin/board/list";
	}
	
	/*
	 * public String ViewRegisterReply(@RequestParam("bno") int bno, Model model)
	 * 답글 작성 페이지를 불러온다
	 */
	@GetMapping("/reply/register")
	public String ViewRegisterReply(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", bs.get(bno));
		return "admin_reply_register";	
	}
	
	/*
	 * public String registerReply(ReplyDTO reply, Model model)
	 * 답글 작성 페이지에서 작성한 답글을 실제 서버에 등록하는 과정
	 */
	@PostMapping("/reply/register")
	public String registerReply(ReplyDTO reply, Model model) {
		rs.register(reply);
		String redirectUrl = "redirect:/admin/board/view?bno=" + reply.getBno();
		return redirectUrl;	
	}
	
	/*
	 * public String ViewModifyReply(@RequestParam("bno") int bno, Model model)
	 * 기존에 작성된 답글을 불러와 답글 작성 페이지를 불러온다
	 */
	@GetMapping("/reply/modify")
	public String ViewModifyReply(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", bs.get(bno));
		model.addAttribute("reply", rs.get(bno)); //기존에 작성된 답글을 불러와 모델에 추가하는 점이 ViewRegisterReply()와 다른 점이다
		return "admin_reply_register";	
	}
	
	/*
	 * public String ModifyReply(ReplyDTO reply, Model model)
	 * 작성한 답글을 서버에서 수정한다
	 */
	@PostMapping("/reply/modify")
	public String ModifyReply(ReplyDTO reply, Model model) {
		rs.modify(reply);
		String redirectUrl = "redirect:/admin/board/view?bno=" + reply.getBno();
		return redirectUrl;	
	}
	
	/*
	 * public String ViewRegisterNotice(Model model)
	 * 공지사항을 등록하는 페이지를 불러온다
	 */
	@GetMapping("/notice/register")
	public String ViewRegisterNotice(Model model) {
		return "admin_notice_register";	
	}
	
	/*
	 * public String registerNotice(NoticeDTO notice)
	 * 작성한 공지사항을 서버에 등록한다
	 */
	@PostMapping("/notice/register") 
	public String registerNotice(NoticeDTO notice) {
		System.out.println(notice);
		notice.setShowYn("y"); //ShowYn == delete 여부 (y가 non-delete)
		ns.register(notice);
		return "redirect:/admin/notice/list";
	}
	
	/*
	 * public String remove(int bno)
	 * bno를 파라미터로 받아 작성한 공지사항을 삭제할 수 있다
	 */
	@GetMapping("/notice/remove") 
	public String remove(int bno) {
		ns.remove(bno);
		return "redirect:/admin/notice/list";
	}
	
	/*
	 * public String ViewModify(@RequestParam("bno") int bno, Model model)
	 * 공지사항을 수정하는 뷰를 불러온다 (register의 뷰와 같음)
	 */
	@GetMapping("/notice/modify")
	public String ViewModify(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", ns.get(bno)); //기존 글을 불러오는 과정, register에서는 없었던 부분
		return "admin_notice_register";
	}
	
	/*
	 * public String modify(@RequestParam("origBno") int bno, NoticeDTO notice)
	 * 작성한 글을 서버에 실제로 수정하는 과정
	 */
	@PostMapping("/notice/modify")
	public String modify(@RequestParam("origBno") int bno, NoticeDTO notice) {
		ns.modify(notice);
		String redirectUrl = "redirect:/admin/notice/view?bno=" + bno; //개선사항 : notice.getBno()로 수정 가능, 그러나 기존에 base가 된 method가 param으로 bno를 따로 받아오는 형태를 취하고 있기 때문에 이러한 형태가 되었다
		return redirectUrl;
	}
}
