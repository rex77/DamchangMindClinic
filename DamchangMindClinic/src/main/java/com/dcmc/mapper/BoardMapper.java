package com.dcmc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dcmc.domain.BoardDTO;
import com.dcmc.domain.Criteria;

public interface BoardMapper {
	List<BoardDTO> getList();

	List<BoardDTO> getListWithCri(Criteria cri);

	public BoardDTO read(int bno);

	public void insert(BoardDTO notice);

	public boolean update(BoardDTO notice);

	public boolean updateReplyYn(@Param("bno") int bno, @Param("replyYn") String replyYn);

	public boolean delete(int bno);

	public int getTotalCount();
}
