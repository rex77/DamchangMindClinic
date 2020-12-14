package com.dcmc.mapper;

import java.util.List;

import com.dcmc.domain.Criteria;
import com.dcmc.domain.NoticeDTO;

public interface NoticeMapper {
	List<NoticeDTO> getList();

	List<NoticeDTO> getListWithCri(Criteria cri);

	public NoticeDTO read(int bno);

	public void insert(NoticeDTO notice);

	public boolean update(NoticeDTO notice);

	public boolean delete(int bno);

	public int getTotalCount();
}
