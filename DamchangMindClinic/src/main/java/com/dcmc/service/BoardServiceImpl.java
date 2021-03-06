package com.dcmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcmc.domain.BoardDTO;
import com.dcmc.domain.Criteria;
import com.dcmc.domain.BoardDTO;
import com.dcmc.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<BoardDTO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithCri(cri);
	}

	@Override
	public void register(BoardDTO board) {
		// TODO Auto-generated method stub
		mapper.insert(board);
	}

	@Override
	public BoardDTO get(int bno) {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public BoardDTO getSecretBoard(int bno, String password) {
		// TODO Auto-generated method stub
		BoardDTO board = mapper.read(bno);
		return board;
	}

	@Override
	public boolean modify(BoardDTO board) {
		// TODO Auto-generated method stub
		return mapper.update(board);
	}

	
	@Override
	public boolean remove(int bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno);
	}

	@Override
	public boolean updateReply(int bno, String replyYn) {
		// TODO Auto-generated method stub
		return mapper.updateReplyYn(bno, replyYn);
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return mapper.getTotalCount();
	}

}
