package com.byeon.s1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.byeon.s1.util.Pager;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.byeon.s1.notice.NoticeDAO.";
	
//	public void check() {
//		System.out.println("확인");
//	}
	
	//list(전체출력)
	public List<NoticeDTO> list(Pager pager) throws Exception { // dao에서 안던졌는지 확인 test만 던졌는지
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}
	
	//total
	public Long total() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"total");
	}
	

	//detail(세부출력-한개)
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detail", noticeDTO);
	}
	
	//insert(추가)
	public int add(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add", noticeDTO);
	}
	
	//delete(삭제)
	public int delete(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", noticeDTO);
	}
	
	//update(수정)
	public int update(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"update", noticeDTO);
	}
	
	
	
	
	
	
}
