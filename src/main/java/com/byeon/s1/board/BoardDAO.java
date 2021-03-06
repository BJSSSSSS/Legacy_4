package com.byeon.s1.board;

import java.util.List;

import com.byeon.s1.util.Pager;

public interface BoardDAO {
	
	//detail
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//list
	public List<BoardDTO> list(Pager pager) throws Exception;
	
	//add
	public int add(BoardDTO boardDTO) throws Exception;
	
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO) throws Exception;
	
	//total
	public Long total(Pager pager) throws Exception;
	
	//addFile
	public int addFile(BoardFileDTO boardFileDTO) throws Exception;
	
	//detailFile
	public BoardFileDTO detailFile(BoardFileDTO boardFileDTO) throws Exception;
	
	//listFile
	public List<BoardFileDTO> listFile(BoardDTO boardDTO) throws Exception;
	
}





