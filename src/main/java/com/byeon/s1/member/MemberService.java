package com.byeon.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.byeon.s1.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	
	//fileDown(selectOne)
	public MemberFileDTO detailFile(MemberFileDTO memberFileDTO) throws Exception{
		return memberDAO.detailFile(memberFileDTO);
	}
	
	//mypage(selectOne)
	public MemberDTO mypage(MemberDTO memberDTO) throws Exception{
		return memberDAO.mypage(memberDTO);
	}
	
	//login(selectOne)
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return memberDAO.login(memberDTO);
	}
	
	//join(insert)
	public int join(MemberDTO memberDTO, MultipartFile photo) throws Exception{
		//먼저 멤버테이블에 insert하고 이후 
		int result = memberDAO.join(memberDTO);
		
		//1. 파일을 HDD에 저장
		String fileName = fileManager.save(photo, "resources/upload/member/");
		
		//2. 정보를 DB에 저장
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(photo.getOriginalFilename());
		// 멤퍼 파일 테이블에 insert해야 부모키 위반이 안된다
		result = memberDAO.addFile(memberFileDTO);
		
		return result; 
	}
	
	
	
}
