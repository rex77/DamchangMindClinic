package com.dcmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcmc.domain.Criteria;
import com.dcmc.domain.NoticeDTO;
import com.dcmc.mapper.NoticeMapper;

import lombok.extern.log4j.Log4j;


@Log4j
@Service
public class NorticeServiceImpl implements NoticeService {
	@Autowired
	NoticeMapper mapper;
	
	@Override
	public List<NoticeDTO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithCri(cri);
	}

	@Override
	public void register(NoticeDTO notice) {
		// TODO Auto-generated method stub
		mapper.insert(notice);
	}

	@Override
	public NoticeDTO get(int bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(NoticeDTO notice) {
		// TODO Auto-generated method stub
		return mapper.update(notice);
	}

	@Override
	public boolean remove(int bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno);
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return mapper.getTotalCount();
	}

}
