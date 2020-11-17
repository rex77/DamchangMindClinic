package com.dcmc.mapper;

import java.util.List;

import com.dcmc.domain.NoticeDAO;

public interface NoticeMapper {
	List<NoticeDAO> getList();
	
	public void insert(NoticeDAO notice);
	
	public NoticeDAO read(int bno);
	
	public boolean delete(int bno);
	
	public boolean update(NoticeDAO notice);
}
