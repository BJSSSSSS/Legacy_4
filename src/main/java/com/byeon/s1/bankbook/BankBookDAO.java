package com.byeon.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.byeon.s1.util.Pager;

@Repository
public class BankBookDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.byeon.s1.bankbook.BankBookDAO.";//final 넣는이유는 변경금지!
	
	//update
	public int update(BankBookDTO bankBookDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"update", bankBookDTO);
	}
	
	//insert
	public int add(BankBookDTO bankBookDTO) throws Exception{//누군가는 보내줘야함
		return sqlSession.insert(NAMESPACE+"add", bankBookDTO);
	}
	
	//delete
	public int delete(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", bankBookDTO);
	}
	
	//detail
	public BankBookDTO detail(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detail", bankBookDTO);
	}
	
	//list
	public List<BankBookDTO> list(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}
	
	//total(count)
	public Long total() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"total");
	}
	
}







