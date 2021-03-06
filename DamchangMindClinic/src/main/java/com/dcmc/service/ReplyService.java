package com.dcmc.service;

import com.dcmc.domain.ReplyDTO;

public interface ReplyService {
	//게시글 번호에 맞는 답글을 불러온다
	public ReplyDTO get(int bno);
	
	//답글을 등록한다
	public void register(ReplyDTO reply);
	
	//답글을 수정한다
	public boolean modify(ReplyDTO reply);
	
	//답글을 삭제한다(사용되지 않는 기능)
	public boolean remove(int bno);
}
