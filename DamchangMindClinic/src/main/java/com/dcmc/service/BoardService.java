package com.dcmc.service;

import java.util.List;

import com.dcmc.domain.BoardDTO;
import com.dcmc.domain.Criteria;

public interface BoardService {
	// 전체 글 목록
		public List<BoardDTO> getList(Criteria cri);
		
		// 글 등록
		public void register(BoardDTO board);
		
		// 글 상세보기
		public BoardDTO get(int bno);
		
		//비밀글보기
		public BoardDTO getSecretBoard(int bno, String password);
		
		// 글 수정
		public boolean modify(BoardDTO board);
		
		//답글여부 업데이트
		public boolean updateReply(int bno, String replyYn);
		
		// 글 삭제
		public boolean remove(int bno);
		
		// 전체 글 갯수
		public int getTotalCount();
		
}
