package com.byeon.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.byeon.s1.MyJUnitTest;

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
		bankBookDTO = bankBookDAO.detail(2L);
		//bankBookDTO = bankBookDAO.detail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}
	
	
	//List
	//@Test
	public void listTest() throws Exception{
		List<BankBookDTO> ar = bankBookDAO.list();
		
		assertNotEquals(0, ar.size());
//		for(int i=0; i<ar.size(); i++){
//			System.out.println(ar.get(i).getBookName());
//		}
//		
	}
	
	//Insert
	//@Test
	public void addTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("t2");
		bankBookDTO.setBookContents("c2");
		bankBookDTO.setBookRate(3.1);
		bankBookDTO.setBookSale(1);
		int result = bankBookDAO.add(bankBookDTO);

		assertEquals(1, result);
	}
	
	//Delete
	@Test
	public void deleteTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(3L);
		int result = bankBookDAO.delete(bankBookDTO);
		
		assertEquals(1, result);
	}
	
}



