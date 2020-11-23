package com.dcmc.service;

import java.util.List;

import com.dcmc.domain.BoardDAO;
import com.dcmc.domain.Criteria;

public interface BoardService {
	// 전체 글 목록
		public List<BoardDAO> getList(Criteria cri);
		
		// 글 등록
		public void register(BoardDAO board);
		
		// 글 상세보기
		public BoardDAO get(int bno);
		
		//비밀글보기
		public BoardDAO getSecretBoard(int bno, String password);
		
		// 글 수정
		public boolean modify(BoardDAO board);
		
		// 글 삭제
		public boolean remove(int bno);
		
}
