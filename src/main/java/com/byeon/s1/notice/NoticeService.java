package com.byeon.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//list
	public List<NoticeDTO> list() throws Exception{
		return noticeDAO.list();
	}
	
	//detail
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.detail(noticeDTO);
	}
	
	//add
	public int add(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.add(noticeDTO);
	}
	
	//delete
	public int delete(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.delete(noticeDTO);
	}
	
	

}
