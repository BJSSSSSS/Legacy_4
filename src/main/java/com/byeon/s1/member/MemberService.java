package com.byeon.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	//login(selectOne)
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return memberDAO.login(memberDTO);
	}
	
	//join(insert)
	public int join(MemberDTO memberDTO) throws Exception{
		return memberDAO.join(memberDTO);
	}
	
	
	
}
