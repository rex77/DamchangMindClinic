package com.dcmc.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dcmc.domain.BoardDTO;
import com.dcmc.domain.NoticeDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Autowired
	BoardMapper bm;
	
//	@Test
//	public void testGetListWithCri() {
//		Criteria cri = new Criteria();
//		bm.getListWithCri(cri).forEach(board->log.info("board 객체: "+board.getBno()));
//	}
	
//	@Test
//	public void testGetList() {
//		nm.getList().forEach(board->log.info("board 객체 내용 : " + board));
//	}
//	
//	
//	@Test
//	public void testInsert() {
//		BoardDAO notice = new BoardDAO();
//		notice.setTitle("질문 있습니다");
//		notice.setContent("질문 내용입니다");
//		notice.setWriter("까마귀");
//		notice.setShowYn("y");
//		notice.setSecretYn("n");
//		notice.setReplyYn("n");
//		notice.setPassword("0123");
//		bm.insert(notice);
//	}
//	
//	@Test
//	public void testUpdate() {
//		BoardDAO notice = new BoardDAO();
//		notice.setBno(3);
//		notice.setTitle("질문 바꿨습니다");
//		notice.setContent("질문 바꿨습니다");
//		notice.setWriter("백로");
//		notice.setSecretYn("y");
//		notice.setPassword("1234");
//		bm.update(notice);
//	}
//	
//	@Test
//	public void testDelete() {
//		bm.delete(4);
//	}
}
