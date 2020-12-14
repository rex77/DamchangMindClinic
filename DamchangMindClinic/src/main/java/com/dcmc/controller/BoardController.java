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
import com.dcmc.domain.PageDTO;
import com.dcmc.service.BoardService;
import com.dcmc.service.ReplyService;

import lombok.extern.log4j.Log4j;


/*
 * 일반인용 질문게시판 기능을 담당하는 컨트롤러
 */
@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService bs;
	
	@Autowired
	ReplyService rs;

	
	/*
	 * public String getList(Criteria cri, Model model)
	 * 게시판 글 목록을 불러온다
	 */
	@GetMapping("/list")
	public String getList(Criteria cri, Model model) {
		model.addAttribute("list", bs.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, bs.getTotalCount()));
		System.out.println("개수 : " + bs.getTotalCount());
		return "board";
	}

	
	/*
	 * public String viewBoard(@RequestParam("bno") int bno, Model model)
	 * 게시글을 불러와 읽을 수 있는 뷰로 넘겨준다
	 */
	@GetMapping("/view")
	public String viewBoard(@RequestParam("bno") int bno, Model model) {
		// secret board
		BoardDTO board = bs.get(bno);
		if (board.getSecretYn().equals("y")) { //만약 본 게시글이 비밀글이라면
			model.addAttribute("bno", bno);
			return "password_view"; //패스워드 입력 페이지로 넘긴다
		} else { //비밀글이 아니라면
			model.addAttribute("board", board);
			if(board.getReplyYn().equals("y")) //만약 답글이 달려 있다면
				model.addAttribute("reply", rs.get(bno)); //답글 서비스에서 답글을 가져와 게시글과 함께 모델에 추가
			return "board_view"; //패스워드가 없는 일반 읽기용 뷰로 넘긴다
		}
	}

	
	/*
	 * public String passwordCheck(@RequestParam("password") String password, @RequestParam("bno") int bno, Model model)
	 * 패스워드 입력 페이지에서 패스워드를 입력하면 체크하는 메소드
	 * URI는 외부 접근을 막기 위해서 메소드만 post로 바꾸고 view라는 uri를 유지한다
	 */
	@PostMapping("/view")
	public String passwordCheck(@RequestParam("password") String password, @RequestParam("bno") int bno, Model model) {

		BoardDTO board = bs.get(bno);
		if (password == null) //오류 방지용 코드 : 비밀번호가 없는 비밀글이 있을 수가 있다. 그러나 뷰에서 무조건 비밀번호를 설정하게 개선함으로써 일어나지 않을 코드가 되었다.
			password = "";

		if (board.getPassword().equals(password)) { //비밀번호를 비교한다
			model.addAttribute("board", board);
			if(board.getReplyYn().equals("y"))
				model.addAttribute("reply", rs.get(bno));
			return "board_view";
		} else { //비밀번호가 틀렸을 경우
			return "wrong_password"; //패스워드가 틀렸다고 통지하는 페이지를 호출한다
		}

	}

	/*
	 * public String registerView()
	 * 게시글 작성 페이지를 불러온다
	 */
	@GetMapping("/register")
	public String registerView() {
		return "board_register";
	}

	/*
	 * public String register(BoardDTO board)
	 * 게시글 작성 페이지에서 작성한 게시글을 서버에 등록한다
	 */
	@PostMapping("/register")
	public String register(BoardDTO board) {
		System.out.println("secretYn : " + board.getSecretYn());
		if (board.getSecretYn() == null) //체크박스는 y 하나밖에 없으니 비밀글을 체크하지 않은 경우 SecretYn은 null이 된다
			board.setSecretYn("n");
		board.setShowYn("y");
		board.setReplyYn("n");
		System.out.println(board);
		bs.register(board);
		return "redirect:/board/list";
	}
	
	/*
	 * public String modifyView(@RequestParam("origBno") int bno, @RequestParam("password") String password, Model model)
	 * 게시글 수정 페이지를 불러온다 (게시글 작성 페이지와 같다)
	 */
	@GetMapping("/modify")
	public String modifyView(@RequestParam("origBno") int bno, @RequestParam("password") String password, Model model) {
		BoardDTO original = bs.get(bno);
		if (original.getPassword().equals(password)) { //게시글이 비밀글일 경우 비밀번호를 비교한다
			System.out.println(original.getSecretYn());
			model.addAttribute("board", original);
			return "board_register";
		} else {
			return "wrong_password";
		}
	}
	
	/*
	 * public String modify(@RequestParam("origBno") int bno, BoardDTO board) 
	 * 게시글 수정 페이지에서 수정한 게시글을 서버에서도 수정한다
	 */
	@PostMapping("/modify")
	public String modify(@RequestParam("origBno") int bno, BoardDTO board) {
		if(board.getSecretYn()==null)
			board.setSecretYn("n");
		bs.modify(board);
		return "redirect:/board/list";
	}
	

	/*
	 * public String remove(@RequestParam("bno") int bno, @RequestParam("password") String password)
	 * 게시글을 삭제한다
	 */
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno, @RequestParam("password") String password) {
		BoardDTO original = bs.get(bno);

		if (original.getPassword().equals(password)) { //항상 패스워드를 체크한다
			bs.remove(bno);
			return "redirect:/board/list";
		} else {
			return "wrong_password";
		}
	}
}
