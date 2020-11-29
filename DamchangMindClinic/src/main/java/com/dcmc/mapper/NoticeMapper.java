package com.dcmc.mapper;

import java.util.List;

import com.dcmc.domain.Criteria;
import com.dcmc.domain.NoticeDAO;

public interface NoticeMapper {
	List<NoticeDAO> getList();

	List<NoticeDAO> getListWithCri(Criteria cri);

	public NoticeDAO read(int bno);

	public void insert(NoticeDAO notice);

	public boolean update(NoticeDAO notice);

	public boolean delete(int bno);

	public int getTotalCount();
}
