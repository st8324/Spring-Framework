package kr.green.spring.pagination;

public class Criteria {
	//한페이지당 보여지는 컨텐츠 수(게시글 수)
	private int perPageNum;
	//현재 페이지
	private int page;
	
	public int getPerPageNum() {
		return perPageNum;
	}
	public int getPage() {
		return page;
	}
	public void setPerPageNum(int perPageNum) {
		/* 	한페이지당 보여지는 게시글이 최소 5개 
		 * 	이상이 되도록 설정 */
		if(perPageNum <= 4)
			this.perPageNum = 5;
		this.perPageNum = perPageNum;
	}
	public void setPage(int page) {
		/*	현재 페이지가 1페이지 이상이 되도록 설정 */
		if(page <= 0 )
			this.page = 1;
		else
			this.page = page;
	}
	/*	쿼리문에서 limit를 사용할 때 가져올 컨텐츠의 시작 위치를
	 * 	계산하는 메소드로 xml에서 쿼리문에 #{startPage}를 호출할 때 
	 * 	getStartPage()가 호출됨 */
	public int getStartPage() {
		return (page-1)*perPageNum;
	}
	@Override
	public String toString() {
		return "Criteria [perPageNum=" + perPageNum + ", page=" + page + "]";
	}
	public Criteria() {
		page = 1;
		perPageNum = 10;
	}
}







