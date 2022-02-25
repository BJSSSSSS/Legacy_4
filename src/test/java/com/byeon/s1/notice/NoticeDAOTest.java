package com.byeon.s1.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.byeon.s1.MyJUnitTest;
import com.byeon.s1.util.Pager;

public class NoticeDAOTest extends MyJUnitTest {

	@Autowired
	private NoticeDAO noticeDAO; 
	
//	@Test
//	public void check() {
//		assertNotNull(noticeDAO);
//	}
	
	//@Test
	public void listTest(Pager pager) throws Exception{
		List<NoticeDTO> ar = noticeDAO.list(pager);
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void detailTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		noticeDTO = noticeDAO.detail(noticeDTO);
		assertNotNull(noticeDTO);
	}

	//lnsert
	//@Test
	public void addTest() throws Exception{
		for(int i=0; i<200; i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("t"+i);
			noticeDTO.setContents("c"+i);
			noticeDTO.setWriter("w"+i);
			int result = noticeDAO.add(noticeDTO);
		}
//		assertEquals(1, result);
	}
	
	//@Test
	public void deleteTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(3L);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void updateTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(4L);
		int result = noticeDAO.update(noticeDTO);
		assertEquals(1, result);
	}
	
	
}
