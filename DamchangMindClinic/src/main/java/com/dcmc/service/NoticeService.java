package com.dcmc.service;

import java.util.List;

import com.dcmc.domain.Criteria;
import com.dcmc.domain.NoticeDTO;

public interface NoticeService {
	// 전체 글 목록
	public List<NoticeDTO> getList(Criteria cri);

	// 글 등록
	public void register(NoticeDTO notice);

	// 글 상세보기
	public NoticeDTO get(int bno);

	// 글 수정
	public boolean modify(NoticeDTO notice);

	// 글 삭제
	public boolean remove(int bno);

	// 전체 글 갯수
	public int getTotalCount();

}
