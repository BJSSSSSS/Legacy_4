package com.byeon.s1.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.byeon.s1.member.MemberDAO.";
	
	//login
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"login", memberDTO);
	}
	
	
	//join
	public int join(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"join", memberDTO);
	}

}
