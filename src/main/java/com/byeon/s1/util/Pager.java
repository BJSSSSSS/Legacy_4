package com.byeon.s1.util;

public class Pager {

	
	private Long page;
	private Long perPage;
	private Long startRow;
	private Long lastRow;
	
	
	// 현재 페이지 조정
	public void rowMake() {
		this.startRow = (this.getPage()-1)*this.getPerPage() + 1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;
	
	public void numMake(Long totalCount) {
		
		// 전체 갯수
		//Long totalCount = 209L; 위에서 받자
		
		
		// 전체 페이지 갯수
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage = totalPage+1;
		}
		
		// 블럭당 갯수
		Long perBlock = 10L;
		
		// 전체 블럭 갯수
		Long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock = totalBlock+1;
		}
		
		// 페이지당 블럭 맞추기
		
		//	 1번 : 1 - 10
		//   2번 : 11 - 20
		
		//   page		BLOCK
		//	 1			1
		//   2			1
		//	 ...		
		//	 9			1
		//	 10			1
		//	 11			2
		//	 20			2
		//	 21			3
		
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
		
		//6. curBlock로 startNum, lastNum 구하기
		//	curBlock    startNum   	lastNum
		//	1			1		    10
		//	2			11			20
		//	3			21			30
		
		this.startNum = (curBlock-1)*perBlock +1;
		this.lastNum = curBlock*perBlock;
		
		this.pre = false;
		if(curBlock > 1) {
			this.pre = true;
		}
		
		this.next = false;
		if(curBlock < totalBlock) {
			this.next = true;
		}
		
		
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
	}
	
	
	
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}
	
	public void setPage(Long page) {
		this.page = page;
	}
	
	public Long getPerPage() {
		if(this.perPage == null || this.perPage < 1) {
			this.perPage = 10L;
		}
		return perPage;
	}
	
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}



	public Long getStartNum() {
		return startNum;
	}



	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}



	public Long getLastNum() {
		return lastNum;
	}



	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}



	public boolean isPre() {
		return pre;
	}



	public void setPre(boolean pre) {
		this.pre = pre;
	}



	public boolean isNext() {
		return next;
	}



	public void setNext(boolean next) {
		this.next = next;
	}


	
	
	
}
