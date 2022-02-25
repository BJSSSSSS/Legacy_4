package com.byeon.s1.util;

public class Pager {

	
	//-------------- list에서 보여지는 page 가지고 오는것! ----------------
	
	//현재 페이지
	private Long page;
	
	//한페이지에 보고싶은 페이지 수
	private Long perPage;
	
	//페이지에서 시작(ex) 1~10)
	private Long startRow;
	
	//페이지에서 끝(ex) 1~10)
	private Long lastRow;

	
	public void makeRow() {
		// 1	1	10
		// 2	11	20
		// 3	21	30
		this.startRow = (this.getPage()-1)*this.getPerPage() +1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	
	//---------------- JSP에서 출력 --------------------
	
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;
	

	public void makeNum(Long totalCount) {
		
		//전체 갯수
		//Long totalCount = 212L;
		
		//전체 페이지 갯수
		Long totalPage = totalCount/perPage;
		if(totalCount%perPage != 0) {
			totalPage++;
		}
		
		//보고싶은 블럭당 갯수
		Long perBlock = 10L;
		
		//전체 블럭 갯수
		Long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		//page당 블럭 확인
		//page	block
		//1		1
		//2		1
		
		//10	1
		//11	2
		//12	2
		
		//21	3
		
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
		
				
		//	block	startNum	lastNum
		// 	1 		1			10
		//	2		11			20
		//	3		21			30
		
		
		//시작숫자
		this.startNum = (curBlock-1)*perBlock +1;
		this.lastNum = curBlock*perBlock;
		
		
		//이전
		this.pre = false;
		if(curBlock >1) {
			this.pre = true;
		}
		
		//다음
		this.next = false;
		if(curBlock < totalBlock) {
			this.next = true;
		}
		
		//마지막
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
