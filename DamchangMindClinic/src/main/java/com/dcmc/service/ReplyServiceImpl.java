package com.dcmc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcmc.domain.ReplyDTO;
import com.dcmc.mapper.BoardMapper;
import com.dcmc.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	ReplyMapper rm;

	@Autowired
	BoardMapper bm;

	@Override
	public ReplyDTO get(int bno) {
		// TODO Auto-generated method stub
		return rm.read(bno);
	}

	@Override
	public void register(ReplyDTO reply) {
		// TODO Auto-generated method stub
		reply.getWriter();
		rm.insert(reply);
		bm.updateReplyYn(reply.getBno(), "y");
	}

	@Override
	public boolean modify(ReplyDTO reply) {
		// TODO Auto-generated method stub
		return rm.update(reply);
	}

	@Override
	public boolean remove(int bno) {
		// TODO Auto-generated method stub
		boolean result = rm.delete(bno);
		if (result == true) {
			bm.updateReplyYn(bno, "n");
		} 
		return result;
	}
}
