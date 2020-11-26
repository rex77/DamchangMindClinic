package com.dcmc.service;

import com.dcmc.domain.ReplyDAO;

public interface ReplyService {
	public ReplyDAO get(int bno);
	
	public void register(ReplyDAO reply);
	
	public boolean modify(ReplyDAO reply);
	
	public boolean remove(int bno);
}
