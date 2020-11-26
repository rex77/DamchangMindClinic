package com.dcmc.mapper;

import com.dcmc.domain.ReplyDAO;

public interface ReplyMapper {
	public ReplyDAO read(int bno);
	
	public void insert(ReplyDAO reply);
	
	public boolean update(ReplyDAO reply);
	
	public boolean delete(int bno);
}
