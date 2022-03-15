package com.byeon.s1.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.byeon.s1.member.MemberDAO.";
	
	//detailFile(업로드 된 사진파일 다운로드)
	public MemberFileDTO detailFile(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detailFile", memberFileDTO);
	}
		
	//addFile(회원가입시 사진파일 전송)
	public int addFile(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"addFile", memberFileDTO);
	}
	
	//mypage
	public MemberDTO mypage(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"mypage", memberDTO);
	}
	
	//login
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"login", memberDTO);
	}
	
	//join
	public int join(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"join", memberDTO);
	}

}
