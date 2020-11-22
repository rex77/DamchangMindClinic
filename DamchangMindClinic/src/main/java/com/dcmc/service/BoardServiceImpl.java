package com.dcmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcmc.domain.BoardDAO;
import com.dcmc.domain.Criteria;
import com.dcmc.domain.BoardDAO;
import com.dcmc.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<BoardDAO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithCri(cri);
	}

	@Override
	public void register(BoardDAO board) {
		// TODO Auto-generated method stub
		mapper.insert(board);
	}

	@Override
	public BoardDAO get(int bno) {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public BoardDAO getSecretBoard(int bno, String password) {
		// TODO Auto-generated method stub
		BoardDAO board = mapper.read(bno);
		if (password.equals(board.getPassword()))
			return board;
		else
			return null;
	}

	@Override
	public boolean modify(BoardDAO board) {
		// TODO Auto-generated method stub
		BoardDAO original = mapper.read(board.getBno());
		if(original.getPassword().equals(board.getPassword()))
			return mapper.update(board);
		else
			return false;
	}

	@Override
	public boolean remove(int bno, String password) {
		// TODO Auto-generated method stub
		BoardDAO board = mapper.read(bno);
		if(password.equals(board.getPassword()))
			return mapper.delete(bno);
		else
			return false;
	}

}
