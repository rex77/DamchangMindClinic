package com.dcmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcmc.domain.NoticeDAO;
import com.dcmc.mapper.NoticeMapper;

import lombok.extern.log4j.Log4j;


@Log4j
@Service
public class NorticeServiceImpl implements NoticeService {
	@Autowired
	NoticeMapper mapper;
	
	@Override
	public List<NoticeDAO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public void register(NoticeDAO notice) {
		// TODO Auto-generated method stub
		mapper.insert(notice);
	}

	@Override
	public NoticeDAO get(int bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(NoticeDAO notice) {
		// TODO Auto-generated method stub
		return mapper.update(notice);
	}

	@Override
	public boolean remove(int bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno);
	}

}
