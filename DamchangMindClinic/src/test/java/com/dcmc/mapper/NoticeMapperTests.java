package com.dcmc.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dcmc.domain.Criteria;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NoticeMapperTests {
	@Autowired
	NoticeMapper nm;
	
	@Test
	public void testGetListWithCri() {
		Criteria cri = new Criteria();
		nm.getListWithCri(cri).forEach(board->log.info("board 객체: "+board.getBno()));
	}
	
//	@Test
//	public void testGetList() {
//		nm.getList().forEach(board->log.info("board 객체 내용 : " + board));
//	}
//	
//	
//	@Test
//	public void testInsert() {
//		NoticeDAO notice = new NoticeDAO();
//		notice.setTitle("5678");
//		notice.setContent("5678");
//		notice.setWriter("admin");
//		notice.setShowYn("y");
//		nm.insert(notice);
//	}
//	
//	@Test
//	public void testUpdate() {
//		NoticeDAO notice = new NoticeDAO();
//		notice.setBno(14);
//		notice.setTitle("바뀐 5678");
//		notice.setContent("바뀌어버린 5678");
//		notice.setWriter("admin");
//		notice.setShowYn("y");
//		nm.update(notice);
//	}
//	
//	@Test
//	public void testDelete() {
//		nm.delete(10);
//	}
}
