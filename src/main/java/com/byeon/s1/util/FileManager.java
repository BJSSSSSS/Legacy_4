package com.byeon.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	//내장객체임!
	@Autowired
	private ServletContext servletContext;
	
	
	public boolean remove(String path, String fileName) throws Exception{
		//파일을 HDD에서 삭제
		//저장된 폴더명, 저장된 파일명
		path = servletContext.getRealPath(path);
		
		//parent는 경로, child는 파일명
		File file = new File(path, fileName);
		
		return file.delete();
	}
	
	
	
	
	
	
	public String save(MultipartFile multipartFile, String path) throws Exception{
		//파일저장은 tomcat이 아니라 OS에서 저장
		//실제경로는 d드라이브에서 부터 찾는게 맞다 os는 그걸 찾아주는게 realPath
		//path=/resources/upload/member/
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		
		File file = new File(realPath);
		
//		System.out.println(file.exists()); // 실제로 폴더가 존재하느냐 있으면 true, 없으면 false
//		System.out.println(file.isDirectory()); // is로 시작하는 애들은 return이 true, false(경로지정한게 맞냐)
		
		if(!file.exists()) {
			//file.mkdir(); // 중간에 폴더가 없으면 에러
			file.mkdirs(); // 중간 폴더가 없으면 중간 폴더도 생성!(이것을 사용할것)
		}
		
		
		//1. 시간
		Calendar ca = Calendar.getInstance();
		long l = ca.getTimeInMillis();//현재 시간을 밀리세컨즈로 변환
		System.out.println("time : " + l);
		String oriName = multipartFile.getOriginalFilename(); //톰캣 정리.png(풀네임)
		//하나의 문자열을 여러개로 짜르는것 ! 파싱!!
		String fileName = l+"_"+oriName;
		System.out.println(fileName);
		
		
		//2. UUID
		fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + oriName;
		System.out.println("UUID : " + fileName);
		
		
		//file HDD에 저장
		// 1. MultipartFile 클래스의 transferTo 메서드 사용
		//file = new File(realPath, fileName);
		//file = new File(file, fileName);
		//multipartFile.transferTo(file);
		//이건 image가 저장되더라도 이클립스에선 가상 폴더에 저장이 되기때문에 가상폴더가 가끔 사라지는 경우가 있다
		//이것을 방지하기 위해!!! 꼭 내가 저장하고 싶은 이미지 파일은 직접 복사해서 넣어놓도록한다
		//그 가상폴더의 저장소는 위의 System.out.println(realPath); 에서 확인 가능하니까 이것도 유의하자
		
		// 2. FileCopyUtils
		file = new File(file, fileName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileName;
		
	}
	
	
	

}
