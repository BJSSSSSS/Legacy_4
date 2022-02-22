package com.byeon.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.byeon.s1.MyJUnitTest;

public class MemberDAOTest extends MyJUnitTest {

	@Autowired
	private MemberDAO memberDAO;
	
	//insert(join)
	//@Test
	public void joinTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("T2");
		memberDTO.setPw("P2");
		memberDTO.setName("N2");
		memberDTO.setPhone("010-5555-6667");
		memberDTO.setEmail("T2@NAVER.COM");
		int result = memberDAO.join(memberDTO);
		assertEquals(1, result);
	}
	
	//selectone(login)
	//@Test
	public void loginTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("T2");
		memberDTO.setPw("P2");
		memberDTO = memberDAO.login(memberDTO);
		assertNotNull(memberDTO);
	}
	
	//selectOne(mepage)
	//@Test
	public void mypageTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("T2");
		memberDTO = memberDAO.mypage(memberDTO);
		assertNotNull(memberDTO);		
	}
	
}
