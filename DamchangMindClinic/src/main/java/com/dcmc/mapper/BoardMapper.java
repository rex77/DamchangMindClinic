package com.dcmc.mapper;

import java.util.List;

import com.dcmc.domain.BoardDAO;
import com.dcmc.domain.Criteria;

public interface BoardMapper {
	List<BoardDAO> getList();
	
	List<BoardDAO> getListWithCri(Criteria cri);
	
	public void insert(BoardDAO notice);
	
	public BoardDAO read(int bno);
	
	public boolean delete(int bno);
	
	public boolean update(BoardDAO notice);
}
