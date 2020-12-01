package com.dcmc.mapper;

import com.dcmc.domain.ReplyDTO;

public interface ReplyMapper {
	public ReplyDTO read(int bno);
	
	public void insert(ReplyDTO reply);
	
	public boolean update(ReplyDTO reply);
	
	public boolean delete(int bno);
}
