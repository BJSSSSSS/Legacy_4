package com.byeon.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.byeon.s1.MyJUnitTest;
import com.byeon.s1.util.Pager;

public class BankBookDAOTest extends MyJUnitTest{

	@Autowired
	private BankBookDAO bankBookDAO;
	
	//@Test
	public void check() {
		assertNotNull(bankBookDAO);
	}
	

	
	//Detail
	//@Test
	public void detailTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		//bankBookDTO = bankBookDAO.detail(2L);
		bankBookDTO = bankBookDAO.detail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}
	
	
	//List
	//@Test
	public void listTest() throws Exception{
		Pager pager = new Pager();
//		pager.setPage(1L);
		pager.setPerPage(5L);
		pager.makeRow();
			List<BankBookDTO> ar = bankBookDAO.list(pager);
			System.out.println(ar.get(0).getBookNumber());
			System.out.println(ar.get(4).getBookNumber());
			assertEquals(5, ar.size());
	//		for(int i=0; i<ar.size(); i++){
	//			System.out.println(ar.get(i).getBookName());
	//		}
	//		
	}
	
	//Insert
	//@Test
	public void addTest() throws Exception{
		
		
		for(int i=0; i<200; i++) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("bookName" + i);
			bankBookDTO.setBookContents("Contents" + i);
			
			double rate = Math.random();//0.0 ~ 1.0 미만의 double 타입 리턴! -> 0.12345678
			rate = rate*1000; //123.45678
			int r = (int)rate; //123
			rate = r/100.0; // 1.23 -> 이걸 밑에다 넣음 3자리를 맞추려고
			
			bankBookDTO.setBookRate(rate); // 총 3자리, 소숫점 2자리
			bankBookDTO.setBookSale(1);
			int result = bankBookDAO.add(bankBookDTO);
			
			if(i%10==0) {
				Thread.sleep(1000); // 1초동안 멈추세요
			}
			
			
		}
		System.out.println("Insert Finish");
		//assertEquals(1, result);
	}
	
	//Delete
	//@Test
	public void deleteTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(3L);
		int result = bankBookDAO.delete(bankBookDTO);
		
		assertEquals(1, result);
	}
	
}



