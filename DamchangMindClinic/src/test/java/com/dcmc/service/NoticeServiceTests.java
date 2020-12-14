package com.dcmc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dcmc.domain.Criteria;
import com.dcmc.domain.NoticeDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NoticeServiceTests {
	@Autowired
	NoticeService ns;
	
	@Test
	public void testList() {
		log.info(ns.getList(new Criteria()));
	}
	
	@Test
	public void testGet() {
		log.info("get: " + ns.get(14));
	}
	
	@Test
	public void testRegister() {
		NoticeDTO notice = new NoticeDTO();
		notice.setTitle("5465");
		notice.setContent("5465");
		notice.setWriter("admin");
		notice.setShowYn("y");
		ns.register(notice);
	}

	@Test
	public void testUpdate() {
		NoticeDTO notice = new NoticeDTO();
		notice.setBno(14);
		notice.setTitle("바뀐 5465");
		notice.setContent("바뀌어버린 5465");
		notice.setShowYn("y");
		ns.modify(notice);
	}
	
	@Test
	public void testDelete() {
		boolean result = ns.remove(14);
		System.out.println("result: " + result);
	}
}
